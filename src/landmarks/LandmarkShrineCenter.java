package landmarks;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;
import util.Vector;

/**
 * The shrine center landmark
 * @author Quintin Harter
 *
 */
public class LandmarkShrineCenter extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[8];
	}
	
	@Override
	public char getChar() {
		return Library.LANDMARK_SHRINE_CENTER;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return new ResourceStack(Resource.DARK, 1);
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return new LandmarkGround();
	}
	
	@Override
	public void onDestroy(Landmark[][] world, Vector pos) {
		//also destroy the rest of the shrine
		world[pos.getX() - 1][pos.getY()] = new LandmarkGround();
		world[pos.getX() + 1][pos.getY()] = new LandmarkGround();
		world[pos.getX()][pos.getY() - 1] = new LandmarkGround();
		world[pos.getX()][pos.getY() + 1] = new LandmarkGround();
	}

	@Override
	public String getName() {
		return "Shrine Center";
	}

}
