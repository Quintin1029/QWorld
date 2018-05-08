package landmarks;

import java.awt.Color;

import game.Library;
import resources.ResourceStack;
import util.QRandom;

public class LandmarkRuins extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_RUINS;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		switch(toolType) {
		case Library.TOOL_WOOD: return new ResourceStack(ResourceStack.WOOD, QRandom.randInt(5, 20));
		case Library.TOOL_ROCK: return new ResourceStack(ResourceStack.ROCK, QRandom.randInt(10, 30));
		case Library.TOOL_IRON: return new ResourceStack(ResourceStack.IRON, QRandom.randInt(1, 5));
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return new LandmarkGround();
	}

	@Override
	public String getName() {
		return "Ruins";
	}
	
	@Override
	public Color getColor() {
		return new Color(38, 149, 47);
	}

}
