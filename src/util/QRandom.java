package util;

import java.util.Random;

public class QRandom {

	public static Random random = new Random();
	
	public static boolean rollDie(double probabilityOfTrue) {
		return random.nextDouble() < probabilityOfTrue;
	}
	
}
