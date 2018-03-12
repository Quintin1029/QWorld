package landmarks;

import game.Library;

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

}
