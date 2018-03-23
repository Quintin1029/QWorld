package items;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

public class ItemMedKit extends ItemConsumable {

	public ItemMedKit(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public void use() {
		player.updateHealth(player.getHealth() + Library.MED_KIT_PERCENT);
	}

}
