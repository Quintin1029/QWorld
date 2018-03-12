package game;

public class Library {
	
	//debug constant
	public static boolean DEBUG_MODE = true;

	//landmark char constants
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
	
	//window stats
	public static int WINDOW_SCREEN_CHAR_WIDTH = 40;
	public static int WINDOW_SCREEN_CHAR_HEIGHT = 40;
	public static int WINDOW_SCREEN_PIXEL_WIDTH = 500;
	public static int WINDOW_SCREEN_PIXEL_HEIGHT = 500;
	public static int ZONE_WIDTH = 10;
	public static int ZONE_HEIGHT = 10;
	public static float FONT_SIZE = 15f;
	
	//game options
	public static int WORLD_SIZE = 1000;
	
	//temperatures
	public static double TEMP_NORMAL = 0.01; //lose 1% of water per move
	public static double TEMP_WARM = 0.02; //lose 2% of water per move
	public static double TEMP_COOL = 0.005; //lose 0.5% of water per move
	public static double TEMP_HOT = 0.05; //lose 5% of water per move
	public static double TEMP_COLD = 0.001; //lose 0.1% of water per move
	
	//hungers
	public static double FOOD_LOSS_COEFFICIENT = 0.01; //lose 1% of water per move
	
	//mechanic constants
	public static int DIRECTION_UP = 0;
	public static int DIRECTION_RIGHT = 1;
	public static int DIRECTION_DOWN = 2;
	public static int DIRECTION_LEFT = 3;
	
	public static double foodEquation(double x) {
		return 2 / Math.PI * Math.atan(x * 0.5) + 1;
	}
	
	public static double clamp(double x, double floor, double ceil) {
		if (x >= ceil)
			return ceil;
		if (x <= floor)
			return floor;
		return x;
	}
	
	public static void print(String str) {
		if (Library.DEBUG_MODE)
			System.out.println(">: " + str);
	}
	
}
