package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

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
		player.updateWater(player.getWater() + Library.WATER_BOTTLE_PERCENT);
	}

}
