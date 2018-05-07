package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

/**
 * Represents the lunch box item. Restores hunger when used.
 * @author Quintin Harter
 *
 */
public class ItemLunchBox extends ItemConsumable {

	public ItemLunchBox(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public void use() {
		if (unlocked)
			player.updateFood(player.getFood() + Library.LUNCH_BOX_PERCENT);
	}

	@Override
	public String getName() {
		return "Lunch Box";
	}
	
}
