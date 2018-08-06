package landmarks;

import java.awt.Color;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;
import util.QRandom;

/**
 * The tree landmark
 * @author Quintin Harter
 *
 */
public class LandmarkTree extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[1];
	}
	
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
	public ResourceStack getHarvest(Resource toolType) {
		switch(toolType) {
		case WOOD: return new ResourceStack(Resource.WOOD, QRandom.randInt(20, 30));
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return new LandmarkGround();
	}
	
	@Override
	public Color getForegroundColor() {
		return new Color(19, 64, 0);
	}

}
