package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the luck potion item
 * @author Quintin Harter
 *
 */
public class ItemLuckPotion extends ItemConsumable {

	public ItemLuckPotion(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[7];
	}

	@Override
	public void use() {
		if (unlocked || Library.ENABLE_ALL_ITEMS) 
		player.addLuckUses(Library.LUCK_POTION_AMOUNT);
	}

	@Override
	public String getName() {
		return "Luck Potion";
	}

}
