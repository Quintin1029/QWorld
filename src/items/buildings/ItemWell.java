package items.buildings;

import javax.swing.Icon;

import game.Library;
import game.PlayerStatManager;
import landmarks.Landmark;
import landmarks.LandmarkWell;
import resources.Resource;
import resources.ResourceStack;

public class ItemWell extends ItemBuilding {

	public ItemWell(PlayerStatManager player) {
		super(player);
	}

	@Override
	public Landmark getLandmark() {
		return new LandmarkWell();
	}

	@Override
	public Icon getIcon() {
		return Library.ITEM_BUILDING_ICONS[0];
	}

	@Override
	public String getName() {
		return "Well Building";
	}

	@Override
	public ResourceStack[] getCost() {
		ResourceStack[] cost = new ResourceStack[2];
		cost[0] = new ResourceStack(Resource.ROCK, 20);
		cost[1] = new ResourceStack(Resource.WOOD, 20);
		return cost;
	}

}
