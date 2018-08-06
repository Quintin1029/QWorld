package landmarks;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;

/**
 * The path landmark
 * @author Quintin Harter
 *
 */
public class LandmarkPath extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_PATH;
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public String getName() {
		return "Path";
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
