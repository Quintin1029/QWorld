package landmarks;

import game.Library;

public class LandmarkHome extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_HOME;
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public String getName() {
		return "Home";
	}

}
