package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the speed potion item
 * @author Quintin Harter
 *
 */
public class ItemSpeedPotion extends ItemConsumable {

	public ItemSpeedPotion(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[5];
	}

	@Override
	public void use() {
		if (unlocked || Library.ENABLE_ALL_ITEMS)
			player.addSpeedMoves(Library.SPEED_POTION_AMOUNT);
	}

	@Override
	public String getName() {
		return "Speed Potion";
	}

}
