package landmarks;

import java.awt.Color;

import game.Library;
import resources.ResourceStack;
import util.QRandom;

public class LandmarkMountain extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_MOUNTAIN_TOP;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		switch(toolType) {
		case Library.TOOL_ROCK: return new ResourceStack(ResourceStack.ROCK, QRandom.randInt(0, 5));
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return new LandmarkGround();
	}

	@Override
	public String getName() {
		return "Mountain";
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.GRAY;
	}

}
