package zones;

import java.awt.Color;

import landmarks.Landmark;

public abstract class Zone {
	
	public abstract Landmark getGroundLandmark();
	public abstract Landmark getPathLandmark();
	public abstract Landmark getTreeLandmark(int index);
	public abstract Landmark getEnemy(int index);
	public abstract double getTemperature();
	public abstract double getTreeFrequency(int index);
	public abstract double getEnemyFrequency(int index);
	public abstract String getName();
	public abstract Color getGroundColor();
	
	public Zone() {}
}
