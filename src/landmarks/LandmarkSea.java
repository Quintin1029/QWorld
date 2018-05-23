package landmarks;

import java.awt.Color;

import javax.swing.ImageIcon;

import game.HarvestCondition;
import game.Library;
import game.PlayerStatManager;
import resources.ResourceStack;
import util.Vector;

/**
 * The sea landmark
 * @author Quintin Harter
 *
 */
public class LandmarkSea extends Landmark {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[7];
	}
	
	@Override
	public char getChar() {
		return Library.LANDMARK_SEA;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}
	
	@Override
	public void interact(PlayerStatManager player, Landmark[][] world, Vector position) {
		player.updateWater(player.getMaxWater());
	}

	@Override
	public String getName() {
		return "Sea";
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.BLUE;
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return null;
	}

}
