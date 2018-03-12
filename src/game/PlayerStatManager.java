package game;

import util.Vector;

/**
 * Represents the player object in the game. Manages the player's statistics.
 * @author Quintin Harter
 *
 */
public class PlayerStatManager {

	private double water;
	private double maxWater;
	private double food;
	private double maxFood;
	private double health;
	private double maxHealth;
	private Vector position;
	private Vector home;
	
	/**
	 * The default constructor. Sets max water, food, and health to 100.
	 * @author Quintin Harter
	 */
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
	
	/**
	 * Gets the position of the player relative to the origin (top left).
	 * @return the player's position
	 * @author Quintin Harter
	 */
	public Vector getPosition() {
		return position;
	}
	
	/**
	 * Sets the player's position relative to the origin (top left).
	 * @param pos the new position
	 * @author Quintin Harter
	 */
	public void updatePosition(Vector pos) {
		position = pos;
	}
	
	/**
	 * Gets the player's water supply
	 * @return the player's water
	 * @author Quintin Harter
	 */
	public double getWater() {
		return water;
	}
	
	/**
	 * Gets the player's food supply
	 * @return the player's food
	 * @author Quintin Harter
	 */
	public double getFood() {
		return food;
	}
	
	/**
	 * Gets the player's health
	 * @return the player's health
	 * @author Quintin Harter
	 */
	public double getHealth() {
		return health;
	}
	
	/**
	 * Gets the player's maximum water
	 * @return the player's maximum water
	 * @author Quintin Harter
	 */
	public double getMaxWater() {
		return maxWater;
	}
	
	/**
	 * Gets the player's maximum food
	 * @return the player's maximum food
	 * @author Quintin Harter
	 */
	public double getMaxFood() {
		return maxFood;
	}
	
	/**
	 * Gets the player's maximum health
	 * @return the player's maximum health
	 * @author Quintin Harter
	 */
	public double getMaxHealth() {
		return maxHealth;
	}
	
	/**
	 * Sets the player's water (clamped between 0 and the player's maximum water)
	 * @param the new water
	 * @author Quintin Harter
	 */
	public void updateWater(double water) {
		this.water = Library.clamp(water, 0., maxWater);
	}
	
	/**
	 * Sets the player's maximum water, then updates the water
	 * @param maxWater the new maximum water
	 * @author Quintin Harter
	 */
	public void updateMaxWater(double maxWater) {
		this.maxWater = maxWater;
		updateWater(water);
	}
	
	/**
	 * Sets the player's food (clamped between 0 and the player's maximum food)
	 * @param the new food
	 * @author Quintin Harter
	 */
	public void updateFood(double food) {
		this.food = Library.clamp(food, 0., maxFood);
	}
	
	/**
	 * Sets the player's maximum food, then updates the food
	 * @param maxFood the new maximum food
	 * @author Quintin Harter
	 */
	public void updateMaxFood(double maxFood) {
		this.maxFood = maxFood;
		updateFood(food);
	}
	
	/**
	 * Sets the player's health (clamped between 0 and the player's maximum health)
	 * @param the new health
	 * @author Quintin Harter
	 */
	public void updateHealth(double health) {
		this.health = Library.clamp(health, 0., maxHealth);
	}
	
	/**
	 * Sets the player's maximum health, then updates the health
	 * @param maxFood the new maximum health
	 * @author Quintin Harter
	 */
	public void updateMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
		updateHealth(health);
	}
	
	/**
	 * Sets the player's home location as used by the compass
	 * @param home the player's new home
	 * @author Quintin Harter
	 */
	public void setHome(Vector home) {
		this.home = home;
	}
	
	/**
	 * Gets the player's home location as used by the compass
	 * @return the home vector
	 * @author Quintin Harter
	 */
	public Vector getHome() {
		return home;
	}
	
	@Override
	public String toString() {
		return "Player Stats: WATER: " + water + " FOOD: " + food + " HEALTH: " + health; 
	}
	
}
