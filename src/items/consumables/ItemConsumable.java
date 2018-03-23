package items.consumables;

import game.PlayerStatManager;
import items.Item;

public abstract class ItemConsumable extends Item {
	
	private boolean usable;
	
	public ItemConsumable(PlayerStatManager player) {
		super(player);
		usable = true;
	}

	public void regenerate() {
		usable = true;
	}

}
