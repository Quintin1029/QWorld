package game;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import colorschemes.ColorScheme;
import colorschemes.DarkColorScheme;;

/**
 * A static class used to store most constants and general methods used
 * throughout the game.
 * 
 * @author Quintin Harter
 */
public class Library {
	
	public static final boolean DEBUG_MODE = true; //prints debug text to the default System.out throughout the program
	public static final boolean DEBUG_FILE = false; //prints debug text to a file TODO
	
	//testing variable: turn true when you want to be invincible
	public static final boolean NO_DEATH = true; //death does not happen
	public static final boolean NO_APOCALYPSE = true; //the apocalypse does not happen
	public static final boolean ENABLE_ALL_ITEMS = true; //all items are enabled to begin with
	public static final boolean DISABLE_STORY = true; //the story (popups, etc) is disabled
	
	//color scheme
	public static final ColorScheme COLOR_SCHEME = new DarkColorScheme(); //the color scheme that controls the look of the program
	
	//timing constants
	public static final int APOCALYPSE_TIME = 15 * 60; //the time it takes for the apocalypse to start

	// landmark char constants: used by landmarks to display to the screen TODO get rid of char system
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
	public static final char LANDMARK_HUT = '@';
	public static final char LANDMARK_HUT_BROKEN = '#';
	public static final char LANDMARK_RUINS = '#';
	public static final char LANDMARK_SHRINE_CENTER = '?';
	public static final char LANDMARK_SHRINE_SIDE = '-';
	public static final char LANDMARK_SHRINE_TOP = '|';
	public static final char LANDMARK_SHRINE_DIAG_LEFT = '\\';
	public static final char LANDMARK_SHRINE_DIAG_RIGHT = '/';
	public static final char LANDMARK_CACTUS = 'i';

	// game options: affect world generation or settings
	public static final int WORLD_SIZE = 1000; //the width and height of the world (1000x1000)
	public static final int ZONE_DENSITY = 200; //the number of total zones in the world
	public static final int ZONE_MINIMUM_DISTANCE = 30; //the minimum distance between two centers-- make sure ZONE_DENSITY * ZONE_MINIMUM_DISTANCE < WORLD_SIZE ^ 2
	public static final int SPAWN_RADIUS = 30; //no structures will be generated in the circle at the center of the world with this radius
	public static final int CARRYING_CAPACITY = 10; //the number of each type of item you can hold (DO NOT CHANGE FIXME)
	
	// window stats: affect UI display
	public static final int WINDOW_SCREEN_CHAR_WIDTH = 20; //the width of the world display in tiles
	public static final int WINDOW_SCREEN_CHAR_HEIGHT = 20; //the height of the world display in tiles
	public static final int FRAME_PIXEL_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height * 3 / 4; //the height of the frame in pixels
	public static final int FRAME_PIXEL_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width / 2; //the width of the frame in pixels
	public static final int WINDOW_SCREEN_PIXEL_HEIGHT = FRAME_PIXEL_HEIGHT * 4 / 5; //the height of the world display in pixels
	public static final int WINDOW_SCREEN_PIXEL_WIDTH = WINDOW_SCREEN_PIXEL_HEIGHT; //the width of the world display in pixels (should be the same as the height
	public static final int WINDOW_LOADING_HEIGHT = FRAME_PIXEL_HEIGHT / 5; //the loading window height
	public static final int WINDOW_LOADING_WIDTH = FRAME_PIXEL_WIDTH / 2; //the loading window width
	public static final int LOADING_FONT_SIZE = FRAME_PIXEL_HEIGHT / 40; //the loading window font size
	public static final int QBUTTON_HEIGHT_AND_WIDTH = WINDOW_SCREEN_PIXEL_HEIGHT / (CARRYING_CAPACITY + 4); //the height and width of the item buttons (QButtons)
	public static final float FONT_SIZE = 15f; //the size of the characters in the world (TODO get rid of the character system)
	public static final int RESOURCE_FONT_SIZE = LOADING_FONT_SIZE * 2 / 3; //the font size for resource display
	public static final int TIME_FONT_SIZE = LOADING_FONT_SIZE * 2; //the font size for the timer
	public static final int BORDER_SIZE = FRAME_PIXEL_HEIGHT / 150; //the border size in pixels
	
	//Hut generation: the minimum and maximum distances the huts of each item can spawn TODO
	public static final int ITEM_WATER_BOTTLE_HUT_INNER_RADIUS = 20; 
	public static final int ITEM_WATER_BOTTLE_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_LUNCH_BOX_HUT_INNER_RADIUS = 20;
	public static final int ITEM_LUNCH_BOX_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_MED_KIT_HUT_INNER_RADIUS = 20;
	public static final int ITEM_MED_KIT_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_STRENGTH_POTION_HUT_INNER_RADIUS = 20;
	public static final int ITEM_STRENGTH_POTION_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_RUBY_SLIPPERS_HUT_INNER_RADIUS = 20;
	public static final int ITEM_RUBY_SLIPPERS_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_SPEED_POTION_HUT_INNER_RADIUS = 20;
	public static final int ITEM_SPEED_POTION_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_SHIELD_HUT_INNER_RADIUS = 20;
	public static final int ITEM_SHIELD_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_LUCK_POTION_HUT_INNER_RADIUS = 20;
	public static final int ITEM_LUCK_POTION_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_CHAOS_TELEPORTER_HUT_INNER_RADIUS = 20;
	public static final int ITEM_CHAOS_TELEPORTER_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_FIREBALL_HUT_INNER_RADIUS = 20;
	public static final int ITEM_FIREBALL_HUT_OUTER_RADIUS = 50;
	public static final int ITEM_STICK_HUT_INNER_RADIUS = 20;
	public static final int ITEM_STICK_HUT_OUTER_RADIUS = 50;
	
	
	//Item options:
	public static final int WATER_BOTTLE_PERCENT = 20; //the amount of water the water bottle restores
	public static final int LUNCH_BOX_PERCENT = 20; //the amount of food the lunch box restores
	public static final int MED_KIT_PERCENT = 20; //the amount of health the med kit restores
	public static final int STRENGTH_POTION_AMOUNT = 25; //the amount of moves the strength potion gives you
	public static final int SHIELD_AMOUNT = 5; //TODO implement shield
	public static final int SPEED_POTION_AMOUNT = 10; //the amount of moves the speed potion gives you
	public static final int LUCK_POTION_AMOUNT = 5; //the amount of harvest attempts the luck potion gives you
	public static final int CHAOS_TELEPORTER_LOW_RANGE = 20; //the minimum range of the chaos teleporter
	public static final int CHAOS_TELEPORTER_HIGH_RANGE = 100; //the maximum range of the chaos teleporter

	// temperatures: affect water loss in zones
	public static final double TEMP_NORMAL = 0.01; // lose 1% of water per move
	public static final double TEMP_WARM = 0.02; // lose 2% of water per move
	public static final double TEMP_COOL = 0.005; // lose 0.5% of water per move
	public static final double TEMP_HOT = 0.05; // lose 5% of water per move
	public static final double TEMP_COLD = 0.001; // lose 0.1% of water per move

	// hungers: affect food loss in zones
	public static final double FOOD_LOSS_COEFFICIENT = 0.01; // lose 1% of food per move
	public static final double HEALTH_LOSS_COEFFICIENT = 0.01; //lose 1% of health per damage while moving
		
	//landmark icons
	public static final ImageIcon [] LANDMARK_ICONS = {
			scaleImageToGridSize(getImage("icons/landmarks/grass.png")),
			scaleImageToGridSize(getImage("icons/landmarks/tree.png")),
			scaleImageToGridSize(getImage("icons/landmarks/player.png")),
			scaleImageToGridSize(getImage("icons/landmarks/house.png")),
			scaleImageToGridSize(getImage("icons/landmarks/cactus.png")),
			scaleImageToGridSize(getImage("icons/landmarks/hut.png")),
			scaleImageToGridSize(getImage("icons/landmarks/ruins.png")),
			scaleImageToGridSize(getImage("icons/landmarks/sea.png")),
			scaleImageToGridSize(getImage("icons/landmarks/shrine.png")),
			scaleImageToGridSize(getImage("icons/landmarks/shrineBorder.png")),
			scaleImageToGridSize(getImage("icons/landmarks/well.png")),
			scaleImageToGridSize(getImage("icons/landmarks/sand.png"))
	};
	
	//icons used for items
	public static final ImageIcon [] ITEM_CONSUMABLE_ICONS = {
			scaleImageToItemSize(getImage("icons/items/waterbottle.png")),
			scaleImageToItemSize(getImage("icons/items/lunchbox.png")),
			scaleImageToItemSize(getImage("icons/items/medkit.png")),
			scaleImageToItemSize(getImage("icons/items/strengthpotion.png")),
			scaleImageToItemSize(getImage("icons/items/rubyslippers.png")),
			scaleImageToItemSize(getImage("icons/items/speedpotion.png")),
			scaleImageToItemSize(getImage("icons/items/shield.png")),
			scaleImageToItemSize(getImage("icons/items/luckpotion.png")),
			scaleImageToItemSize(getImage("icons/items/teleporter.png")),
			scaleImageToItemSize(getImage("icons/items/fireball.png"))
	};
	
	public static final ImageIcon [] ITEM_TOOL_ICONS = {
			scaleImageToItemSize(getImage("icons/items/branch.png")),
			scaleImageToItemSize(getImage("icons/items/scythe.png")),
			scaleImageToItemSize(getImage("icons/items/chisel.png")),
			scaleImageToItemSize(getImage("icons/items/pickaxe.png")),
			scaleImageToItemSize(getImage("icons/items/soulcollector.png")),
			scaleImageToItemSize(getImage("icons/items/bottle.png")),
			scaleImageToItemSize(getImage("icons/items/axe.png")),
			scaleImageToItemSize(getImage("icons/items/drill.png")),
			scaleImageToItemSize(getImage("icons/items/soulbottle.png")),
			scaleImageToItemSize(getImage("icons/items/hammer.png"))
	};
	
	public static final ImageIcon [] ITEM_BUILDING_ICONS = {
			scaleImageToItemSize(getImage("icons/shirt.png"))
	};
	
	public static final ImageIcon [] RESOURCE_ICONS = {
			
	};

	/**
	 * Gets an image icon from a string. Used mostly internally by Library.java
	 * @param file the file directory
	 * @return the image icon from that directory
	 */
	public static ImageIcon getImage(String file) {
		try {
		return new ImageIcon(Library.class.getClassLoader().getResource(file));
		} catch (NullPointerException e) {
			Library.print("Improper file " + file + ". Check image location and name.");
			return null;
		}
	}
	
	/**
	 * Scales the image to the size of an item button. Call this on image instantiation, not every screen update (for time complexity).
	 * @param image the image to scale
	 * @return the scaled image
	 */
	public static ImageIcon scaleImageToItemSize(ImageIcon image) {
		if (image != null)
			return new ImageIcon(image.getImage().getScaledInstance(QBUTTON_HEIGHT_AND_WIDTH, QBUTTON_HEIGHT_AND_WIDTH, Image.SCALE_SMOOTH));
		return null;
	}
	
	/**
	 * Scales the image to the size of each grid box in the screen. Call this on image instantiation, not every screen update (for time complexity).
	 * @param image the image to scale
	 * @return the scaled image.
	 */
	public static ImageIcon scaleImageToGridSize(ImageIcon image) {
		if (image != null)
			return new ImageIcon(image.getImage().getScaledInstance(WINDOW_SCREEN_PIXEL_WIDTH / WINDOW_SCREEN_CHAR_WIDTH, WINDOW_SCREEN_PIXEL_HEIGHT / WINDOW_SCREEN_CHAR_WIDTH, Image.SCALE_FAST));
		return null;
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
