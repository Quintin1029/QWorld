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
	
}
