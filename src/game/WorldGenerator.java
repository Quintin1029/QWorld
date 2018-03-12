package game; 

import java.util.Random;

import landmarks.Landmark;
import landmarks.LandmarkHome;
import util.QRandom;
import util.Vector;
import zones.Zone;
import zones.ZonePlains;

public class WorldGenerator {
	
	public static Random random = new Random();

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
	
	public static Landmark [] [] generateWorld(Zone [] [] zones) {
		Library.print("Generating World...");
		//generate each zone of the world separately
		Landmark [] [] world = new Landmark[Library.WORLD_SIZE][Library.WORLD_SIZE];
		generateGround(world, zones);
		generateTrees(world, zones);
		generateUnique(world, zones);
		return world;
	}
	
	public static void generateGround(Landmark [] [] world, Zone [] [] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, new Vector(x, y));
				dropGround(world, zone, new Vector(x, y));
			}
		}
	}
	
	public static void generateTrees(Landmark [] [] world, Zone [] [] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, new Vector(x, y));
				if (QRandom.rollDie(zone.getTreeFrequency(0)))
					dropTree(world, zone, new Vector(x, y));
			}
		}
	}
	
	public static void generateUnique(Landmark [] [] world, Zone [] [] zones) {
		world[Library.WORLD_SIZE / 2][Library.WORLD_SIZE / 2] = new LandmarkHome();
	}
	
	public static Zone newRandomZone() {
		return new ZonePlains(); //TODO generate a new random zone
	}
	
	public static Zone getZoneAtPosition(Zone [] [] zones, Vector pos) {
		return zones[(int)(pos.getX() / Library.WORLD_SIZE * Library.ZONE_HEIGHT)][(int)(pos.getY() / Library.WORLD_SIZE * Library.ZONE_WIDTH)];
	}
	
	public static boolean dropGround(Landmark [] [] world, Zone zone, Vector pos) {
		try {
			world[pos.getX()][pos.getY()] = zone.getGroundLandmark();
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public static boolean dropTree(Landmark [] [] world, Zone zone, Vector pos) {
		try {
			world[pos.getX()][pos.getY()] = zone.getTreeLandmark(0);
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public static boolean dropPath(Landmark [] [] world, Zone zone, Vector pos) {
		try {
			world[pos.getX()][pos.getY()] = zone.getPathLandmark();
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
}
