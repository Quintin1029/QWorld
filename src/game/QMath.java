package game;

public class QMath {

	public static int LARGE_NUMBER = (int)(Integer.MAX_VALUE / 20);
	
	public static double turnNegativeIf(double value, boolean condition) {
		return (condition)? -value : value;
	}
	
	public static boolean isOdd(int x) {
		return x % 2 != 0;
	}
	
	public static boolean isWithinBounds(double low, double value, double high) {
		return low < high && low < value && value < high;
	}
	
}
