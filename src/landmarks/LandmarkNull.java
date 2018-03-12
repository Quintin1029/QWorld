package landmarks;

import game.Library;

/**
 * The null landmark
 * @author Quintin Harter
 *
 */
public class LandmarkNull extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_NULL;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public String getName() {
		return "Null";
	}

}
