package landmarks;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
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
	public ImageIcon getIcon() {
		//TODO add other types
		return Library.LANDMARK_ICONS[9];
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public ResourceStack getHarvest(Resource toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return null;
	}

	@Override
	public String getName() {
		return "Landmark Side (type " + type + ")";
	}

}
