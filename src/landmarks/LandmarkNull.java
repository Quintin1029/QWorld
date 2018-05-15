package landmarks;

import java.awt.Color;

import game.Library;
import resources.ResourceStack;

/**
 * The null landmark
 * @author Quintin Harter
 *
 */
public class LandmarkNull extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_NULL;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public String getName() {
		return "Null";
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.BLACK;
	}
	
	@Override
	public Color getForegroundColor() {
		return Color.BLACK;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return this;
	}

}
