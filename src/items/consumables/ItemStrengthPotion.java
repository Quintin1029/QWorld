package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the strength potion item. Adds strength moves (does not consume any food or water)
 * @author Quintin Harter
 *
 */
public class ItemStrengthPotion extends ItemConsumable {

	public ItemStrengthPotion(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[3];
	}

	@Override
	public void use() {
		if (unlocked)
			player.addStrengthMoves(Library.STRENGTH_POTION_AMOUNT);
	}

	@Override
	public String getName() {
		return "Strength Potion";
	}

}
