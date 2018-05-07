package game;

import util.QRandom;

/**
 * A class for common mathematical functions used throughout the game.
 * @author Quintin Harter
 *
 */
public class QMath {

	public static int LARGE_NUMBER = (int)(Integer.MAX_VALUE / 20);
	
	/**
	 * Negates the value if the condition is true
	 * @param value the value to be negated if the condition is true
	 * @param condition the condition to test
	 * @return the value, negated if the condition is true
	 */
	public static double turnNegativeIf(double value, boolean condition) {
		return (condition)? -value : value;
	}
	
	/**
	 * Returns if x is odd
	 * @param x the value to test
	 * @return if x is odd
	 */
	public static boolean isOdd(int x) {
		return x % 2 != 0;
	}
	
	/**
	 * Checks if the value is between the low and high bounds.
	 * @param low the low bound
	 * @param value the value to test
	 * @param high the high bound
	 * @return if low < value < high
	 */
	public static boolean isWithinBounds(double low, double value, double high) {
		return low < high && low < value && value < high;
	}
	
	/**
	 * Gets a random angle in radians
	 * @return a double between 0 and 2pi
	 */
	public static double getRandomAngle() {
		return QRandom.randDouble(0., 2 * Math.PI);
	}
	
}
