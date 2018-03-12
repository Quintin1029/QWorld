package landmarks;

/**
 * The superclass for enemy landmarks
 * @author Quintin Harter
 *
 */
public abstract class LandmarkEnemy extends LandmarkMoveable {

	@Override
	public boolean getIsSolid() {
		return true;
	}
	
	/**
	 * Get the damage of the enemy
	 * @return the damage of the enemy
	 * @author Quintin Harter
	 */
	public abstract double getDamage();
	/**
	 * Get the health of the enemy
	 * @return the health of the enemy
	 * @author Quintin Harter
	 */
	public abstract double getHealth();

}
