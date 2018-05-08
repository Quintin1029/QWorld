package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the med kit item. Restores health when used.
 * @author Quintin Harter
 *
 */
public class ItemMedKit extends ItemConsumable {

	public ItemMedKit(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[2];
	}

	@Override
	public void use() {
		if (unlocked)
			player.updateHealth(player.getHealth() + Library.MED_KIT_PERCENT);
	}

	@Override
	public String getName() {
		return "Med Kit";
	}

}
