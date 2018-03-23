package items;

import game.PlayerStatManager;

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
