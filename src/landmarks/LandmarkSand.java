package landmarks;

import javax.swing.ImageIcon;

import game.Library;

/**
 * The sand landmark.
 * @author Quintin Harter
 *
 */
public class LandmarkSand extends LandmarkGround {

	@Override
	public ImageIcon getIcon() {
		return Library.LANDMARK_ICONS[11];
	}
	
	@Override
	public String getName() {
		return "Sand";
	}
	
}
