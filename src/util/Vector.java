package util;

import game.Library;

/**
 * Represents a 2D vector used throughout the game.
 * @author Quintin Harter
 *
 */
public class Vector {

	public static Vector VECTOR_ZERO = new Vector(0, 0);
	public static Vector VECTOR_UP = new Vector(0, -1);
	public static Vector VECTOR_RIGHT = new Vector(1, 0);
	public static Vector VECTOR_DOWN = new Vector(0, 1);
	public static Vector VECTOR_LEFT = new Vector(-1, 0);
	
	public static Vector VECTOR_CENTER = new Vector(Library.WORLD_SIZE / 2, Library.WORLD_SIZE / 2);
	
	private int x;
	private int y;
	
	/**
	 * Constructor
	 * @param x the x component of the vector
	 * @param y the y component of the vector
	 * @author Quintin Harter
	 */
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the X component of this vector
	 * @return X
	 * @author Quintin Harter
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the Y component of this vector
	 * @return Y
	 * @author Quintin Harter
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Adds this vector to the vector provided
	 * @param b the vector to add
	 * @return the new vector
	 * @author Quintin Harter
	 */
	public Vector add(Vector b) {
		return new Vector(getX() + b.getX(), getY() + b.getY());
	}
	
	public Vector subtract(Vector b) {
		return new Vector(getX() - b.getX(), getY() - b.getY());
	}
	
	public double getMagnitude() {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}
	
	public int dotProduct(Vector v) {
		return getX() * v.getX() + getY() * v.getY();
	}
	
	public double getAngleBetween(Vector v) {
		return Math.acos(dotProduct(v) / (getMagnitude() * v.getMagnitude()));
	}
	
	public boolean isInsideTriangle(Vector vertex1, Vector vertex2, Vector vertex3) {
		//to find if a point is in a vector we can get the angles from the point to each of the sides and add them up
		//if the sum is 2pi then we are in the triangle
		double sum = 0.0;
		sum += Math.abs(vertex1.subtract(this).getAngleBetween(vertex2.subtract(this))); //first side
		sum += Math.abs(vertex2.subtract(this).getAngleBetween(vertex3.subtract(this))); //second side
		sum += Math.abs(vertex3.subtract(this).getAngleBetween(vertex1.subtract(this))); //third side
		boolean result = sum > 2 * Math.PI - 0.01 && sum < 2 * Math.PI + 0.01;
		return result; //we put a small range of error in case of rounding mistakes
	}
	
	@Override
	public String toString() {
		return "(" + getX() + " , " + getY() + ")";
	}
}
