package zones;

import java.awt.Color;

import game.Library;
import landmarks.*;
import util.Vector;
import worldgen.Structure;
import worldgen.StructureLake;

/**
 * The sea zone
 * @author Quintin Harter
 *
 */
public class ZoneSea extends Zone {

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
		case 0: return new LandmarkGround();
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
	public Structure getStructure(int index) {
		switch(index) {
		case 0: return null;
		}
		return null;
	}

	@Override
	public double getTemperature() {
		return Library.TEMP_COOL;
	}

	@Override
	public double getTreeFrequency(int index) {
		switch(index) {
		case 0: return 0.001;
		}
		return -1.;
	}

	@Override
	public double getEnemyFrequency(int index) {
		switch(index) {
		case 0: return -1;
		}
		return -1.;
	}

	@Override
	public double getStructureFrequency(int index) {
		switch(index) {
		case 0: return -1;
		}
		return -1.;
	}
	
	@Override
	public String getName() {
		return "Sea";
	}

	@Override
	public Color getGroundColor() {
		return Color.CYAN; //light green
	}

}
