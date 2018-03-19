package landmarks;

import java.awt.Color;

import game.Library;

public class LandmarkSea extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_SEA;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public String getName() {
		return "Sea";
	}
	
	@Override
	public Color getColor() {
		return Color.BLUE;
	}

}
