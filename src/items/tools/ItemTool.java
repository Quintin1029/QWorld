package items.tools;

import game.HarvestCondition;
import game.Library;
import game.PlayerStatManager;
import items.Item;

/**
 * The superclass for all tool items.
 * @author Quintin Harter
 *
 */
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
		player.getGame().attemptHarvest(this, HarvestCondition.HARVEST_NORMAL);
		Library.print("Used Tool");
	}
	
}
