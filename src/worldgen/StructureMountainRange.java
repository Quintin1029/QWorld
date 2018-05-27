package worldgen;

import game.WorldGenerator;
import landmarks.Landmark;
import landmarks.LandmarkMountain;
import util.Vector;

/**
 * Structure of a mountain range. Randomly generated using RangeGenerator.
 * NOT WORKING FIXME
 * @author Quintin Harter
 *
 */
public class StructureMountainRange extends Structure {

	public static final Vector SIZE = new Vector(50, 50);
	public static final int ARMS = 10;
	public static final double LENGTH_MIN = 20;
	public static final double WIDTH = 7;
	public static final double WIDTH_VARIANCE = 0.5;
	
	public boolean [] [] map;
	
	public StructureMountainRange() {
		RangeGenerator rangeGen = new RangeGenerator(LENGTH_MIN, Math.min(SIZE.getX(), SIZE.getY()), WIDTH - WIDTH * WIDTH_VARIANCE, WIDTH - WIDTH * WIDTH_VARIANCE, ARMS);
		map = rangeGen.getRange();
	}
	
	@Override
	public void generate(Landmark[][] world, Vector topLeft) {
		for (int x = 0; x < SIZE.getX(); x++)
			for (int y = 0; y < SIZE.getY(); y++)
				if (map[x][y] && !WorldGenerator.isInSpawnArea(new Vector(topLeft.getX() + x, topLeft.getY())))
					WorldGenerator.placeLandmark(world, new LandmarkMountain(), new Vector(topLeft.getX() + x, topLeft.getY() + y));
	}

	@Override
	public Vector getSize() {
		return SIZE;
	}

	@Override
	public String getName() {
		return "MOUNTAIN RANGE";
	}

}
