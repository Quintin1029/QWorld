package items;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

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
		player.updateFood(player.getFood() + Library.LUNCH_BOX_PERCENT);
	}

}
