package landmarks;

import java.awt.Color;

import game.PlayerStatManager;
import resources.ResourceStack;

/**
 * The superclass for all landmark objects
 * @author Quintin Harter
 *
 */
public abstract class Landmark {
	
	/**
	 * Gets the character used by the landmark
	 * @return the character
	 * @author Quintin Harter
	 */
	public abstract char getChar();
	/**
	 * Gets if the landmark is solid
	 * @return if the landmark is solid
	 * @author Quintin Harter
	 */
	public abstract boolean getIsSolid();
	
	public abstract ResourceStack getHarvest(int toolType);
	
	public abstract Landmark getReplacementLandmark(int condition);
	
	/**
	 * Gets the name of the landmark (mostly for debugging)
	 * @return the name of the landmark
	 * @author Quintin Harter
	 */
	public abstract String getName();
	
	/**
	 * Gets the color of the landmark if it should override the default from the zone.
	 * @return the color to override with, null if none
	 * @author Quintin Harter
	 */
	public Color getColor() {
		return null;
	}
	
	/**
	 * The method called when the player tries to move onto this landmark
	 * @param player the player moving onto this landmark
	 * @param world the world the player is in
	 * @author Quintin Harter
	 */
	public void interact(PlayerStatManager player, Landmark [] [] world) {
		//default-- do nothing
	}
	
}
