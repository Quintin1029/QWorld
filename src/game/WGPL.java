package game;

import landmarks.Landmark;
import landmarks.LandmarkCactus;
import landmarks.LandmarkGround;
import landmarks.LandmarkHome;
import landmarks.LandmarkHut;
import landmarks.LandmarkMountain;
import landmarks.LandmarkNull;
import landmarks.LandmarkPath;
import landmarks.LandmarkRuins;
import landmarks.LandmarkSea;
import landmarks.LandmarkShrineBorder;
import landmarks.LandmarkShrineCenter;
import landmarks.LandmarkTree;
import landmarks.LandmarkWell;

/**
 * World Generation Priority List. Used to test the landmark priority whenever adding a new landmark.
 * Any landmarks to be added to the game MUST be added on here or they WILL NOT BE GENERATED!!!
 * @author Quintin Harter
 *
 */
public class WGPL {
	
	//higher priority on top
	public static final Landmark [] priorities = {
			
			//Null landmark should always be top priority for safety reasons.
			new LandmarkNull(),
			
			//Unique landmarks that are necessary to beat the game are very important
			new LandmarkHome(),
			new LandmarkHut(""),
			
			//Special structure landmarks come next
			new LandmarkSea(),
			new LandmarkWell(),
			new LandmarkMountain(),
			new LandmarkShrineCenter(),
			new LandmarkShrineBorder(0),
			new LandmarkPath(),
			new LandmarkCactus(),
			new LandmarkTree(),
			new LandmarkRuins(),
			
			//The ground is least important.
			new LandmarkGround(),
			
	};

	/**
	 * Gets the priority number of a landmark.
	 * The lower the number, the higher the priority.
	 * @param l the landmark type to test
	 * @return the priority number for that landmark
	 */
	public static int getPriority(Landmark l) {
		if (l == null)
			return QMath.LARGE_NUMBER;
		for (int i = 0; i < priorities.length; i++) {
			if (l.getClass().equals(priorities[i].getClass()))
				return i;
		}
		Library.print(l.getName() + " is not registered in WGPL. Please register it.");
		return -1;
	}
	
	/**
	 * Compares 2 landmarks and returns the one of higher priority.
	 * @param l1 the first landmark
	 * @param l2 the second landmark
	 * @return the higher priority landmark
	 */
	public static Landmark getHigherPriority(Landmark l1, Landmark l2) {
		return (getPriority(l1) < getPriority(l2))? l1 : l2;
	}
}
