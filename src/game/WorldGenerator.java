package game;

import java.util.Random;

import landmarks.Landmark;
import landmarks.LandmarkHome;
import landmarks.LandmarkHut;
import landmarks.LandmarkSea;
import util.QRandom;
import util.Vector;
import zones.*;

/**
 * The class used to generate the world based on the zones. Also contains some
 * static methods to get information from worlds.
 * 
 * @author Quintin Harter
 *
 */
public class WorldGenerator {

	public static Random random = new Random();

	/**
	 * Generates random zones in the grid
	 * 
	 * @return the grid generated
	 * @author Quintin Harter
	 */
	public static Zone[][] generateZones() {
		// generate random zones
		Zone[][] zones = new Zone[Library.ZONE_HEIGHT][Library.ZONE_WIDTH];
		for (int i = 0; i < zones.length; i++)
			for (int k = 0; k < zones[i].length; k++) {
				if (i == Library.ZONE_HEIGHT / 2 && k == Library.ZONE_WIDTH / 2)
					zones[i][k] = new ZonePlains();
				else
					zones[i][k] = newRandomZone();
				Library.print("Zone at (" + i + " , " + k + ") is of type " + zones[i][k].getName());
			}
		return zones;
	}

	/**
	 * Generates random landmarks based on the zones
	 * 
	 * @param zones
	 *            the zone grid generated before
	 * @return the world generated
	 * @author Quintin Harter
	 */
	public static Landmark[][] generateWorld(Zone[][] zones) {
		Library.print("Generating World...");
		// generate each zone of the world separately
		Landmark[][] world = new Landmark[Library.WORLD_SIZE][Library.WORLD_SIZE];
		generateGround(world, zones);
		generateTrees(world, zones);
		generateStructures(world, zones);
		generateUnique(world, zones);
		return world;
	}

	/**
	 * Generates ground landmarks at every position
	 * 
	 * @param world
	 *            the world to generate them in
	 * @param zones
	 *            the grid of zones for that world
	 * @author Quintin Harter
	 */
	public static void generateGround(Landmark[][] world, Zone[][] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, new Vector(x, y));
				dropGround(world, zone, new Vector(x, y));
			}
		}
	}

	/**
	 * Generates tree landmarks randomly at positions based on the tree frequencies
	 * of the zones
	 * 
	 * @param world
	 *            the world to generate them in
	 * @param zones
	 *            the grid of zones for that world
	 * @author Quintin Harter
	 */
	public static void generateTrees(Landmark[][] world, Zone[][] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				Zone zone = getZoneAtPosition(zones, new Vector(x, y));
				int index = 0;
				while (zone.getTreeLandmark(index) != null) {
					if (QRandom.rollDie(zone.getTreeFrequency(index)))
						dropTree(world, zone, new Vector(x, y), index);
					index++;
				}
			}
		}
	}

	/**
	 * Generates the structures randomly throughout the world based on the
	 * frequencies
	 * 
	 * @param world
	 *            the world to generate them in
	 * @param zones
	 *            the grid of zones for that world
	 */
	public static void generateStructures(Landmark[][] world, Zone[][] zones) {
		for (int x = 0; x < Library.WORLD_SIZE; x++) {
			for (int y = 0; y < Library.WORLD_SIZE; y++) {
				try {
					Zone zone = getZoneAtPosition(zones, new Vector(x, y));
					int index = 0;
					while (zone.getStructureFrequency(index) >= 0) {
						if (QRandom.rollDie(zone.getStructureFrequency(index))) {
							dropStructure(world, zone, new Vector(x, y), index);

							// x += zone.getStructure(index).getSize().getX();
							// y += zone.getStructure(index).getSize().getY();
						}
						index++;
					}

				} catch (ArrayIndexOutOfBoundsException e) {

				}

			}
		}
	}

	/**
	 * Generates unique landmarks at certain positions. Currently, the following are
	 * generated: ~ Home Landmark ~ Huts
	 * 
	 * @param world
	 *            the world to generate them in
	 * @param zones
	 *            the grid of zones for that world
	 * @author Quintin Harter
	 */
	public static void generateUnique(Landmark[][] world, Zone[][] zones) {
		placeLandmark(world, new LandmarkHome(), Vector.VECTOR_CENTER);
		dropHuts(world, zones);
	}

	private static void dropHuts(Landmark[][] world, Zone[][] zones) {
		// drops item huts throughout the world radially away as per Library reference variables
		Vector home = new Vector(Library.WORLD_SIZE / 2, Library.WORLD_SIZE / 2);
		//consumables
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_WATER_BOTTLE), Library.ITEM_WATER_BOTTLE_HUT_INNER_RADIUS, Library.ITEM_WATER_BOTTLE_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_LUNCH_BOX), Library.ITEM_LUNCH_BOX_HUT_INNER_RADIUS, Library.ITEM_LUNCH_BOX_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_MED_KIT), Library.ITEM_MED_KIT_HUT_INNER_RADIUS, Library.ITEM_LUNCH_BOX_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_STRENGTH_POTION), Library.ITEM_STRENGTH_POTION_HUT_INNER_RADIUS, Library.ITEM_STRENGTH_POTION_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_RUBY_SLIPPERS), Library.ITEM_RUBY_SLIPPERS_HUT_INNER_RADIUS, Library.ITEM_RUBY_SLIPPERS_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_SPEED_POTION), Library.ITEM_SPEED_POTION_HUT_INNER_RADIUS, Library.ITEM_SPEED_POTION_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_SHIELD), Library.ITEM_SHIELD_HUT_INNER_RADIUS, Library.ITEM_SHIELD_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_LUCK_POTION), Library.ITEM_LUCK_POTION_HUT_INNER_RADIUS, Library.ITEM_LUCK_POTION_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_CHAOS_TELEPORTER), Library.ITEM_CHAOS_TELEPORTER_HUT_INNER_RADIUS, Library.ITEM_CHAOS_TELEPORTER_HUT_OUTER_RADIUS, home);
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_FIREBALL), Library.ITEM_FIREBALL_HUT_INNER_RADIUS, Library.ITEM_FIREBALL_HUT_OUTER_RADIUS, home);
		//tools
		generateWithinRadiusOf(world, new LandmarkHut(LandmarkHut.ITEM_TYPE_STICK), Library.ITEM_STICK_HUT_INNER_RADIUS, Library.ITEM_STRENGTH_POTION_HUT_OUTER_RADIUS, home);
		//buildings
	}
	
	/**
	 * Generates a landmark within an inner and outer radius from a point. This will not generate the landmark over any solid landmarks.
	 * @param world the world to generate in
	 * @param toGenerate the landmark to generate
	 * @param innerRadius the inner radius (minimum distance from center)
	 * @param outerRadius the outer radius (maximum distance from center)
	 * @param centerPos the center position
	 */
	private static void generateWithinRadiusOf(Landmark[][] world, Landmark toGenerate, double innerRadius, double outerRadius, Vector centerPos) {
		// generate a random angle and a random length within the radii bounds
		double angle = QMath.getRandomAngle();
		double length = QRandom.randDouble(innerRadius, outerRadius);
		// create the landmark at the new position
		Vector posToDrop = centerPos.add(new Vector((int) (Math.cos(angle) * length), (int) (Math.sin(angle) * length)));
		if (world[posToDrop.getX()][posToDrop.getY()] == null || !world[posToDrop.getX()][posToDrop.getY()].getIsSolid()) {
			Library.print("Dropped a " + toGenerate.getName() + " at " + posToDrop.toString());
			placeLandmark(world, toGenerate, posToDrop);
		} else {
			generateWithinRadiusOf(world, toGenerate, innerRadius, outerRadius, centerPos);
		}
	}

	/**
	 * Generates a new random zone. Currently the following are generated: ~ Plains
	 * 
	 * @return the random zone generated
	 * @author Quintin Harter
	 */
	public static Zone newRandomZone() {
		int random = QRandom.randInt(0, 0);
		switch (random) {
		case 0:
			return new ZonePlains();
		// case 1: return new ZoneSea();
		}
		return null;
	}

	/**
	 * Gets the zone from a position in the world
	 * 
	 * @param zones
	 *            the grid of zones
	 * @param pos
	 *            the position to check
	 * @return the zone at that position
	 * @author Quintin Harter
	 */
	public static Zone getZoneAtPosition(Zone[][] zones, Vector pos) {
		Zone zone = zones[(int) (pos.getX() / (double) Library.WORLD_SIZE * Library.ZONE_HEIGHT)][(int) (pos.getY()
				/ (double) Library.WORLD_SIZE * Library.ZONE_WIDTH)];
		return zone;
	}

	/**
	 * Drops a ground landmark at the specified position
	 * 
	 * @param world
	 *            the world to drop the ground in
	 * @param zone
	 *            the grid of zones for that world
	 * @param pos
	 *            the position to drop the ground
	 * @return if we successfully dropped ground
	 * @author Quintin Harter
	 */
	public static boolean dropGround(Landmark[][] world, Zone zone, Vector pos) {
		return placeLandmark(world, zone.getGroundLandmark(), pos);
	}

	/**
	 * Drops a tree landmark at the specified position
	 * 
	 * @param world
	 *            the world to drop the tree in
	 * @param zone
	 *            the grid of zones for that world
	 * @param pos
	 *            the position to drop the tree
	 * @return if we successfully dropped the tree
	 * @author Quintin Harter
	 */
	public static boolean dropTree(Landmark[][] world, Zone zone, Vector pos, int index) {
		return placeLandmark(world, zone.getTreeLandmark(index), pos);
	}

	/**
	 * Drops a structure in the world
	 * 
	 * @param world
	 *            the world to drop the structure in
	 * @param zone
	 *            the zone to get the structure from
	 * @param pos
	 *            the position to generate the structure
	 * @param index
	 *            the index of the structure from that zone
	 * @return if we successfully dropped the structure
	 * @author Quintin Harter
	 */
	public static boolean dropStructure(Landmark[][] world, Zone zone, Vector pos, int index) {
		try {
			zone.getStructure(index).generate(world, pos);
			Library.print("Generated " + zone.getStructure(index).getName() + " at " + pos);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * Drops a path landmark at the specified position
	 * 
	 * @param world
	 *            the world to drop the path in
	 * @param zone
	 *            the grid of zones for that world
	 * @param pos
	 *            the position to drop the path
	 * @return if we successfully dropped path
	 * @author Quintin Harter
	 */
	public static boolean dropPath(Landmark[][] world, Zone zone, Vector pos) {
		return placeLandmark(world, zone.getPathLandmark(), pos);
	}
	
	public static boolean placeLandmark(Landmark[][] world, Landmark landmark, Vector pos) {
		try {
			world[pos.getX()][pos.getY()] = WGPL.getHigherPriority(world[pos.getX()][pos.getY()], landmark);
			return true;
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	/**
	 * Gets if the position is within the spawn radius
	 * 
	 * @param pos
	 *            the position to check
	 * @return if the position is in the spawn radius
	 * @author Quintin Harter
	 */
	public static boolean isInSpawnArea(Vector pos) {
		return pos.subtract(Vector.VECTOR_CENTER).getMagnitude() < Library.SPAWN_RADIUS;
	}

}
