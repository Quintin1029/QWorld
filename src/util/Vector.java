package util;

import game.Library;
import game.QMath;

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
	 * Sets the x value
	 * @param x the new value
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Sets the y value
	 * @param y the new value
	 */
	public void setY(int y) {
		this.y = y;
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
	
	/**
	 * Multiplies the vector by a scalar
	 * @param value the scalar
	 * @return the new vector
	 */
	public Vector multiply(double value) {
		return new Vector((int)(getX() * value), (int)(getY() * value));
	}
	
	/**
	 * Subtracts this vector by the vector provided
	 * @param b the vector to subtract
	 * @return the new vector
	 * @author Quintin Harter
	 */
	public Vector subtract(Vector b) {
		return new Vector(getX() - b.getX(), getY() - b.getY());
	}
	
	/**
	 * Gets the magnitude of this vector
	 * @return the magnitude
	 */
	public double getMagnitude() {
		return Math.sqrt(getX() * getX() + getY() * getY());
	}
	
	/**
	 * Gets the dot product of this and another vector
	 * @param v the other vector
	 * @return the dot product
	 */
	public int dotProduct(Vector v) {
		return getX() * v.getX() + getY() * v.getY();
	}
	
	/**
	 * Gets the angle (in radians) in between this and another vector
	 * @param v the other vector
	 * @return the angle between (in radians)
	 */
	public double getAngleBetween(Vector v) {
		return Math.acos(dotProduct(v) / (getMagnitude() * v.getMagnitude()));
	}
	
	/**
	 * Returns if this point is inside the triangle given by the vertices
	 * @param vertex1 the first vertex
	 * @param vertex2 the second vertex
	 * @param vertex3 the third vertex
	 * @return whether or not the point is inside the triangle
	 */
	public boolean isInsideTriangle(Vector vertex1, Vector vertex2, Vector vertex3) {
		//to find if a point is in a vector we can get the angles from the point to each of the sides and add them up
		//if the sum is 2pi then we are in the triangle
		double sum = 0.0;
		sum += Math.abs(vertex1.subtract(this).getAngleBetween(vertex2.subtract(this))); //first side
		sum += Math.abs(vertex2.subtract(this).getAngleBetween(vertex3.subtract(this))); //second side
		sum += Math.abs(vertex3.subtract(this).getAngleBetween(vertex1.subtract(this))); //third side
		boolean result = sum > 2 * Math.PI - 0.02 && sum < 2 * Math.PI + 0.02;
		return result; //we put a small range of error in case of rounding mistakes
	}
	
	/**
	 * Checks if a point is inside a polygon. NOT WORKING FIXME
	 * @param points the corners of the polygon
	 * @return if the point is inside the polygon
	 */
	public boolean isInsidePolygon(Vector... points) {
		//Library.print("Testing inside polygon for " + toString());
		if (points.length < 3)
			return false;
		//loop through each line segment of the polygon, and check the 
		//number of times the horizontal ray from this vector to the right
		//intersects one of those line segments
		int intersectCount = 0;
		Vector farRight = new Vector(QMath.LARGE_NUMBER, 0);
		for (int index = 0; index < points.length; index++) {
			//Library.print("\nTesting points " + points[index].toString() + " and " + points[(index + 1) % points.length].toString());
			if (lineSegmentsIntersect(this, farRight, points[index], points[(index + 1) % points.length])) {
				intersectCount++;
				//Library.print("Intersection with " + points[index].toString() + " and " + points[(index + 1) % points.length].toString());
			}
		}
		Library.print("Intersections for point " + this + ": " + intersectCount);
		return QMath.isOdd(intersectCount);
	}
	
	/**
	 * Checks if line segments made by vectors intersect.
	 * @param p11 one end of the first line segment
	 * @param p12 the other end of the first line segment
	 * @param p21 one end of the second line segment
	 * @param p22 the other end of the second line segment
	 * @return if the segments intersect
	 */
	public static boolean lineSegmentsIntersect(Vector p11, Vector p12, Vector p21, Vector p22) {
		
		int xMin1 = Math.min(p11.getX(), p12.getX());
		int xMax1 = Math.max(p11.getX(), p12.getX());
		int xMin2 = Math.min(p21.getX(), p22.getX());
		int xMax2 = Math.max(p21.getX(), p22.getX());
		
		Line line1 = new Line(p11, p12);
		Line line2 = new Line(p21, p22);
		
		boolean result = line1.lineSegmentsIntersect(xMin1, xMax1, line2, xMin2, xMax2);
		Library.print(new Vector(xMin1, (int)line1.evaluate(xMin1)).toString() + " - " + new Vector(xMax1, (int)line1.evaluate(xMax1)).toString());
		Library.print(new Vector(xMin2, (int)line2.evaluate(xMin2)).toString() + " - " + new Vector(xMax2, (int)line2.evaluate(xMax2)).toString());
		Library.print("" + result);
		return result;
		
		/*
		//we first find the orientations needed
		int o1 = getOrientation(p11, p12, p21);
		int o2 = getOrientation(p11, p12, p22);
		int o3 = getOrientation(p21, p22, p11);
		int o4 = getOrientation(p21, p22, p12);
		//Library.print("Orientation of points " + p11 + " and " + p12 + " and " + p21 + " is " + o1);
		//Library.print("Orientation of points " + p11 + " and " + p12 + " and " + p22 + " is " + o2);
		//Library.print("Orientation of points " + p21 + " and " + p22 + " and " + p11 + " is " + o3);
		//Library.print("Orientation of points " + p21 + " and " + p22 + " and " + p12 + " is " + o4);

		//general case
		if (o1 != o2 && o3 != o4)
			return true;
		//Library.print("Special case");
		//special cases: all points are collinear
		return ((o1 == ORIENTATION_COLINEAR && p21.isWithinBounds(p11, p12)) ||
				(o2 == ORIENTATION_COLINEAR && p22.isWithinBounds(p11, p12)) ||
				(o3 == ORIENTATION_COLINEAR && p11.isWithinBounds(p21, p22)) ||
				(o4 == ORIENTATION_COLINEAR && p12.isWithinBounds(p21, p22)));
		*/
	}
	
	//prereq: points are colinear
	public boolean isWithinBounds(Vector bound1, Vector bound2) {
		return (getX() < Math.max(bound1.getX(), bound2.getX()) && 
				getX() > Math.min(bound1.getX(), bound2.getX()) &&
				getY() < Math.max(bound1.getY(), bound2.getY()) &&
				getY() < Math.min(bound1.getY(), bound2.getY())
				);
	}
	
	/**
	 * Checks if a vector is inside a box
	 * @param bottomLeft the bottom left of the box
	 * @param topRight the top right of the box
	 * @return if the vector is in the box
	 */
	public boolean isWithinBox(Vector bottomLeft, Vector topRight) {
		return getX() >= bottomLeft.getX() && getX() <= topRight.getX() &&
				getY() >= bottomLeft.getY() && getY() <= topRight.getY();
	}
	
	public static final int ORIENTATION_COUNTERCLOCKWISE = 0;
	public static final int ORIENTATION_CLOCKWISE = 1;
	public static final int ORIENTATION_COLINEAR = 2;
	
	/**
	 * Returns the orientation of three vectors
	 * @param p1 one point
	 * @param p2 another point
	 * @param p3 a third point
	 * @return the orientation (see ORIENTATION_ constants)
	 */
	public static int getOrientation(Vector p1, Vector p2, Vector p3) {	
		int val = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) - (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());
		return (val == 0)? ORIENTATION_COLINEAR : ((val > 0)? ORIENTATION_CLOCKWISE : ORIENTATION_COUNTERCLOCKWISE);
	}
	
	
	@Override
	public String toString() {
		return "(" + getX() + " , " + getY() + ")";
	}
}
