package landmarks;

/**
 * The superclass for the movable landmarks
 * @author Quintin Harter
 *
 */
public abstract class LandmarkMoveable extends Landmark {

	public Landmark covering;
	
	public Landmark getCovering() {
		return covering;
	}
	
	public boolean canMoveTo(Landmark lm) {
		return !lm.getIsSolid();
	}

}
