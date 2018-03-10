package landmarks;

public abstract class LandmarkEnemy extends LandmarkMoveable {

	@Override
	public boolean getIsSolid() {
		return true;
	}
	
	public abstract double getDamage();
	public abstract double getHealth();

}
