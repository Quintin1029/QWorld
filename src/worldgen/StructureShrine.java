package worldgen;

import game.WorldGenerator;
import landmarks.Landmark;
import landmarks.LandmarkShrineBorder;
import landmarks.LandmarkShrineCenter;
import util.Vector;

public class StructureShrine extends Structure {

	@Override
	public void generate(Landmark[][] world, Vector topLeft) {
		WorldGenerator.placeLandmark(world, new LandmarkShrineCenter(), topLeft.add(new Vector(2, 2)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.SIDE), topLeft.add(new Vector(0, 2)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.SIDE), topLeft.add(new Vector(1, 2)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.SIDE), topLeft.add(new Vector(3, 2)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.SIDE), topLeft.add(new Vector(4, 2)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.TOP), topLeft.add(new Vector(2, 0)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.TOP), topLeft.add(new Vector(2, 1)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.TOP), topLeft.add(new Vector(2, 3)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.TOP), topLeft.add(new Vector(2, 4)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_LEFT), topLeft.add(new Vector(0, 0)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_LEFT), topLeft.add(new Vector(1, 1)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_LEFT), topLeft.add(new Vector(3, 3)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_LEFT), topLeft.add(new Vector(4, 4)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_RIGHT), topLeft.add(new Vector(4, 0)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_RIGHT), topLeft.add(new Vector(3, 1)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_RIGHT), topLeft.add(new Vector(1, 3)));
		WorldGenerator.placeLandmark(world, new LandmarkShrineBorder(LandmarkShrineBorder.DIAG_RIGHT), topLeft.add(new Vector(0, 4)));
	}

	@Override
	public Vector getSize() {
		return new Vector(5, 5);
	}

	@Override
	public String getName() {
		return "SHRINE";
	}

}
