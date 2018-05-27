package worldgen;

import game.WorldGenerator;
import landmarks.Landmark;
import landmarks.LandmarkSea;
import util.Vector;

/**
 * Structure of a lake. Randomly generated using IslandGenerator.
 * @author Quintin Harter
 *
 */
public class StructureLake extends Structure {
	
	public static final Vector SIZE = new Vector(30, 30);
	public static final int ARMS = 8;
	public static final double ARM_LOW_RANGE = 0.25;
	
	public boolean [] [] map;
	
	/**
	 * Constructor.
	 */
	public StructureLake() {
		IslandGenerator islandGen = new IslandGenerator(SIZE, ARMS, ARM_LOW_RANGE);
		map = islandGen.getIsland();
	}

	@Override
	public Vector getSize() {
		return SIZE;
	}

	@Override
	public void generate(Landmark[][] world, Vector topLeft) {
		for (int x = 0; x < SIZE.getX(); x++)
			for (int y = 0; y < SIZE.getY(); y++)
				if (map[x][y] && !WorldGenerator.isInSpawnArea(new Vector(topLeft.getX() + x, topLeft.getY() + y)))
					WorldGenerator.placeLandmark(world, new LandmarkSea(), new Vector(topLeft.getX() + x, topLeft.getY() + y));
	}

	@Override
	public String getName() {
		return "LAKE";
	}

}
