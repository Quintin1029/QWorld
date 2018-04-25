package util;

import game.Library;
import game.QMath;

public class Line {
	double slope;
	double yIntercept;
	
	public Line (Vector p1, Vector p2) {
		if (p2.getX() - p1.getX() == 0)
			slope = QMath.LARGE_NUMBER;
		else
			slope = ((double)(p2.getY() - p1.getY())) / (p2.getX() - p1.getX());
		yIntercept = p1.getY() - slope * p1.getX();
	}
	
	public double evaluate(double x) {
		return slope * x + yIntercept;
	}
	
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