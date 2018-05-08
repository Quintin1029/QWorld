package worldgen;

import landmarks.Landmark;
import landmarks.LandmarkRuins;
import util.QRandom;
import util.Vector;

/**
 * Structure of ruins in the game world.
 * Randomly generates the blocks as follows:
 * Block size: 2-10 by 2-10 landmarks
 * Number of rows: 2-4
 * Number of columns: 2-4
 * Probability of ruins: 0.1-0.9
 * @author Quintin Harter
 *
 */
public class StructureRuins extends Structure {
	
	public static final int PATH_WIDTH = 3;
	
	public int rows;
	public int cols;
	public Vector blockSize;
	public double density;
	
	/**
	 * Constructor.
	 */
	public StructureRuins() {
		blockSize = new Vector(QRandom.randInt(2, 10), QRandom.randInt(2, 10));
		rows = QRandom.randInt(2, 4);
		cols = QRandom.randInt(2, 4);
		density = QRandom.randDouble(0.1, 0.9);
	}

	@Override
	public void generate(Landmark[][] world, Vector topLeft) {
		//generate random values for size and row/col num
		BlockGenerator bg = new BlockGenerator(blockSize, rows, cols, PATH_WIDTH, density);
		boolean [] [] map = bg.getMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y])
					world[topLeft.getX() + x][topLeft.getY() + y] = new LandmarkRuins();
			}
		}
	}

	@Override
	public Vector getSize() {
		return new Vector((blockSize.getX() + PATH_WIDTH) * rows, (blockSize.getY() + PATH_WIDTH) * cols);
	}

	@Override
	public String getName() {
		return "RUINS";
	}

}
