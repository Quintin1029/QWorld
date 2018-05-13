package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the shield item
 * @author Quintin Harter
 *
 */
public class ItemShield extends ItemConsumable {

	public ItemShield(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[6];
	}

	@Override
	public void use() {
		if (unlocked || Library.ENABLE_ALL_ITEMS)
			player.addShieldUses(Library.SHIELD_AMOUNT);
	}

	@Override
	public String getName() {
		return "Shield";
	}

}
