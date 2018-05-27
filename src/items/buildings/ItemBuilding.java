package items.buildings;

import game.PlayerStatManager;
import items.Item;
import landmarks.Landmark;
import resources.ResourceStack;

/**
 * The superclass for all building items.
 * @author Quintin Harter
 */
public abstract class ItemBuilding extends Item {

	public ItemBuilding(PlayerStatManager player) {
		super(player);
	}
	
	@Override
	public void use() {
		//first check that the player has the resources
		for (ResourceStack rs : getCost())
			if (!player.containsResource(rs))
				return;
		//drop the landmark
		player.getGame().world[player.getPosition().getX()][player.getPosition().getY()] = getLandmark();
		//subtract the resources
		for (ResourceStack rs : getCost())
			player.subtractResource(rs);
	}
	
	//TODO the rest of the building stuff (non-critical)
	public abstract Landmark getLandmark();
	
	/**
	 * Gets the resource stacks needed to build the building.
	 * @return an array of the resource stacks needed.
	 */
	public abstract ResourceStack[] getCost();
	
}
