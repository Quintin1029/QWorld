package zones;

import java.awt.Color;

import landmarks.Landmark;
import util.Vector;
import worldgen.Structure;

/**
 * The superclass for all zones
 * @author Quintin Harter
 *
 */
public abstract class Zone {
	
	/**
	 * Gets the ground landmark for this zone
	 * @return the ground landmark
	 * @author Quintin Harter
	 */
	public abstract Landmark getGroundLandmark();
	/**
	 * Gets the path landmark for this zone
	 * @return the path landmark
	 * @author Quintin Harter
	 */
	public abstract Landmark getPathLandmark();
	/**
	 * Gets the tree landmark for this zone and index
	 * @return the tree landmark of the specified index, null if index is OOD
	 * @param index the index of the tree to generate
	 * @author Quintin Harter
	 */
	public abstract Landmark getTreeLandmark(int index);
	/**
	 * Gets the enemy landmark for this zone and index
	 * @return the enemy landmark of the specified index, null if index is OOD
	 * @param index the index of the enemy to generate
	 * @author Quintin Harter
	 */
	public abstract Landmark getEnemy(int index);
	
	public abstract Structure getStructure(int index);

	/**
	 * Gets the temperature of the zone
	 * @return the temperature of the zone
	 * @author Quintin Harter
	 */
	public abstract double getTemperature();
	/**
	 * Gets the frequency of the tree with the specified index
	 * @param index the index of the tree
	 * @return the frequency of the tree with the specified index, -1. if index is OOD
	 * @author Quintin Harter
	 */
	public abstract double getTreeFrequency(int index);
	/**
	 * Gets the frequency of the enemy with the specified index
	 * @param index the index of the enemy
	 * @return the frequency of the enemy with the specified index, -1. if index is OOD
	 * @author Quintin Harter
	 */
	public abstract double getEnemyFrequency(int index);
	
	public abstract double getStructureFrequency(int index);
	
	/**
	 * Gets the name of the zone
	 * @return the name of the zone
	 * @author Quintin Harter
	 */
	public abstract String getName();
	/**
	 * Gets the color of the ground in this zone
	 * @return the color of the ground
	 * @author Quintin Harter
	 */
	public abstract Color getGroundColor();
		
	public Zone() {}
}
