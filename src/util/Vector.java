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
	
	@Override
	public String toString() {
		return "(" + getX() + " , " + getY() + ")";
	}
}
