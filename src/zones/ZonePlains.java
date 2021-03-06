package zones;

import java.awt.Color;

import game.Library;
import landmarks.Landmark;
import landmarks.LandmarkGround;
import landmarks.LandmarkPath;
import landmarks.LandmarkTree;
import landmarks.LandmarkWell;
import worldgen.Structure;
import worldgen.StructureLake;
import worldgen.StructureRuins;
import worldgen.StructureShrine;

/**
 * The plains zone
 * @author Quintin Harter
 *
 */
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
		switch(index) {
		case 0: return new LandmarkTree();
		case 1: return new LandmarkWell();
		} 
		return null;
	}

	@Override
	public Landmark getEnemy(int index) {
		switch(index) {
		case 0: return null;
		} 
		return null;
	}

	@Override
	public double getTemperature() {
		return Library.TEMP_NORMAL;
	}

	@Override
	public double getTreeFrequency(int index) {
		switch(index) {
		case 0: return 0.005;
		case 1: return 0.001;
		}
		return -1.;
	}

	@Override
	public double getEnemyFrequency(int index) {
		switch(index) {
		case 0: return 0.1;
		}
		return -1.;
	}

	@Override
	public String getName() {
		return "Plains";
	}

	@Override
	public Color getGroundColor() {
		return new Color(122, 239, 83); //light green
	}

	@Override
	public Structure getStructure(int index) {
		switch(index) {
		case 0: return new StructureLake();
		case 1: return new StructureRuins();
		case 2: return new StructureShrine();
		}
		return null;
	}

	@Override
	public double getStructureFrequency(int index) {
		switch(index) {
		case 0: return 0.0005;
		case 1: return 0.0001;
		case 2: return 0.0001;
		}
		return -1.;
	}

}
