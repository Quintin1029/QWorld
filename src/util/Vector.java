package util;

public class Vector {

	public static Vector VECTOR_ZERO = new Vector(0, 0);
	public static Vector VECTOR_UP = new Vector(0, -1);
	public static Vector VECTOR_RIGHT = new Vector(1, 0);
	public static Vector VECTOR_DOWN = new Vector(0, 1);
	public static Vector VECTOR_LEFT = new Vector(-1, 0);
	
	private int x;
	private int y;
	
	public Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Vector add(Vector b) {
		return new Vector(getX() + b.getX(), getY() + b.getY());
	}
	
	public String toString() {
		return "(" + getX() + " , " + getY() + ")";
	}
}
