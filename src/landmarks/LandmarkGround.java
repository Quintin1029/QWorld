package landmarks;

import game.Library;
import game.PlayerStatManager;
import resources.ResourceStack;

/**
 * The default ground landmark ( )
 * @author Quintin Harter
 *
 */
public class LandmarkGround extends Landmark {

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
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return this;
	}

}
