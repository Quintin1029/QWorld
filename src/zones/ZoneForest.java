package zones;

import java.awt.Color;

import game.Library;
import landmarks.Landmark;
import landmarks.LandmarkGround;
import landmarks.LandmarkPath;
import landmarks.LandmarkTree;
import worldgen.Structure;

public class ZoneForest extends Zone {

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
		switch(index) {
		case 0: return new LandmarkTree();
		}
		return null;
	}

	@Override
	public Landmark getEnemy(int index) {
		return null;
	}

	@Override
	public Structure getStructure(int index) {
		return null;
	}

	@Override
	public double getTemperature() {
		return Library.TEMP_NORMAL;
	}

	@Override
	public double getTreeFrequency(int index) {
		switch(index) {
		case 0: return 0.05;
		}
		return -1;
	}

	@Override
	public double getEnemyFrequency(int index) {
		return -1;
	}

	@Override
	public double getStructureFrequency(int index) {
		return -1;
	}

	@Override
	public String getName() {
		return "Forest";
	}

	@Override
	public Color getGroundColor() {
		return new Color(20, 136, 0);
	}

}
