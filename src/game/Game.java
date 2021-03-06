package game;

import java.util.Random;

import items.Item;
import items.tools.ItemTool;
import landmarks.Landmark;
import resources.Resource;
import resources.ResourceStack;
import util.LoadingFrame;
import util.Vector;
import zones.Zone;

/**
 * This class represents an instance of QWorld. To run QWorld simply call
 * .run();
 * 
 * @author Quintin Harter
 * @version 1.0.0
 */
public class Game {

	public Landmark[][] world; // represents the game world
	public Zone[][] zones; // represents the world divided into zones
	public Random random; // a random used to generate the world
	public UI ui; // the user interface
	public PlayerStatManager player; // the player
	
	private int timeLeft = QMath.LARGE_NUMBER; //the time until the apocalypse

	/**
	 * Constructor
	 * 
	 * @author Quintin Harter
	 */
	public Game() {
		Library.print("Running game...");
		LoadingFrame lf = new LoadingFrame();
		//generate the world
		zones = WorldGenerator.generateZones(lf);
		world = WorldGenerator.generateWorld(zones, lf);
		player = new PlayerStatManager(this);
		ui = new UI(player);
		lf.kill();
		ui.run(this);
		//display the story
		if (!Library.DISABLE_STORY) {
			ui.displayDialogue(
					"Legend says of 30 items scattered throughout the world. When you get all of them, the path will be revealed.",
					"???");
			if (ui.displayYesNo("Show tutorial screen?", "???")) {
				ui.displayDialogue(
						"Move using the WASD keys. Use items you have gathered by clicking in the inventory panel to the right.",
						"???");
				ui.displayDialogue(
						"Your stat bars are displayed below the world. If you run out of food or water, your health will begin to deplete. If you run out of health, you die.",
						"???");
				ui.displayDialogue(
						"Your water will deplete faster in hot environments and slower in cold ones. Your food will do the opposite.",
						"???");
				ui.displayDialogue(
						"Use tool items to harvest materials from the world. Stand next to something you wish to harvest and use the tool.",
						"???");
				ui.displayDialogue("The resources you harvest will be displayed below the stat bars.", "???");
				ui.displayDialogue(
						"You can use resources to construct buildings using building items you collect. This will be important later in the game.",
						"???");
			}
			ui.displayDialogue("In exactly 15 days the apocalypse will come.", "???");
		}
		//begin the timer
		QTimer timer = new QTimer(ui, Library.APOCALYPSE_TIME);
		timer.start();
	}

	/**
	 * Attempts to move the player.
	 * 
	 * @author Quintin Harter
	 * @param direction
	 *            the movement vector relative to the player
	 * @return if the player successfully moved
	 */
	public boolean attemptMove(Vector direction) {
		Library.print("Attempting move...");
		Vector newPos = player.getPosition().add((player.attemptToMoveSpeed()) ? direction.multiply(2) : direction);
		// interact with the new landmark
		// only perform the move if we can move there
		boolean moved = false;
		if (getLandmarkAtPosition(newPos) != null && !getLandmarkAtPosition(newPos).getIsSolid()) {
			Library.print("Moving to location " + newPos);
			// move the player
			player.updatePosition(newPos);
			if (!player.attemptToMoveStrength())
				refreshPlayerStats();
			moved = true;
		} else {
			Library.print("Move failed. Solid Object. Current position " + player.getPosition());
		}
		getLandmarkAtPosition(newPos).interact(player, world, player.getPosition().add(direction));
		ui.redrawScreen(world, zones, (moved) ? newPos : player.getPosition());
		return moved;
	}

	/**
	 * Attempts to harvest the landmarks bordering the player.
	 * 
	 * @param tool
	 *            the tool to harvest with. THIS MUST BE A CHILD OF ITEMTOOL!!
	 * @param condition
	 *            a parameter used to pass along messages.
	 * @return if we successfully harvested any landmark
	 */
	public boolean attemptHarvest(Item tool, HarvestCondition condition) {
		Library.print("Attempting harvest");
		Vector[] positionsToHarvest = { player.getPosition().add(Vector.VECTOR_UP),
				player.getPosition().add(Vector.VECTOR_RIGHT), player.getPosition().add(Vector.VECTOR_DOWN),
				player.getPosition().add(Vector.VECTOR_LEFT) };

		boolean harvested = false;
		for (Vector position : positionsToHarvest) {
			Resource[] toolTypes = ((ItemTool) tool).getToolTypes();
			for (Resource toolType : toolTypes) {
				Landmark landmarkAtPos = world[position.getX()][position.getY()];
				ResourceStack result = landmarkAtPos.getHarvest(toolType);
				if (player.attemptToUseLuck())
					result.add(result);
				if (result != null) {
					player.addResource(result);
					world[position.getX()][position.getY()] = landmarkAtPos.getReplacementLandmark(condition);
					harvested = true;
				}
			}
		}
		ui.redrawScreen(world, zones, player.getPosition());
		return harvested;
	}

	/**
	 * Update the game: use this when you want the screen to be updated.
	 */
	public void update() {
		// redraw the user interface
		ui.redrawScreen(world, zones, player.getPosition());
	}

	/**
	 * Updates the player's stats (food, water, etc.). This is called whenever the
	 * player moves.
	 * 
	 * @author Quintin Harter
	 */
	public void refreshPlayerStats() {
		player.updateWater(getNewWater());
		player.updateFood(getNewFood());
		player.updateHealth(getNewHealth());
		if (player.getHealth() == 0)
			die();
		Library.print(player.toString());
	}
	
	/**
	 * Sends the time left to the game. Starts the apocalypse if necessary.
	 * @param time the time left in the game in seconds
	 */
	public void sendTime(int time) {
		timeLeft = time;
		if (timeLeft <= 0)
			startApocalypse();
	}
	
	/**
	 * Gets the time left in the game.
	 * @return the time left in the game in seconds
	 */
	public int getTime() {
		return timeLeft;
	}

	/**
	 * Retrieves the landmark at the position specified.
	 * 
	 * @param pos
	 *            the position you want the landmark at
	 * @return the landmark at that position
	 * @author Quintin Harter
	 */
	public Landmark getLandmarkAtPosition(Vector pos) {
		try {
			return world[pos.getX()][pos.getY()];
		} catch (ArrayIndexOutOfBoundsException e) {
			Library.print("Tried to get null landmark at " + pos);
			return null;
		}
	}

	/**
	 * Gets the amount of water left in the player after movement. Called by
	 * {@code refreshPlayerStats();}
	 * 
	 * @return the player's updated water supply
	 * @author Quintin Harter
	 */
	public double getNewWater() {
		return player.getWater() - 100 * WorldGenerator.getZoneAtPosition(zones, player.getPosition()).getTemperature();
	}

	/**
	 * Gets the amount of food left in the player after movement. Called by
	 * {@code refreshPlayerStats();}
	 * 
	 * @return the player's updated food supply
	 * @author Quintin Harter
	 */
	public double getNewFood() {
		return player.getFood() - 100 * Library.FOOD_LOSS_COEFFICIENT;
	}

	/**
	 * Gets the health lost from movement (if water and/or food are empty). Called
	 * by {@code refreshPlayerStats();}
	 * 
	 * @return
	 */
	private double getNewHealth() {
		double health = player.getHealth();
		health -= (player.getWater() == 0) ? 100 * Library.HEALTH_LOSS_COEFFICIENT : 0;
		health -= (player.getFood() == 0) ? 100 * Library.HEALTH_LOSS_COEFFICIENT : 0;
		return health;
	}

	/**
	 * Kills the player.
	 * 
	 * @author Quintin Harter
	 */
	public void die() {
		if (!Library.NO_DEATH) {
			ui.exit();
			Game g;
			if (ui.displayYesNo("You died... Play Again?", "..."))
				g = new Game();
			else
				System.exit(0);
		}
	}
	
	/**
	 * Begins the apocalypse. Currently this kills the player.
	 */
	public void startApocalypse() {
		//TODO implement a cool apocalypse???
		if (!Library.NO_APOCALYPSE) {
			Library.print("Beginning the apocalypse...");
			die();
		}
	}

}
