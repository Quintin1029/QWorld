package landmarks;

import java.awt.Color;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;

/**
 * The null landmark
 * @author Quintin Harter
 *
 */
public class LandmarkNull extends Landmark {

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
	public ResourceStack getHarvest(Resource toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return this;
	}

}
