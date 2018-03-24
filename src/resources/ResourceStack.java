package resources;

import javax.swing.Icon;

import game.Library;

/**
 * Represents a stack of a single resource. Also contains the static variables that represent resource types.
 * @author Quintin Harter
 *
 */
public class ResourceStack {

	public static final int WOOD = 0;
	public static final int ROCK = 1;
	public static final int GRASS = 2;
	public static final int IRON = 3;
	public static final int DARK = 4;
	
	private int number;
	private int type;
	
	/**
	 * Constructor.
	 * @param type the type of this resource (Use the static variables from ResourceStack.java)
	 * @param number the number of this resource
	 */
	public ResourceStack(int type, int number) {
		this.type = type;
		this.number = number;
	}
	
	/**
	 * Constructor. (Sets the number of resources to 0)
	 * @param type the type of this resource (Use the static variables from ResourceStack.java)
	 */
	public ResourceStack(int type) {
		this.type = type;
		this.number = 0;
	}
	
	/**
	 * Adds another resource stack to this current one (ONLY IF THEY ARE THE SAME TYPE).
	 * @param other the other resource stack to add to this one
	 * @return if they are the same type and the resource stack was successfully added
	 */
	public boolean add(ResourceStack other) {
		if (other.getType() == type) {
			number += other.number;
			return true;
		}
		return false;
	}
	
	/**
	 * Adds a number of resources to this one. Independent of type (because ints don't have types)
	 * @param amount the amount to add
	 */
	public void add(int amount) {
		number += amount;
	}
	
	/**
	 * Subtracts another resource stack from this current one (ONLY IF THEY ARE THE SAME TYPE).
	 * @param other the other resource stack to subtract from this one
	 * @return if they are the same type and the resource stack was successfully subtracted
	 */
	public boolean subtract(ResourceStack other) {
		if (other.getType() == type) {
			number -= other.number;
			return true;
		}
		return false;
	}
	
	/**
	 * Subtracts a number of resources from this one. Independent of type (because ints don't have types)
	 * @param amount the amount to subtract
	 */
	public void subtract(int amount) {
		number -= amount;
	}
	
	/**
	 * Gets the type of this resource stack.
	 * @return the type of this resource stack
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * Gets the number of resources in this stack.
	 * @return the number of resources in this stack
	 */
	public int getNumber() {
		return number;
	}
	
}
