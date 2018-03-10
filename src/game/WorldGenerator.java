package game; 

import landmarks.Landmark;
import zones.Zone;
import zones.ZonePlains;

public class WorldGenerator {

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
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, x, y);
				dropGround(world, zone, x, y);
			}
		}
		return world;
	}
	
	public static Zone newRandomZone() {
		return new ZonePlains(); //TODO generate a new random zone
	}
	
	public static Zone getZoneAtPosition(Zone [] [] zones, int x, int y) {
		return zones[(int)(x / Library.WORLD_SIZE * Library.ZONE_HEIGHT)][(int)(y / Library.WORLD_SIZE * Library.ZONE_WIDTH)];
	}
	
	public static boolean dropGround(Landmark [] [] world, Zone zone, int x, int y) {
		try {
			world[x][y] = zone.getGroundLandmark();
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public static boolean dropPath(Landmark [] [] world, Zone zone, int x, int y) {
		try {
			world[x][y] = zone.getPathLandmark();
			return true;
		} catch(ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}
	
}
