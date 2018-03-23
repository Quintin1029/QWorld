package items;

import javax.swing.Icon;

import game.PlayerStatManager;

public abstract class Item {

	protected PlayerStatManager player;
	protected boolean unlocked;
	
	public Item(PlayerStatManager player) {
		this.player = player;
		unlocked = false;
	}
	
	public abstract Icon getIcon();
	
	public abstract void use();
	
	public void unlock() {
		unlocked = true;
	}
	
	public boolean getIsUnlocked() {
		return unlocked;
	}
	
}
