package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

public class ItemFireball extends ItemConsumable {

	public ItemFireball(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[9];
	}

	@Override
	public void use() {
		// TODO (maybe)
	}

	@Override
	public String getName() {
		return "Fireball";
	}

}
