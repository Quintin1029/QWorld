package game;

/**
 * A static class used to store most constants and general methods used throughout the game.
 * 
 * @author Quintin Harter
 */
public class Library {
	
	//debug constant: turn this off when you no longer want to print to the console.
	public static boolean DEBUG_MODE = true;

	//landmark char constants: used by landmarks to display to the screen
	public static char LANDMARK_NULL = 'X';//'\u2593';
	public static char LANDMARK_GROUND = ' ';
	public static char LANDMARK_SEA = '~';
	public static char LANDMARK_PATH = '#';
	public static char LANDMARK_TREE = 'T';
	public static char LANDMARK_MOUNTAIN_TOP = '^';
	public static char LANDMARK_MOUNTAIN_SIDE_LEFT = '/';
	public static char LANDMARK_MOUNTAIN_SIDE_RIGHT = '\\';
	public static char LANDMARK_HOUSE_SIDE = '|';
	public static char LANDMARK_HOUSE_TOP_LEFT = '/';
	public static char LANDMARK_HOUSE_TOP_RIGHT = '\\';
	public static char LANDMARK_HOUSE_TOP_TOP = '_';
	public static char LANDMARK_PLAYER='O'; //person
	public static char LANDMARK_ENEMY = '\u2738'; //star
	public static char LANDMARK_HOME = 'H';
	public static char LANDMARK_WELL = 'W';
	
	//window stats: affect UI display
	public static int WINDOW_SCREEN_CHAR_WIDTH = 40;
	public static int WINDOW_SCREEN_CHAR_HEIGHT = 40;
	public static int WINDOW_SCREEN_PIXEL_WIDTH = 500;
	public static int WINDOW_SCREEN_PIXEL_HEIGHT = 500;
	public static int ZONE_WIDTH = 10;
	public static int ZONE_HEIGHT = 10;
	public static float FONT_SIZE = 15f;
	
	//game options: affect world generation or settings
	public static int WORLD_SIZE = 1000;
	
	//temperatures: affect water loss in zones
	public static double TEMP_NORMAL = 0.01; //lose 1% of water per move
	public static double TEMP_WARM = 0.02; //lose 2% of water per move
	public static double TEMP_COOL = 0.005; //lose 0.5% of water per move
	public static double TEMP_HOT = 0.05; //lose 5% of water per move
	public static double TEMP_COLD = 0.001; //lose 0.1% of water per move
	
	//hungers: affect food loss in zones
	public static double FOOD_LOSS_COEFFICIENT = 0.01; //lose 1% of food per move
	
	/**
	 * Returns the x value as long as it is between the two extremes, otherwise returns the extreme.
	 * 
	 * @param x the value you want to clamp
	 * @param floor the lower extreme value
	 * @param ceil the higher extreme value
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
	 * @param str the string to be printed
	 * @author Quintin Harter
	 */
	public static void print(String str) {
		if (Library.DEBUG_MODE)
			System.out.println(">: " + str);
	}
	
}
