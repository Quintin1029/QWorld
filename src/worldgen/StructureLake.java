package worldgen;

import game.Library;
import landmarks.Landmark;
import landmarks.LandmarkGround;
import landmarks.LandmarkSea;
import util.QRandom;
import util.Vector;

public class StructureLake extends Structure {
	
	public static final Vector SIZE = new Vector(30, 30);
	public static final int ARMS = 8;
	public static final double ARM_LOW_RANGE = 0.25;
	
	public StructureLake() {
		super();
	}

	@Override
	public Vector getSize() {
		return SIZE;
	}

	@Override
	public void generate(Landmark[][] world, Vector topLeft) {
		//Generate the arms
		Vector [] arms = new Vector[ARMS];
		boolean [] [] lake = new boolean [SIZE.getX()] [SIZE.getY()];
		Vector center = new Vector(SIZE.getX() / 2, SIZE.getY() / 2);
		
		double radius = Math.min(SIZE.getX(), SIZE.getY()) / 2;
		
		//generate the arms
		for (int i = 0; i < arms.length; i++) {
			double magnitude = QRandom.randDouble(ARM_LOW_RANGE * radius, radius);
			arms[i] = new Vector((int)(magnitude * Math.cos(i * 2 * Math.PI / ARMS)), (int)(magnitude * Math.sin(i * 2 * Math.PI / ARMS)));
		}
		
		Library.print("Generating lake at pos " + topLeft.toString() + " ... " + Library.arrayToString(arms));

		
		//assign lake values
		for (int x = 0; x < SIZE.getX(); x++) {
			for (int y = 0; y < SIZE.getY(); y++) {
				lake[x][y] = false;
				for (int i = 0; i < arms.length; i++) {
					if (lake[x][y] == false)
						lake[x][y] = new Vector(x, y).isInsideTriangle(center, center.add(arms[(i + 1) % arms.length]), center.add(arms[i]));
				}
				//push those values into the map
				if (lake[x][y])
					world[topLeft.getX() + x][topLeft.getY() + y] = new LandmarkSea();
			}
		}
		
	}

}
