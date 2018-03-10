package landmarks;

import game.Library;
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

}
