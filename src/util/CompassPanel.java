package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

public class CompassPanel extends JPanel {

	public static int DIAMETER = 60;
	public static int DISPLACEMENT = 10;
	private static int [] XPOINTS = {-2, -2, -6, 0, 6, 2, 2};
	private static int [] YPOINTS = {0, DIAMETER / 4 - 4, DIAMETER / 4 - 4, DIAMETER / 2, DIAMETER / 4 - 4, DIAMETER / 4 - 4, 0};
	public static Polygon ARROW = new Polygon(XPOINTS, YPOINTS, 7);
	
	private double angle;
	
	public CompassPanel() {
		angle = 0;
	}
	
	public void setAngle(double angle) {
		this.angle = angle;
		this.repaint(0, 0, DIAMETER + 2 * DISPLACEMENT, DIAMETER + 2 * DISPLACEMENT);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(new Color(238, 238, 238));
		g2.fillRect(0, 0, DIAMETER + 2 * DISPLACEMENT, DIAMETER + 2 * DISPLACEMENT);
		g2.setColor(Color.YELLOW);
		g2.fillOval(DISPLACEMENT, DISPLACEMENT, DIAMETER, DIAMETER);
		g2.translate(DISPLACEMENT + DIAMETER / 2, DISPLACEMENT + DIAMETER / 2);
		g2.rotate(angle * Math.PI / 180. + Math.PI);
		g.setColor(Color.RED);
		g.fillPolygon(ARROW);
	}
	
}
