package items.tools;

import game.Library;
import game.PlayerStatManager;
import items.Item;

public abstract class ItemTool extends Item {

	public ItemTool(PlayerStatManager player) {
		super(player);
	}
	
	public abstract int [] getToolTypes();

	@Override
	public void use() {
		player.getGame().attemptHarvest(this, Library.HARVEST_CONDITION_NORMAL);
		Library.print("Used Tool");
	}
	
}
