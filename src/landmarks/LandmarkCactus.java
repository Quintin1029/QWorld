package landmarks;

import java.awt.Color;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;

/**
 * The cactus landmark
 * @author Quintin Harter
 *
 */
public class LandmarkCactus extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[4];
	}
	
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
		case 0: return new ResourceStack(Resource.GRASS, 1);
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return new LandmarkGround();
	}
	
	@Override
	public Color getForegroundColor() {
		return Color.GREEN;
	}

	@Override
	public String getName() {
		return "Cactus";
	}

}
