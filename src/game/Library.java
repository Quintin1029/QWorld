package game;

import java.awt.Image;

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
	
	// debug constant: turn this off when you no longer want to print to the
	// console.
	public static final boolean DEBUG_MODE = false;
	public static final boolean DEBUG_FILE = false;
	
	//testing variable: turn true when you want to be invincible
	public static final boolean NO_DEATH = true;
	public static final boolean NO_APOCALYPSE = true;
	public static final boolean ENABLE_ALL_ITEMS = true;
	public static final boolean DISABLE_STORY = true;
	
	//color scheme
	public static final ColorScheme COLOR_SCHEME = new DarkColorScheme();
	
	//timing constants
	public static final int APOCALYPSE_TIME = 15 * 60;

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
	public static final char LANDMARK_HUT = '@';
	public static final char LANDMARK_HUT_BROKEN = '#';
	public static final char LANDMARK_RUINS = '#';
	public static final char LANDMARK_SHRINE_CENTER = '?';
	public static final char LANDMARK_SHRINE_SIDE = '-';
	public static final char LANDMARK_SHRINE_TOP = '|';
	public static final char LANDMARK_SHRINE_DIAG_LEFT = '\\';
	public static final char LANDMARK_SHRINE_DIAG_RIGHT = '/';
	public static final char LANDMARK_CACTUS = 'i';

	// window stats: affect UI display
	public static final int WINDOW_SCREEN_CHAR_WIDTH = 20;
	public static final int WINDOW_SCREEN_CHAR_HEIGHT = 20;
	public static final int WINDOW_SCREEN_PIXEL_WIDTH = 500;
	public static final int WINDOW_SCREEN_PIXEL_HEIGHT = 500;
	public static final int ZONE_WIDTH = 1;
	public static final int ZONE_HEIGHT = 1;
	public static final float FONT_SIZE = 15f;

	// game options: affect world generation or settings
	public static final int WORLD_SIZE = 1000;
	public static final int ZONE_DENSITY = 200;
	public static final int ZONE_MINIMUM_DISTANCE = 30; //make sure ZONE_DENSITY * ZONE_MINIMUM_DISTANCE < 1,000,000
	public static final int SPAWN_RADIUS = 30; //no structures will be generated in the circle at the center of the world with this radius
	public static final int CARRYING_CAPACITY = 10;
	
	//hut gen
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
	
	
	// item options:
	public static final int WATER_BOTTLE_PERCENT = 20;
	public static final int LUNCH_BOX_PERCENT = 20;
	public static final int MED_KIT_PERCENT = 20;
	public static final int STRENGTH_POTION_AMOUNT = 25;
	public static final int SHIELD_AMOUNT = 5;
	public static final int SPEED_POTION_AMOUNT = 10;
	public static final int LUCK_POTION_AMOUNT = 5;
	public static final int CHAOS_TELEPORTER_LOW_RANGE = 20;
	public static final int CHAOS_TELEPORTER_HIGH_RANGE = 100;
	
	//tool types:
	public static final int TOOL_NONE = 0;
	public static final int TOOL_WOOD = 1;
	public static final int TOOL_GRASS = 2;
	public static final int TOOL_ROCK = 3;
	public static final int TOOL_IRON = 4;
	public static final int TOOL_DARK = 5;
	public static final int TOOL_CLOUD = 6;
	
	//harvesting conditions
	public static final int HARVEST_CONDITION_NORMAL = 0;

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
			scaleImageToSize(getImage("icons/landmarks/grass.png")),
			scaleImageToSize(getImage("icons/landmarks/tree.png")),
			scaleImageToSize(getImage("icons/landmarks/player.png")),
			scaleImageToSize(getImage("icons/landmarks/house.png")),
			scaleImageToSize(getImage("icons/landmarks/cactus.png")),
			scaleImageToSize(getImage("icons/landmarks/hut.png")),
			scaleImageToSize(getImage("icons/landmarks/ruins.png")),
			scaleImageToSize(getImage("icons/landmarks/sea.png")),
			scaleImageToSize(getImage("icons/landmarks/shrine.png")),
			scaleImageToSize(getImage("icons/landmarks/shrineBorder.png")),
			scaleImageToSize(getImage("icons/landmarks/well.png")),
			scaleImageToSize(getImage("icons/landmarks/sand.png"))
	};
	
	//icons used for items
	public static final ImageIcon [] ITEM_CONSUMABLE_ICONS = {
			getImage("icons/items/waterbottle.png"),
			getImage("icons/items/lunchbox.png"),
			getImage("icons/items/medkit.png"),
			getImage("icons/items/strengthpotion.png"),
			getImage("icons/items/rubyslippers.png"),
			getImage("icons/items/speedpotion.png"),
			getImage("icons/items/shield.png"),
			getImage("icons/items/luckpotion.png"),
			getImage("icons/items/teleporter.png"),
			getImage("icons/items/fireball.png")
	};
	
	public static final ImageIcon [] ITEM_TOOL_ICONS = {
			getImage("icons/items/branch.png"),
			getImage("icons/items/scythe.png"),
			getImage("icons/items/chisel.png"),
			getImage("icons/items/pickaxe.png"),
			getImage("icons/items/soulcollector.png"),
			getImage("icons/items/bottle.png"),
			getImage("icons/items/axe.png"),
			getImage("icons/items/drill.png"),
			getImage("icons/items/soulbottle.png"),
			getImage("icons/items/hammer.png")
	};
	
	public static final ImageIcon [] ITEM_BUILDING_ICONS = {
			getImage("icons/shirt.png")
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
	 * Scales the image to the size of each grid box in the screen. Call this on image instantiation, not every screen update (for time complexity).
	 * @param image the image to scale
	 * @return the scaled image.
	 */
	public static ImageIcon scaleImageToSize(ImageIcon image) {
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
