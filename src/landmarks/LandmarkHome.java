package landmarks;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.ResourceStack;

/**
 * The home landmark (H)
 * @author Quintin Harter
 *
 */
public class LandmarkHome extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[3];
	}
	
	@Override
	public char getChar() {
		return Library.LANDMARK_HOME;
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public String getName() {
		return "Home";
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return this;
	}

}
