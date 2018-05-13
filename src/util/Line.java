package util;

import game.Library;
import game.QMath;

/**
 * The class representing a line. Used primarily for geometrical calculations.
 * @author Quintin Harter
 *
 */
public class Line {
	double slope;
	double yIntercept;
	
	/**
	 * Constructor.
	 * @param p1 one point on the line
	 * @param p2 a second point on the line
	 */
	public Line (Vector p1, Vector p2) {
		if (p2.getX() - p1.getX() == 0)
			slope = QMath.LARGE_NUMBER;
		else
			slope = ((double)(p2.getY() - p1.getY())) / (p2.getX() - p1.getX());
		yIntercept = p1.getY() - slope * p1.getX();
	}
	
	/**
	 * Evaluates x as a function of the line
	 * @param x the input
	 * @return the output (slope * x + y-intercept)
	 */
	public double evaluate(double x) {
		return slope * x + yIntercept;
	}
	
	/**
	 * Gets an intersection point with another line unless they are parallel.
	 * @param other the other line
	 * @return the point of intersection, null if there is none
	 */
	public Vector getIntersectPoint(Line other) {
		Library.print(toString());
		Library.print(other.toString());
		if (other.slope - slope == 0) {
			if (other.yIntercept - yIntercept == 0)
				return new Vector(Integer.MAX_VALUE, Integer.MAX_VALUE);
			else
				return null;
		}
		double x = -(other.yIntercept - yIntercept) / (other.slope - slope);
		double y = (slope * x + yIntercept);
		return new Vector((int) x, (int) y);
	}
	
	/**
	 * Checks for intersection between two line segments
	 * @param xMin the low bound for this line segment
	 * @param xMax the high bound for this line segment
	 * @param other the other line
	 * @param otherXMin the low bound for the other line segment
	 * @param otherXMax the high bound for the other line segment
	 * @return if the line segments intersect
	 */
	public boolean lineSegmentsIntersect(double xMin, double xMax, Line other, double otherXMin, double otherXMax) {
		Vector intersectPoint = getIntersectPoint(other);
		Library.print("ip: " + intersectPoint);
		if (intersectPoint == null)
			return false;
		if (intersectPoint.equals(new Vector(Integer.MAX_VALUE, Integer.MAX_VALUE)))
			return true;
		return intersectPoint.isWithinBox(new Vector((int)xMin, (int)evaluate(xMin)), new Vector((int)xMax, (int)evaluate(xMax))) &&
				intersectPoint.isWithinBox(new Vector((int)otherXMin, (int)evaluate(otherXMin)), new Vector((int)otherXMax, (int)evaluate(otherXMax)));
	}
	
	@Override
	public String toString() {
		return "y = " + ((int) (slope * 1000)) / 1000. + " * x + " + ((int) yIntercept * 1000) / 1000.;
	}
}