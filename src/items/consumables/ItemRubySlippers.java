package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;
import util.Vector;

/**
 * Represents the ruby slippers item
 * @author Quintin Harter
 *
 */
public class ItemRubySlippers extends ItemConsumable {

	public ItemRubySlippers(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[4];
	}

	@Override
	public void use() {
		if (unlocked || Library.ENABLE_ALL_ITEMS) {
			Vector direction = Vector.VECTOR_CENTER.subtract(player.getPosition());
			player.getGame().attemptMove(direction);
		}
	}

	@Override
	public String getName() {
		return "Ruby Slippers";
	}

}
