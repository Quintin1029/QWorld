package game;

import java.util.Random;

import landmarks.Landmark;
import util.Vector;
import zones.Zone;

/**
 * This class represents an instance of QWorld.
 * To run QWorld simply call .run();
 * 
 * @author Quintin Harter
 * @version 1.0.0
*/
public class Game {
	
	public Landmark[][] world; //represents the game world
	public Zone[][] zones; //represents the world divided into zones
	public Random random; //a random used to generate the world
	public UI ui; //the user interface
	public PlayerStatManager player; //the player
	
	/**
	 * Constructor
	 * @author Quintin Harter
	 */
	public Game() {
		Library.print("Running game...");
		zones = WorldGenerator.generateZones();
		world = WorldGenerator.generateWorld(zones);
		player = new PlayerStatManager(this); 
		ui = new UI(player);
		ui.run(this);
	}
	
	/**
	 * Attempts to move the player.
	 * 
	 * @author Quintin Harter
	 * @param direction the movement vector relative to the player
	 * @return if the player successfully moved
	 */
	public boolean attemptMove(Vector direction) {
		Library.print("Attempting move...");
		Vector newPos = player.getPosition().add(direction);
		//interact with the new landmark
		//only perform the move if we can move there
		boolean moved = false;
		if (getLandmarkAtPosition(newPos) != null && !getLandmarkAtPosition(newPos).getIsSolid()) {
			Library.print("Moving to location " + newPos);
			//move the player
			player.updatePosition(newPos);
			if (!player.attemptToMoveStrength())
				refreshPlayerStats();
			moved = true;
		} else {
			Library.print("Move failed. Solid Object. Current position " + player.getPosition());
		}
		getLandmarkAtPosition(newPos).interact(player, world);
		ui.redrawScreen(world, zones, (moved)? newPos : player.getPosition());
		return moved;
	}
	
	public void update() {
		//redraw the user interface
		ui.redrawScreen(world, zones, player.getPosition());
	}
	
	/**
	 * Updates the player's stats (food, water, etc.).
	 * This is called whenever the player moves.
	 * 
	 * @author Quintin Harter
	 */
	public void refreshPlayerStats() {
		player.updateWater(getNewWater());
		player.updateFood(getNewFood());
		Library.print(player.toString());
	}
	
	/**
	 * Retrieves the landmark at the position specified.
	 * 
	 * @param pos the position you want the landmark at
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
	 * Gets the amount of water left in the player after movement.
	 * Called by {@code refreshPlayerStats();}
	 * 
	 * @return the player's updated water supply
	 * @author Quintin Harter
	 */
	public double getNewWater() {
		return player.getWater() - 100 * WorldGenerator.getZoneAtPosition(zones, player.getPosition()).getTemperature();
	}
	
	/**
	 * Gets the amount of food left in the player after movement.
	 * Called by {@code refreshPlayerStats();}
	 * 
	 * @return the player's updated food supply
	 * @author Quintin Harter
	 */
	public double getNewFood() {
		return player.getFood() - 100 * Library.FOOD_LOSS_COEFFICIENT;
	}
	
	/**
	 * Kills the player.
	 * 
	 * @author Quintin Harter
	 */
	public void die() {
		//TODO add death routine
		Library.print("You died.");
	}
	
}
