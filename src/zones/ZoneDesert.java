package zones;

import java.awt.Color;

import game.Library;
import landmarks.Landmark;
import landmarks.LandmarkCactus;
import landmarks.LandmarkPath;
import landmarks.LandmarkSand;
import worldgen.Structure;
import worldgen.StructureOasis;

/**
 * The desert zone
 * @author Quintin Harter
 *
 */
public class ZoneDesert extends Zone {

	@Override
	public Landmark getGroundLandmark() {
		return new LandmarkSand();
	}

	@Override
	public Landmark getPathLandmark() {
		return new LandmarkPath();
	}

	@Override
	public Landmark getTreeLandmark(int index) {
		switch(index) {
		case 0: return new LandmarkCactus();
		}
		return null;
	}

	@Override
	public Landmark getEnemy(int index) {
		return null;
	}

	@Override
	public Structure getStructure(int index) {
		switch(index) {
		case 0: return new StructureOasis();
		}
		return null;
	}

	@Override
	public double getTemperature() {
		return Library.TEMP_HOT;
	}

	@Override
	public double getTreeFrequency(int index) {
		switch (index) {
		case 0: return 0.005;
		}
		return -1;
	}

	@Override
	public double getEnemyFrequency(int index) {
		return -1;
	}

	@Override
	public double getStructureFrequency(int index) {
		switch(index) {
		case 0: return 0.0003;
		}
		return -1;
	}

	@Override
	public String getName() {
		return "Desert";
	}

	@Override
	public Color getGroundColor() {
		return new Color(255, 237, 164);
	}

}
