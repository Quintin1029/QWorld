package game;

import javax.swing.ImageIcon;

/**
 * A static class used to store most constants and general methods used
 * throughout the game.
 * 
 * @author Quintin Harter
 */
public class Library {

	// debug constant: turn this off when you no longer want to print to the
	// console.
	public static boolean DEBUG_MODE = true;
	public static boolean DEBUG_FILE = false;

	// landmark char constants: used by landmarks to display to the screen
	public static final char LANDMARK_NULL = 'X';// '\u2593';
	public static final char LANDMARK_GROUND = ' ';
	public static final char LANDMARK_SEA = ' ';
	public static final char LANDMARK_PATH = '#';
	public static final char LANDMARK_TREE = 'T';
	public static final char LANDMARK_MOUNTAIN_TOP = '^';
	public static final char LANDMARK_MOUNTAIN_SIDE_LEFT = '/';
	public static final char LANDMARK_MOUNTAIN_SIDE_RIGHT = '\\';
	public static final char LANDMARK_HOUSE_SIDE = '|';
	public static final char LANDMARK_HOUSE_TOP_LEFT = '/';
	public static final char LANDMARK_HOUSE_TOP_RIGHT = '\\';
	public static final char LANDMARK_HOUSE_TOP_TOP = '_';
	public static final char LANDMARK_PLAYER = 'O'; // person
	public static final char LANDMARK_ENEMY = '\u2738'; // star
	public static final char LANDMARK_HOME = 'H';
	public static final char LANDMARK_WELL = 'W';

	// window stats: affect UI display
	public static final int WINDOW_SCREEN_CHAR_WIDTH = 40;
	public static final int WINDOW_SCREEN_CHAR_HEIGHT = 40;
	public static final int WINDOW_SCREEN_PIXEL_WIDTH = 500;
	public static final int WINDOW_SCREEN_PIXEL_HEIGHT = 500;
	public static final int ZONE_WIDTH = 10;
	public static final int ZONE_HEIGHT = 10;
	public static final float FONT_SIZE = 15f;

	// game options: affect world generation or settings
	public static final int WORLD_SIZE = 1000;
	public static final int SPAWN_RADIUS = 30; //no structures will be generated in the circle at the center of the world with this radius
	public static final int CARRYING_CAPACITY = 10;

	// item options:
	public static final int WATER_BOTTLE_PERCENT = 20;
	public static final int LUNCH_BOX_PERCENT = 20;
	public static final int MED_KIT_PERCENT = 20;
	public static final int POTION_OF_SPEED_LENGTH = 25;

	// temperatures: affect water loss in zones
	public static final double TEMP_NORMAL = 0.01; // lose 1% of water per move
	public static final double TEMP_WARM = 0.02; // lose 2% of water per move
	public static final double TEMP_COOL = 0.005; // lose 0.5% of water per move
	public static final double TEMP_HOT = 0.05; // lose 5% of water per move
	public static final double TEMP_COLD = 0.001; // lose 0.1% of water per move

	// hungers: affect food loss in zones
	public static final double FOOD_LOSS_COEFFICIENT = 0.01; // lose 1% of food per move
	
	//icons used for items
	public static final ImageIcon [] ITEM_CONSUMABLE_ICONS = {
			getImage("icons/waterbottle.png")
	};
	
	public static final ImageIcon [] ITEM_WEAPON_ICONS = {
			getImage("icons/branch.jpg")
	};
	
	public static final ImageIcon [] ITEM_ARMOR_ICONS = {
			getImage("icons/shirt.png")
	};

	public static ImageIcon getImage(String file) {
		try {
		return new ImageIcon(Library.class.getClassLoader().getResource(file));
		} catch (NullPointerException e) {
			System.out.println("Improper file. Check image location and name.");
			return null;
		}
	}
	
	/**
	 * Returns the x value as long as it is between the two extremes, otherwise
	 * returns the extreme.
	 * 
	 * @param x
	 *            the value you want to clamp
	 * @param floor
	 *            the lower extreme value
	 * @param ceil
	 *            the higher extreme value
	 * @return the clamped x value
	 * @author Quintin Harter
	 */
	public static double clamp(double x, double floor, double ceil) {
		if (x >= ceil)
			return ceil;
		if (x <= floor)
			return floor;
		return x;
	}

	/**
	 * Prints the string to the console as long as debug mode is enabled.
	 * 
	 * @param str
	 *            the string to be printed
	 * @author Quintin Harter
	 */
	public static void print(String str) {
		if (Library.DEBUG_MODE)
			System.out.println(">: " + str);
	}

	/**
	 * Converts an array to a string for debugging
	 * @param arr the array to convert
	 * @return the resulting string
	 * @author Quintin Harter
	 */
	public static String arrayToString(Object[] arr) {
		String str = "[";
		for (Object obj : arr)
			str += obj.toString() + ", ";
		return str + "]";
	}

}
