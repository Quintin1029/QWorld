package resources;

import javax.swing.Icon;

import game.Library;

public class ResourceStack {

	public static final int WOOD = 0;
	public static final int ROCK = 1;
	public static final int GRASS = 2;
	public static final int IRON = 3;
	public static final int DARK = 4;
	
	private int number;
	private int type;
	
	public ResourceStack(int type, int number) {
		this.type = type;
		this.number = number;
	}
	
	public ResourceStack(int type) {
		this.type = type;
		this.number = 0;
	}
	
	public boolean add(ResourceStack other) {
		if (other.getType() == type) {
			number += other.number;
			return true;
		}
		return false;
	}
	
	public void add(int amount) {
		number += amount;
	}
	
	public boolean subtract(ResourceStack other) {
		if (other.getType() == type) {
			number -= other.number;
			return true;
		}
		return false;
	}
	
	public void subtract(int amount) {
		number -= amount;
	}
	
	public int getType() {
		return type;
	}
	
	public int getNumber() {
		return number;
	}
	
}
