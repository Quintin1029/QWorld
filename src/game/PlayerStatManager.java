package game;

import java.util.HashMap;

import items.*;
import items.buildings.ItemBuilding;
import items.consumables.ItemConsumable;
import items.consumables.ItemLunchBox;
import items.consumables.ItemMedKit;
import items.consumables.ItemStrengthPotion;
import items.consumables.ItemWaterBottle;
import items.tools.ItemStick;
import items.tools.ItemTool;
import resources.ResourceStack;
import util.Vector;

/**
 * Represents the player object in the game. Manages the player's statistics.
 * @author Quintin Harter
 *
 */
public class PlayerStatManager {
	
	private Game game;

	private ItemConsumable [] consumables;
	private ItemTool [] tools;
	private ItemBuilding [] buildings;
	
	private double water = 100;
	private double maxWater = 100;
	private double food = 100;
	private double maxFood = 100;
	private double health = 100;
	private double maxHealth = 100;
	private Vector position = Vector.VECTOR_CENTER;
	private Vector home = Vector.VECTOR_CENTER;
	
	//item options
	private int strengthMovesRemaining = 0;
	
	//resources
	private ResourceStack woodStack = new ResourceStack(ResourceStack.WOOD);
	private ResourceStack rockStack = new ResourceStack(ResourceStack.ROCK);
	private ResourceStack  grassStack = new ResourceStack(ResourceStack.GRASS);
	private ResourceStack ironStack = new ResourceStack(ResourceStack.IRON);
	private ResourceStack darkStack = new ResourceStack(ResourceStack.DARK);
	
	/**
	 * The default constructor
	 * @author Quintin Harter
	 */
	public PlayerStatManager(Game game) {
		this.game = game;
		//add all the items
		consumables = new ItemConsumable[Library.CARRYING_CAPACITY];
		tools = new ItemTool[Library.CARRYING_CAPACITY];
		buildings = new ItemBuilding[Library.CARRYING_CAPACITY];
		
		consumables[0] = new ItemWaterBottle(this);
		consumables[1] = new ItemLunchBox(this);
		consumables[2] = new ItemMedKit(this);
		consumables[3] = new ItemStrengthPotion(this);
		
		tools[0] = new ItemStick(this);
		
	}
	
	public ItemConsumable[] getConsumables() {return consumables;}
	public ItemTool[] getTools() {return tools;}
	public ItemBuilding[] getBuildings() {return buildings;}
	
	/**
	 * Gets the game attached to this player.
	 * @return the instance of the game
	 */
	public Game getGame() {
		return game;
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
		game.update();
	}
	
	/**
	 * Sets the player's maximum water, then updates the water
	 * @param maxWater the new maximum water
	 * @author Quintin Harter
	 */
	public void updateMaxWater(double maxWater) {
		this.maxWater = maxWater;
		updateWater(water);
		game.update();
	}
	
	/**
	 * Sets the player's food (clamped between 0 and the player's maximum food)
	 * @param the new food
	 * @author Quintin Harter
	 */
	public void updateFood(double food) {
		this.food = Library.clamp(food, 0., maxFood);
		game.update();
	}
	
	/**
	 * Sets the player's maximum food, then updates the food
	 * @param maxFood the new maximum food
	 * @author Quintin Harter
	 */
	public void updateMaxFood(double maxFood) {
		this.maxFood = maxFood;
		updateFood(food);
		game.update();
	}
	
	/**
	 * Sets the player's health (clamped between 0 and the player's maximum health)
	 * @param the new health
	 * @author Quintin Harter
	 */
	public void updateHealth(double health) {
		this.health = Library.clamp(health, 0., maxHealth);
		game.update();
	}
	
	/**
	 * Sets the player's maximum health, then updates the health
	 * @param maxFood the new maximum health
	 * @author Quintin Harter
	 */
	public void updateMaxHealth(double maxHealth) {
		this.maxHealth = maxHealth;
		updateHealth(health);
		game.update();
	}
	
	/**
	 * Sets the player's home location as used by the compass
	 * @param home the player's new home
	 * @author Quintin Harter
	 */
	public void setHome(Vector home) {
		this.home = home;
		game.update();
	}
	
	/**
	 * Gets the player's home location as used by the compass
	 * @return the home vector
	 * @author Quintin Harter
	 */
	public Vector getHome() {
		return home;
	}
	
	/**
	 * Attempts to move with the strength potion. Decrements the int used to keep track of the potion.
	 * @return if the potion was successfully used.
	 */
	public boolean attemptToMoveStrength() {
		if (strengthMovesRemaining > 0) {
			strengthMovesRemaining--;
			return true;
		}
		return false;
	}
	
	/**
	 * Adds a number to the number of remaining strength moves.
	 * @param number the number to add
	 */
	public void addStrengthMoves(int number) {
		strengthMovesRemaining += number;
	}
	
	/**
	 * Adds the resource stack to the player's current resources.
	 * @param resources the resource stack to add.
	 */
	public void addResource(ResourceStack resources) {
		woodStack.add(resources);
		rockStack.add(resources);
		grassStack.add(resources);
		ironStack.add(resources);
		darkStack.add(resources);
	}
	
	/**
	 * Gets the resource stack owned by the player of the given type
	 * @param type the type of resource to get
	 * @return the resource stack of that type
	 */
	public ResourceStack getResource(int type) {
		switch(type) {
		case 0: return woodStack;
		case 1: return rockStack;
		case 2: return grassStack;
		case 3: return ironStack;
		case 4: return darkStack;
		default: return null;
		}
	}

	@Override
	public String toString() {
		return "Player Stats: WATER: " + water + " FOOD: " + food + " HEALTH: " + health; 
	}
	
}
