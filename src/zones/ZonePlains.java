package zones;

import game.Library;
import landmarks.*;

public class ZonePlains extends Zone {

	@Override
	public Landmark getGroundLandmark() {
		return new LandmarkGround();
	}

	@Override
	public Landmark getPathLandmark() {
		return new LandmarkPath();
	}

	@Override
	public Landmark getTreeLandmark(int index) {
		return new LandmarkTree();
	}

	@Override
	public Landmark getEnemy(int index) {
		return null;
	}

	@Override
	public double getTemperature() {
		return Library.TEMP_NORMAL;
	}

	@Override
	public double getTreeFrequency(int index) {
		return 0.1;
	}

	@Override
	public double getEnemyFrequency(int index) {
		return 0.1;
	}

	@Override
	public String getName() {
		return "Plains";
	}

}
