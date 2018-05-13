package landmarks;

import game.Library;
import game.WorldGenerator;
import resources.ResourceStack;
import util.Vector;

/**
 * The shrine center landmark
 * @author Quintin Harter
 *
 */
public class LandmarkShrineCenter extends Landmark {

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
		return new ResourceStack(ResourceStack.DARK, 1);
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
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
