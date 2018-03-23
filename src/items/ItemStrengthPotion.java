package items;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

public class ItemStrengthPotion extends ItemConsumable {

	public ItemStrengthPotion(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public void use() {
		player.addStrengthMoves(Library.STRENGTH_POTION_AMOUNT);
	}

}
