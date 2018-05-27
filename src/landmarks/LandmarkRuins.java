package landmarks;

import java.awt.Color;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;
import util.QRandom;

/**
 * The ruins landmark.
 * @author Quintin Harter
 *
 */
public class LandmarkRuins extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[6];
	}
	
	@Override
	public char getChar() {
		return Library.LANDMARK_RUINS;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		switch(toolType) {
		case Library.TOOL_WOOD: return new ResourceStack(Resource.WOOD, QRandom.randInt(5, 20));
		case Library.TOOL_ROCK: return new ResourceStack(Resource.ROCK, QRandom.randInt(10, 30));
		case Library.TOOL_IRON: return new ResourceStack(Resource.IRON, QRandom.randInt(1, 5));
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return new LandmarkGround();
	}

	@Override
	public String getName() {
		return "Ruins";
	}
	
	@Override
	public Color getBackgroundColor() {
		return null; //new Color(38, 149, 47);
	}
	
	@Override
	public Color getForegroundColor() {
		return Color.DARK_GRAY;
	}

}
