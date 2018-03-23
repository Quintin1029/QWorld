package landmarks;

import game.Library;
import game.PlayerStatManager;
import resources.ResourceStack;

public class LandmarkWell extends Landmark {

	@Override
	public char getChar() {
		return Library.LANDMARK_WELL;
	}

	@Override
	public boolean getIsSolid() {
		return false;
	}

	@Override
	public String getName() {
		return "Well";
	}

	@Override
	public void interact(PlayerStatManager player, Landmark [] [] world) {
		player.updateWater(player.getMaxWater());
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return this;
	}
	
}
