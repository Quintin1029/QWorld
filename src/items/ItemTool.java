package items;

import game.PlayerStatManager;
import resources.ResourceStack;
import resources.ResourceStack.Resource;

public abstract class ItemTool extends Item {

	public ItemTool(PlayerStatManager player) {
		super(player);
	}

}
