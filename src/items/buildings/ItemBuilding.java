package items.buildings;

import game.PlayerStatManager;
import items.Item;

/**
 * The superclass for all building items.
 * @author Quintin Harter
 *
 */
public abstract class ItemBuilding extends Item {

	public ItemBuilding(PlayerStatManager player) {
		super(player);
	}
	
	//TODO the rest of the building stuff (non-critical)
	public abstract void getLandmark();
	
}
