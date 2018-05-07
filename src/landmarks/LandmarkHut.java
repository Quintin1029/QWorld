package landmarks;

import javax.swing.JOptionPane;

import game.Library;
import game.PlayerStatManager;
import items.Item;
import resources.ResourceStack;

/**
 * The Hut landmark (#). Gives a specific item to the player when used.
 * @author Quintin Harter
 *
 */
public class LandmarkHut extends Landmark {
	
	//Item types-- these should match the value returned by getName() for each item
	public static final String ITEM_TYPE_WATER_BOTTLE = "Water Bottle";
	public static final String ITEM_TYPE_LUNCH_BOX = "Lunch Box";
	public static final String ITEM_TYPE_MED_KIT = "Med Kit";
	public static final String ITEM_TYPE_STRENGTH_POTION = "Strength Potion";
	public static final String ITEM_TYPE_STICK = "Stick";

	private String tiedItem;

	public LandmarkHut(String tiedItem) {
		super();
		this.tiedItem = tiedItem;
	}

	@Override
	public char getChar() {
		return Library.LANDMARK_HUT;
	}

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public void interact(PlayerStatManager player, Landmark[][] world) {
		Item pItem = getPlayerItem(tiedItem, player);
		if (!pItem.getIsUnlocked()) {
			pItem.unlock();
			player.getGame().ui.displayDialogue("You've unlocked " + pItem.getName() + "!!!", "Congradulations!");
		}
	}

	@Override
	public ResourceStack getHarvest(int toolType) {
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(int condition) {
		return null;
	}

	@Override
	public String getName() {
		return "Hut";
	}
	
	public static Item getPlayerItem(String type, PlayerStatManager player) {
		for (Item consumable : player.getConsumables()) {
			if (consumable != null && consumable.getName().equals(type))
				return consumable;
		}
		for (Item tool : player.getTools()) {
			if (tool != null && tool.getName().equals(type))
				return tool;
		}
		for (Item building : player.getBuildings()) {
			if (building != null && building.getName().equals(type))
				return building;
		}
		return null;
	}

}
