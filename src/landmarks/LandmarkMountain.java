package landmarks;

import java.awt.Color;

import game.HarvestCondition;
import game.Library;
import resources.Resource;
import resources.ResourceStack;
import util.QRandom;

public class LandmarkMountain extends Landmark {

	@Override
	public boolean getIsSolid() {
		return true;
	}

	@Override
	public ResourceStack getHarvest(Resource toolType) {
		switch(toolType) {
		case ROCK: return new ResourceStack(Resource.ROCK, QRandom.randInt(0, 5));
		case CLOUD:
			break;
		case DARK:
			break;
		case GRASS:
			break;
		case IRON:
			break;
		case WOOD:
			break;
		default:
			break;
		}
		return null;
	}

	@Override
	public Landmark getReplacementLandmark(HarvestCondition condition) {
		return new LandmarkGround();
	}

	@Override
	public String getName() {
		return "Mountain";
	}
	
	@Override
	public Color getBackgroundColor() {
		return Color.GRAY;
	}

}
