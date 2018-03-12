package game;

import java.util.Random;

import landmarks.Landmark;
import util.Vector;
import zones.Zone;

public class Game {
	
	public Landmark[][] world;
	public Zone[][] zones;
	public Random random;
	public UI ui;
	public PlayerStatManager player;
	
	
	public Game() {
		Library.print("Running game...");
		zones = WorldGenerator.generateZones();
		world = WorldGenerator.generateWorld(zones);
		player = new PlayerStatManager();
		ui = new UI(player);
		ui.run(this);
	}
	
	public void attemptMove(Vector direction) {
		Library.print("Attempting move...");
		Vector newPos = player.getPosition().add(direction);
		//Library.print(getLandmarkAtPosition(newPos).getName());
		//only perform the move if we can move there
		if (getLandmarkAtPosition(newPos) != null && !getLandmarkAtPosition(newPos).getIsSolid()) {
			Library.print("Moving to location " + newPos);
			//move the player
			player.updatePosition(newPos);
			refreshPlayerStats();
			ui.redrawScreen(world, zones, newPos);
			//TODO add water & food loss
		} else
			Library.print("Move failed. Solid Object. Current position " + player.getPosition());
		
	}
	
	public void refreshPlayerStats() {
		player.updateWater(getNewWater());
		player.updateFood(getNewFood());
		Library.print(player.toString());
		
		
	}
	
	public Landmark getLandmarkAtPosition(Vector v) {
		try {
			return world[v.getX()][v.getY()];
		} catch (ArrayIndexOutOfBoundsException e) {
			Library.print("Tried to get null landmark at " + v);
			return null;
		}
	}
	
	public double getNewWater() {
		return player.getWater() - 100 * WorldGenerator.getZoneAtPosition(zones, player.getPosition()).getTemperature();
	}
	
	public double getNewFood() {
		return player.getFood() - 100 * Library.FOOD_LOSS_COEFFICIENT;
	}
	
	public void die() {
		Library.print("You died.");
	}
	
}
