package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the water bottle item. Restores water.
 * @author Quintin Harter
 *
 */
public class ItemWaterBottle extends ItemConsumable {

	public ItemWaterBottle(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[0];
	}

	@Override
	public void use() {
		if (unlocked || Library.ENABLE_ALL_ITEMS)
			player.updateWater(player.getWater() + Library.WATER_BOTTLE_PERCENT);
	}

	@Override
	public String getName() {
		return "Water Bottle";
	}

}
