package items.consumables;

import game.PlayerStatManager;
import items.Item;

public abstract class ItemConsumable extends Item {
	
	private boolean usable;
	
	public ItemConsumable(PlayerStatManager player) {
		super(player);
		usable = true;
	}

	/**
	 * Regenerates the item. Sets the item so it can be used again. (CURRENTLY UNUSED IN CODE (TODO?))
	 */
	public void regenerate() {
		usable = true;
	}

}
