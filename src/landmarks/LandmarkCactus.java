package landmarks;

import game.Library;
import resources.ResourceStack;

public class LandmarkCactus extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_CACTUS;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		switch(toolType) {
		case 0: return new ResourceStack(ResourceStack.GRASS, 1);
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return new LandmarkGround();
	}

	@Override
	public String getName() {
		return "Cactus";
	}

}
