package game;

import util.Vector;

public class PlayerStatManager {

	private double water;
	private double maxWater;
	private double food;
	private double maxFood;
	private double health;
	private double maxHealth;
	private Vector position;
	private Vector home;
	
	public PlayerStatManager() {
		maxWater = 100;
		maxFood = 100;
		maxHealth = 100;
		water = maxWater;
		food = maxFood;
		health = maxHealth;
		home = Vector.VECTOR_CENTER;
		position = Vector.VECTOR_CENTER;
	}
	
	public Vector getPosition() {
		return position;
	}
	
	public void updatePosition(Vector pos) {
		position = pos;
	}
	
	public double getWater() {
		return water;
	}
	
	public double getFood() {
		return food;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getMaxWater() {
		return maxWater;
	}
	
	public double getMaxFood() {
		return maxFood;
	}
	
	public double getMaxHealth() {
		return maxHealth;
	}
	
	public void updateWater(double water) {
		this.water = Library.clamp(water, 0., maxWater);
	}
	
	public void updateMaxWater(double maxWater) {
		this.maxWater = maxWater;
		updateWater(water);
	}
	
	public void updateFood(double food) {
		this.food = Library.clamp(food, 0., maxFood);
	}
	
	public void updateMaxFood(double maxFood) {
		this.maxFood = maxFood;
		updateFood(food);
	}
	
	public void updateHealth(double health) {
		this.health = Library.clamp(health, 0., maxHealth);
	}
	
	public void updateMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
		updateHealth(health);
	}
	
	public void setHome(Vector home) {
		this.home = home;
	}
	
	public Vector getHome() {
		return home;
	}
	
	@Override
	public String toString() {
		return "Player Stats: WATER: " + water + " FOOD: " + food + " HEALTH: " + health; 
	}
	
}
