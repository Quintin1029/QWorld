package colorschemes;

import java.awt.Color;

/**
 * A base class for the color scheme of the game.
 * 
 * @author Quintin Harter
 *
 */
public abstract class ColorScheme {

	/**
	 * Gets the background color of this color scheme.
	 * This is used in the background of the JFrame.
	 * @return the background color
	 */
	public abstract Color getBackgroundColor();
	/**
	 * Gets the text color of this color scheme.
	 * This is used in all texts (not in the game)
	 * @return the text color
	 */
	public abstract Color getTextColor();
	/**
	 * Gets the button color of this color scheme.
	 * This is the color of all buttons in the
	 * player's inventory.
	 * @return the button color
	 */
	public abstract Color getButtonColor();
	/**
	 * Gets the button border color of this color scheme.
	 * This is the color of the border of all the
	 * buttons in the player's inventory.
	 * @return the button border color
	 */
	public abstract Color getButtonBorderColor();
	/**
	 * Gets the world border color of this color scheme.
	 * This is the color of the border around the world
	 * display.
	 * @return the world border color
	 */
	public abstract Color getWorldBorderColor();

}
