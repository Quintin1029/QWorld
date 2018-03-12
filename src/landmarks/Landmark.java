package landmarks;

import game.PlayerStatManager;

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
	/**
	 * Gets the name of the landmark (mostly for debugging)
	 * @return the name of the landmark
	 * @author Quintin Harter
	 */
	public abstract String getName();
	
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
