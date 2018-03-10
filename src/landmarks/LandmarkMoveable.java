package landmarks;

public abstract class LandmarkMoveable extends Landmark {

	public Landmark covering;
	
	public Landmark getCovering() {
		return covering;
	}
	
	public boolean canMoveTo(Landmark lm) {
		return !lm.getIsSolid();
	}

}
