package items.tools;

import game.Library;
import game.PlayerStatManager;
import items.Item;

public abstract class ItemTool extends Item {

	public ItemTool(PlayerStatManager player) {
		super(player);
	}
	
	/**
	 * Gets the tool types of this object. Use Libary.java to compare.
	 * @return
	 */
	public abstract int [] getToolTypes();

	@Override
	public void use() {
		player.getGame().attemptHarvest(this, Library.HARVEST_CONDITION_NORMAL);
		Library.print("Used Tool");
	}
	
}