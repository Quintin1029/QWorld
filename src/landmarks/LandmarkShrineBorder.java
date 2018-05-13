package landmarks;

import game.Library;
import resources.ResourceStack;

/**
 * The shrine border landmark
 * @author Quintin Harter
 *
 */
public class LandmarkShrineBorder extends Landmark{

	public static final int SIDE = 0;
	public static final int TOP = 1;
	public static final int DIAG_LEFT = 2;
	public static final int DIAG_RIGHT = 3;
	
	int type;
	
	public LandmarkShrineBorder(int type) {
		this.type = type;
	}
	
	@Override
	public char getChar() {
		switch(type) {
		case SIDE: return Library.LANDMARK_SHRINE_SIDE;
		case TOP: return Library.LANDMARK_SHRINE_TOP;
		case DIAG_LEFT: return Library.LANDMARK_SHRINE_DIAG_LEFT;
		case DIAG_RIGHT: return Library.LANDMARK_SHRINE_DIAG_RIGHT;
		default: return Library.LANDMARK_NULL;
		}
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return null;
	}

	@Override
	public String getName() {
		return "Landmark Side (type " + type + ")";
	}

}
