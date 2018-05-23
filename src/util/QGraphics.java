package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import game.Library;

public class QGraphics {
	
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
	
	public static ImageIcon alter(ImageIcon icon, GraphicsTransformation... transformations) {
		return null;
	}
	
	
}
