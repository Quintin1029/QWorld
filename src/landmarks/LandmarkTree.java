package landmarks;

import java.awt.Color;

import game.Library;
import resources.ResourceStack;
import util.QRandom;

/**
 * The tree landmark
 * @author Quintin Harter
 *
 */
public class LandmarkTree extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_TREE;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public String getName() {
		return "Tree";
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		switch(toolType) {
		case Library.TOOL_WOOD: return new ResourceStack(ResourceStack.WOOD, QRandom.randInt(20, 30));
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return new LandmarkGround();
	}
	
	@Override
	public Color getForegroundColor() {
		return new Color(32, 125, 39);
	}

}
