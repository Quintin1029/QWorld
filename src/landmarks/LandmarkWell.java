package landmarks;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import game.PlayerStatManager;
import resources.Resource;
import resources.ResourceStack;
import util.Vector;

/**
 * The well landmark
 * @author Quintin Harter
 *
 */
public class LandmarkWell extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[10];
	}
	
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
	public void interact(PlayerStatManager player, Landmark [] [] world, Vector position) {
		player.updateWater(player.getMaxWater());
	}

	@Override
	public ResourceStack getHarvest(Resource toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return this;
	}
	
}
