package worldgen;

import game.Library;
import game.QMath;
import util.QRandom;
import util.Vector;

/**
 * Generates a range (such as a mountain range) using an algorithm similar to the IslandGenerator.
 * NOT WORKING FIXME
 * @author Quintin Harter
 *
 */
public class RangeGenerator {

	private boolean [] [] map;
	
	/**
	 * Constructor: generates the range
	 * @param minLength the minimum range length
	 * @param maxLength the maximum range length
	 * @param minWidth the minumum range width
	 * @param maxWidth the maximum range width
	 * @param accuracy the number of arms
	 */
	public RangeGenerator(double minLength, double maxLength, double minWidth, double maxWidth, int accuracy) {
		
		Library.print("minLength: " + minLength + " maxLength: " + maxLength + " minWidth: " + minWidth + " maxWidth: " + maxWidth + " accuracy: " + accuracy);
		
		//generate the angle, length, and width
		double angle = 0;//QRandom.randDouble(0, 2 * Math.PI);
		double length = QRandom.randDouble(minLength, maxLength);
		double width = QRandom.randDouble(minWidth, maxWidth);
		
		Library.print("Angle: " + Math.toDegrees(angle) + " Length: " + length + " Width: " + width);
		
		//generate arms
		map = new boolean [(int) maxLength] [(int) maxLength];
		Vector center = new Vector(map.length / 2, map.length / 2);
		Vector rangeMagnitude = center.add(new Vector((int)(length * Math.cos(angle)), (int)(Math.sin(angle))));
		Vector arms [] = new Vector [accuracy * 2];
		for (int i = 0; i < arms.length; i++) {
			//We generate a scaling factor so that the range is not square.
			//While the range will still be clamped, the scaling factor allows for a more natural feel.
			double scalingFactor = Math.abs(Math.sin(i % (arms.length / 2)) / arms.length * Math.PI * 2);
			double armWidth = width * scalingFactor;
			arms[i] = new Vector((int)(armWidth * QMath.turnNegativeIf(Math.cos(angle), i % (arms.length / 2) == i)), (int)(armWidth * QMath.turnNegativeIf(Math.sin(angle), i % (arms.length / 2) == i)));
			arms[i] = rangeMagnitude.multiply(i * 1. / arms.length).add(arms[i]);
		}
		
		Library.print(Library.arrayToString(arms));
		
		//bool the map
		
		for (int x = 0; x < map.length; x++) {
			for(int y = 0; y < map.length; y++) {
				map[x][y] = new Vector(x, y).isInsidePolygon(arms);
			}
		}
		
		//print
		for (int i = 0; i < map.length; i++) { 
			for (int k = 0; k < map[i].length; k++) {
				for (int arm = 0; arm < arms.length; arm++)
					if (arms[arm].getX() == i && arms[arm].getY() == k) {
						System.out.print("A ");
						break;
					}
				System.out.print((map[i][k])? "0 " : ". ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * Returns the range generated
	 * @return the map generated
	 */
	public boolean [] [] getRange() {
		return map;
	}
	
}
