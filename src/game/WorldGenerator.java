package game; 

import java.util.Random;

import landmarks.Landmark;
import landmarks.LandmarkHome;
import util.QRandom;
import util.Vector;
import zones.Zone;
import zones.ZonePlains;

/**
 * The class used to generate the world based on the zones. Also contains some static methods to get information from worlds.
 * @author Quintin Harter
 *
 */
public class WorldGenerator {
	
	public static Random random = new Random();

	/**
	 * Generates random zones in the grid
	 * @return the grid generated
	 * @author Quintin Harter
	 */
	public static Zone [] [] generateZones() {
		//generate random zones
		Zone [] [] zones = new Zone[Library.ZONE_HEIGHT][Library.ZONE_WIDTH];
		for (int i = 0; i < zones.length; i++)
			for (int k = 0; k < zones[i].length; k++) {
				zones[i][k] = newRandomZone();
				Library.print("Zone at (" + i + " , " + k + ") is of type " + zones[i][k].getName());
			}
		return zones;
	}
	
	/**
	 * Generates random landmarks based on the zones
	 * @param zones the zone grid generated before
	 * @return the world generated
	 * @author Quintin Harter
	 */
	public static Landmark [] [] generateWorld(Zone [] [] zones) {
		Library.print("Generating World...");
		//generate each zone of the world separately
		Landmark [] [] world = new Landmark[Library.WORLD_SIZE][Library.WORLD_SIZE];
		generateGround(world, zones);
		generateTrees(world, zones);
		generateUnique(world, zones);
		return world;
	}
	
	/**
	 * Generates ground landmarks at every position
	 * @param world the world to generate them in
	 * @param zones the grid of zones for that world
	 * @author Quintin Harter
	 */
	public static void generateGround(Landmark [] [] world, Zone [] [] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, new Vector(x, y));
				dropGround(world, zone, new Vector(x, y));
			}
		}
	}
	
	/**
	 * Generates tree landmarks randomly at positions based on the tree frequencies of the zones
	 * @param world the world to generate them in
	 * @param zones the grid of zones for that world
	 * @author Quintin Harter
	 */
	public static void generateTrees(Landmark [] [] world, Zone [] [] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, new Vector(x, y));
				int index = 0;
				while(zone.getTreeLandmark(index) != null) {
					if (QRandom.rollDie(zone.getTreeFrequency(index)))
						dropTree(world, zone, new Vector(x, y), index);
					index++;
				}
			}
		}
	}
	
	/**
	 * Generates unique landmarks at certain positions. Currently, the following are generated:
	 * ~ Home Landmark
	 * 
	 * @param world the world to generate them in
	 * @param zones the grid of zones for that world
	 * @author Quintin Harter
	 */
	public static void generateUnique(Landmark [] [] world, Zone [] [] zones) {
		world[Library.WORLD_SIZE / 2][Library.WORLD_SIZE / 2] = new LandmarkHome();
	}
	
	/**
	 * Generates a new random zone. Currently the following are generated:
	 * ~ Plains
	 * @return the random zone generated
	 * @author Quintin Harter
	 */
	public static Zone newRandomZone() {
		return new ZonePlains(); //TODO generate a new random zone
	}
	
	/**
	 * Gets the zone from a position in the world
	 * @param zones the grid of zones
	 * @param pos the position to check
	 * @return the zone at that position
	 * @author Quintin Harter
	 */
	public static Zone getZoneAtPosition(Zone [] [] zones, Vector pos) {
		return zones[(int)(pos.getX() / Library.WORLD_SIZE * Library.ZONE_HEIGHT)][(int)(pos.getY() / Library.WORLD_SIZE * Library.ZONE_WIDTH)];
	}
	
	/**
	 * Drops a ground landmark at the specified position
	 * @param world the world to drop the ground in
	 * @param zone the grid of zones for that world
	 * @param pos the position to drop the ground
	 * @return if we successfully dropped ground
	 * @author Quintin Harter
	 */
	public static boolean dropGround(Landmark [] [] world, Zone zone, Vector pos) {
		try {
			world[pos.getX()][pos.getY()] = zone.getGroundLandmark();
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	/**
	 * Drops a tree landmark at the specified position
	 * @param world the world to drop the tree in
	 * @param zone the grid of zones for that world
	 * @param pos the position to drop the tree
	 * @return if we successfully dropped the tree
	 * @author Quintin Harter
	 */
	public static boolean dropTree(Landmark [] [] world, Zone zone, Vector pos, int index) {
		try {
			world[pos.getX()][pos.getY()] = zone.getTreeLandmark(index);
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	/**
	 * Drops a path landmark at the specified position
	 * @param world the world to drop the path in
	 * @param zone the grid of zones for that world
	 * @param pos the position to drop the path
	 * @return if we successfully dropped path
	 * @author Quintin Harter
	 */
	public static boolean dropPath(Landmark [] [] world, Zone zone, Vector pos) {
		try {
			world[pos.getX()][pos.getY()] = zone.getPathLandmark();
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
}
