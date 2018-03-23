package resources;

import javax.swing.Icon;

import game.Library;

public class ResourceStack<E extends ResourceStack.Resource> {

	private int number;
	
	public void add(ResourceStack<E> other) {
		number += other.number;
	}
	
	public void add(int amount) {
		number += amount;
	}
	
	public void subtract(ResourceStack<E> other) {
		number -= other.number;
	}
	
	public void subtract(int amount) {
		number -= amount;
	}
	
	public int getNumber() {
		return number;
	}
	
	public abstract class Resource {}
	public class ResourceWood extends Resource {}
	public class ResourceRock extends Resource {}
	public class ResourceGrass extends Resource {}
	public class ResourceIron extends Resource {}
	public class ResourceDark extends Resource {}
	
}
