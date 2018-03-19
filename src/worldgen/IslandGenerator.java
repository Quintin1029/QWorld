package worldgen;

import util.QRandom;
import util.Vector;

public class IslandGenerator {

	private boolean [] [] map;
	
	public IslandGenerator(Vector size, int accuracy, double bendRange) {
		//instantiate the map
		map = new boolean [size.getX()][size.getY()];
		//create temporary arm values
		double [] armMagnitudes = new double[accuracy];
		//create an array of vectors for each arm
		Vector [] arms = new Vector[accuracy];
		//load arms
		for (int i = 0; i < accuracy; i++) {
			armMagnitudes[i] = QRandom.randDouble(Math.min(size.getX() / 2,  size.getY() / 2) - bendRange, Math.min(size.getX() / 2,  size.getY() / 2));
			arms[i] = new Vector((int)(armMagnitudes[i] * Math.cos((2 * Math.PI) / accuracy * i)), (int)(armMagnitudes[i] * Math.sin((2 * Math.PI) / accuracy * i)));
		}
		//create the map
		for (int x = 0; x < size.getX(); x++) {
			for (int y = 0; y < size.getY(); y++) {
				//the value in the map returns true if that location is in the island
				map[x][y] = false;
				Vector pos = new Vector(x, y);
				for (int arm = 0; arm < accuracy; arm++) {
					if (pos.isInsideTriangle(Vector.VECTOR_ZERO, arms[arm], arms[(arm + 1) % accuracy]))
						map[x][y] = true;
				}
			}
		}
	}
	
	
	
	public boolean [] [] getIsland() {
		return map;
	}
	
	public static double lerp(double a, double b, double w) {
		return (1.0- w) * a + w * b;
	}
	
}
