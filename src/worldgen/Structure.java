package worldgen;

import landmarks.Landmark;
import util.Vector;

public abstract class Structure {
	
	public Structure() {}
	
	/**
	 * Generates this structure in the world
	 * @param world the world to generate in
	 * @param topLeft the top left of the position to draw the structure
	 * @param size the size of the structure
	 */
	public abstract void generate(Landmark [] [] world, Vector topLeft);
	
	/**
	 * Gets the size of this structure.
	 * @return the size of this structure.
	 */
	public abstract Vector getSize();	
	
	/**
	 * Gets the name of thus structure (usually for debugging)
	 * @return the name of the structure
	 */
	public abstract String getName();
}
