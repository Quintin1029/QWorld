package worldgen;

import landmarks.*;
import util.*;

public abstract class Structure {
	
	public Structure() {}
	
	/**
	 * Generates this structure in the world
	 * @param world the world to generate in
	 * @param topLeft the top left of the position to draw the structure
	 * @param size the size of the structure
	 */
	public abstract void generate(Landmark [] [] world, Vector topLeft);
	public abstract Vector getSize();	
	
}
