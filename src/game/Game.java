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
	
	Vector playerLocation;
	
	public Game() {
		Library.print("Running game...");
		zones = WorldGenerator.generateZones();
		world = WorldGenerator.generateWorld(zones);
		playerLocation = new Vector(Library.WORLD_SIZE / 2, Library.WORLD_SIZE / 2);
		ui = new UI();
		ui.run(this);
	}
	
	public void attemptMove(Vector direction) {
		Library.print("Attempting move...");
		Vector newPos = playerLocation.add(direction);
		//Library.print(getLandmarkAtPosition(newPos).getName());
		//only perform the move if we can move there
		if (getLandmarkAtPosition(newPos) != null && !getLandmarkAtPosition(newPos).getIsSolid()) {
			Library.print("Moving to location " + newPos);
			//move the player
			playerLocation = newPos; 
			ui.redrawScreen(world, newPos);
			//TODO add water & food loss
		} else
			Library.print("Move failed. Solid Object. Current position " + playerLocation);
		
	}
	
	public Landmark getLandmarkAtPosition(Vector v) {
		try {
			return world[v.getX()][v.getY()];
		} catch (ArrayIndexOutOfBoundsException e) {
			Library.print("Tried to get null landmark at " + v);
			return null;
		}
	}
	
}
