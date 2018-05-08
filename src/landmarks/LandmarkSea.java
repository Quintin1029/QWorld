package landmarks;

import java.awt.Color;

import game.Library;
import resources.ResourceStack;

public class LandmarkSea extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_SEA;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public String getName() {
		return "Sea";
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.BLUE;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return null;
	}

}
