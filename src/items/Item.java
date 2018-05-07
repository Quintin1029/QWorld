package items;

import javax.swing.Icon;

import game.PlayerStatManager;

/**
 * Represents an item (consumable, tool, building, etc.) that the player can use. These are displayed in the player's inventory.
 * @author Quintin Harter
 *
 */
public abstract class Item {

	protected PlayerStatManager player;
	protected boolean unlocked;
	
	/**
	 * Constructor
	 * @param player the player the object is attached to
	 */
	public Item(PlayerStatManager player) {
		this.player = player;
		unlocked = false;
	}
	
	/**
	 * Gets the icon to be used by this item. This should be 32 by 32 pixels (otherwise the UI will look weird).
	 * @return the icon of this item
	 */
	public abstract Icon getIcon();
	
	/**
	 * Uses the item. Typically this will involve some sort of call to player.
	 */
	public abstract void use();
	
	/**
	 * Unlocks the item. When locked, the item cannot be used.
	 */
	public void unlock() {
		unlocked = true;
	}
	
	/**
	 * Gets if the item is unlocked.
	 * @return if the item is unlocked.
	 */
	public boolean getIsUnlocked() {
		return unlocked;
	}
	
	/**
	 * Gets the name of the item.
	 * @return the name of the item
	 */
	public abstract String getName();
	
}
