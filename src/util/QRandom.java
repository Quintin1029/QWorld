package util;

import java.util.Random;

/**
 * The static class to use for certain random methods
 * @author Quintin Harter
 *
 */
public class QRandom {

	public static Random random = new Random();
	
	/**
	 * Returns true based on the probability passed
	 * @param probabilityOfTrue the probability this method will return true
	 * @return the result
	 * @author Quintin Harter
	 */
	public static boolean rollDie(double probabilityOfTrue) {
		return random.nextDouble() < probabilityOfTrue;
	}
	
	/**
	 * Returns a random integer between low and high, inclusive
	 * @param low the lower bound
	 * @param high the upper bound
	 * @return a random integer between those bouds, inclusive
	 */
	public static int randInt(int low, int high) {
		return random.nextInt(high + 1 - low) + low;
	}
	
	public static double randDouble(double low, double high) {
		return random.nextDouble() * (high - low) + low;
	}
	
}
