package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;

public class ItemSpeedPotion extends ItemConsumable {

	public ItemSpeedPotion(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[5];
	}

	@Override
	public void use() {
		player.addSpeedMoves(Library.SPEED_POTION_AMOUNT);
	}

	@Override
	public String getName() {
		return "Speed Potion";
	}

}
