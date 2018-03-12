package landmarks;

import game.Library;

/**
 * The tree landmark
 * @author Quintin Harter
 *
 */
public class LandmarkTree extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_TREE;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public String getName() {
		return "Tree";
	}

}
