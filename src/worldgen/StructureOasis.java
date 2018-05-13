package worldgen;

import game.WorldGenerator;
import landmarks.Landmark;
import landmarks.LandmarkSea;
import landmarks.LandmarkTree;
import util.QRandom;
import util.Vector;

public class StructureOasis extends Structure {

	@Override
	public void generate(Landmark[][] world, Vector topLeft) {
		IslandGenerator ig = new IslandGenerator(new Vector(9, 9), 4, 0.5);
		boolean [] [] map = ig.getIsland();
		for (int x = 0; x < map.length; x++)
			for(int y = 0; y < map[x].length; y++) {
				if (map[x][y])
					WorldGenerator.placeLandmark(world, new LandmarkSea(), new Vector(topLeft.getX() + x, topLeft.getY() + y));
				else if (QRandom.rollDie(0.1))
					WorldGenerator.placeLandmark(world, new LandmarkTree(), new Vector(topLeft.getX() + x, topLeft.getY() + y));
			}
	}

	@Override
	public Vector getSize() {
		return new Vector(7, 7);
	}

	@Override
	public String getName() {
		return "OASIS";
	}

}
