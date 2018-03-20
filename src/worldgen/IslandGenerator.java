package worldgen;

import game.Library;
import game.WorldGenerator;
import landmarks.LandmarkSea;
import util.QRandom;
import util.Vector;

public class IslandGenerator {

	private boolean [] [] map;
	
	/**
	 * Constructor: generates a new random island
	 * @param size the size of the island to generate
	 * @param accuracy the accuracy (number of arms) to generate with. Think of the accuracy as the number of points on a star. The more points, the more jagged (but because we use squares it will just be weird). The less points, the more polygonal.
	 * @param bendRange the range o
	 */
	public IslandGenerator(Vector size, int accuracy, double bendRange) {
		//Generate the arms
		Vector [] arms = new Vector[accuracy];
		map = new boolean [size.getX()][size.getY()];
		Vector center = new Vector(size.getX() / 2, size.getY() / 2);
		
		double radius = Math.min(size.getX(), size.getY()) / 2;
		
		//generate the arms
		for (int i = 0; i < arms.length; i++) {
			double magnitude = QRandom.randDouble(bendRange * radius, radius);
			arms[i] = new Vector((int)(magnitude * Math.cos(i * 2 * Math.PI / accuracy)), (int)(magnitude * Math.sin(i * 2 * Math.PI / accuracy)));
		}
		
		//assign lake values
		for (int x = 0; x < size.getX(); x++) {
			for (int y = 0; y < size.getY(); y++) {
				map[x][y] = false;
				for (int i = 0; i < arms.length; i++) {
					if (map[x][y] == false)
						map[x][y] = new Vector(x, y).isInsideTriangle(center, center.add(arms[(i + 1) % arms.length]), center.add(arms[i]));
				}
			}
		}
	}
	
	
	
	public boolean [] [] getIsland() {
		return map;
	}
	
}
