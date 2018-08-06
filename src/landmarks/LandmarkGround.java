package landmarks;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;

/**
 * The default ground landmark ( )
 * @author Quintin Harter
 *
 */
public class LandmarkGround extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[0];
	}
	
	@Override
	public char getChar() {
		return Library.LANDMARK_GROUND;
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public String getName() {
		return "Ground";
	}

	@Override
	public ResourceStack getHarvest(Resource toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return this;
	}

}
