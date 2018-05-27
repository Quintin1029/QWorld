package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

/**
 * The utility class used to statically manipulate image icons.
 * @author Quintin Harter
 *
 */
public class QGraphics {
	
	/**
	 * Overlays two image icons. This is the main method that affects the time complexity of movement.
	 * @param top the top icon to overlay
	 * @param bottom the bottom icon to overlay
	 * @return the overlayed icon.
	 */
	public static ImageIcon overlay(ImageIcon top, ImageIcon bottom) {	
		try {
		int w = Math.max(top.getIconWidth(), bottom.getIconWidth());
		int h = Math.max(top.getIconHeight(), bottom.getIconHeight());
		BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = img.createGraphics();
		g.drawImage(bottom.getImage(), w - bottom.getIconWidth(), h - bottom.getIconHeight(), null);
		g.drawImage(top.getImage(), w - top.getIconWidth(), h - top.getIconHeight(), null);
		g.dispose();
		
		return new ImageIcon(img);
		} catch (NullPointerException e) {
			return (top == null)? bottom : (bottom == null)? top : null;
		}
	}
	
	/**
	 * TODO Alters the image icon using the specified graphics transformation in the order given.
	 * @param icon the icon to alter
	 * @param transformations the transformations to apply (in order).
	 * @return the resulting icon
	 */
	public static ImageIcon alter(ImageIcon icon, GraphicsTransformation... transformations) {
		return null;
	}
	
	
}
