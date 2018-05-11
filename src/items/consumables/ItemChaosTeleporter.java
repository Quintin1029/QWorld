package items.consumables;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;
import game.QMath;
import util.QRandom;
import util.Vector;

public class ItemChaosTeleporter extends ItemConsumable {

	public ItemChaosTeleporter(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_CONSUMABLE_ICONS[8];
	}

	@Override
	public void use() {
		if (unlocked || Library.ENABLE_ALL_ITEMS) {
			// send the player to a random location within a certain radius
			double angle = QMath.getRandomAngle();
			double length = QRandom.randDouble(Library.CHAOS_TELEPORTER_LOW_RANGE, Library.CHAOS_TELEPORTER_HIGH_RANGE);
			Vector newPos = player.getPosition()
					.add(new Vector((int) (length * Math.cos(angle)), (int) (length * Math.sin(angle))));
			newPos.setX((int) Library.clamp(newPos.getX(), 0, Library.WORLD_SIZE));
			newPos.setY((int) Library.clamp(newPos.getY(), 0, Library.WORLD_SIZE));
			player.updatePosition(newPos);
		}
	}

	@Override
	public String getName() {
		return "Chaos Teleporter";
	}

}
