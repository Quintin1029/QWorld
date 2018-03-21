package items;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import game.Library;
import game.PlayerStatManager;
import game.UI;

public class InventoryPanel extends JPanel {

	public static final int WIDTH = 1;
	
	public static final int INDEX_WATER_BOTTLE = 0;
	public static final int INDEX_LUNCH_BOX = 1;
	public static final int INDEX_MED_KIT = 2;
	public static final int INDEX_POTION_OF_SPEED = 3;
	public static final int INDEX_TELEPORTER = 4;
	
	private PlayerStatManager player;
	private JPanel consumablesGridPanel;
	private JButton [] consumableButtons;
	private JPanel weaponGridPanel;
	private JButton [] weaponButtons;
	private JPanel armorGridPanel;
	private JButton [] armorButtons;
	
	public InventoryPanel(PlayerStatManager player) {
		this.player = player;
		consumableButtons = new JButton[Library.CARRYING_CAPACITY];
		consumablesGridPanel = new JPanel();
		consumablesGridPanel.setLayout(new GridLayout((int) Math.ceil(Library.CARRYING_CAPACITY * 1. / WIDTH), WIDTH));
		for (int b = 0; b < Library.CARRYING_CAPACITY; b++) {
			consumableButtons[b] = new QConsumableButton(b);
			consumablesGridPanel.add(consumableButtons[b]);
		}
		
		weaponButtons = new JButton[Library.CARRYING_CAPACITY];
		weaponGridPanel = new JPanel();
		weaponGridPanel.setLayout(new GridLayout((int) Math.ceil(Library.CARRYING_CAPACITY * 1. / WIDTH), WIDTH));
		for (int b = 0; b < Library.CARRYING_CAPACITY; b++) {
			weaponButtons[b] = new QWeaponButton(b);
			weaponGridPanel.add(weaponButtons[b]);
		}
		
		armorButtons = new JButton[Library.CARRYING_CAPACITY];
		armorGridPanel = new JPanel();
		armorGridPanel.setLayout(new GridLayout((int) Math.ceil(Library.CARRYING_CAPACITY * 1. / WIDTH), WIDTH));
		for (int b = 0; b < Library.CARRYING_CAPACITY; b++) {
			armorButtons[b] = new QArmorButton(b);
			armorGridPanel.add(armorButtons[b]);
		}
		
		setLayout(new FlowLayout());
		add(consumablesGridPanel);
		add(weaponGridPanel);
		add(armorGridPanel);
		setFocusable(false);
	}
	
	private interface QButton {
		public void use();
	}
	
	private class QConsumableButton extends JButton implements QButton {
		
		private int type;
		
		public QConsumableButton(int type) {
			this.type = type;
			addMouseListener(new QButtonMouseListener());
			setMargin(new Insets(0, 0, 0, 0));
			//IMPORTANT!!! Movement Key Listener will not function without setting focusable to false
			setFocusable(false);
			try {
				setIcon(Library.ITEM_CONSUMABLE_ICONS[type]);
				Library.print("Loaded icon for button type " + type);
			} catch (ArrayIndexOutOfBoundsException e) {
				Library.print("ERROR: IMAGE ICON DOES NOT EXIST");
			}
		}
		
		public void use() {
			switch(type) {
			case INDEX_WATER_BOTTLE: player.useWaterBottle(); return;
			case INDEX_LUNCH_BOX: player.useLunchBox(); return;
			case INDEX_MED_KIT: player.useMedKit(); return;
			case INDEX_POTION_OF_SPEED: player.usePotionOfSpeed(); return;
			case INDEX_TELEPORTER: player.useTeleporter(); return;
			}
			player.getGame().update();
		}
	}
	
	
	
	private class QWeaponButton extends JButton implements QButton {
		
		private int type;
		
		public QWeaponButton(int type) {
			this.type = type;
			addMouseListener(new QButtonMouseListener());
			setMargin(new Insets(0, 0, 0, 0));
			//IMPORTANT!!! Movement Key Listener will not function without setting focusable to false
			setFocusable(false);
			try {
				setIcon(Library.ITEM_WEAPON_ICONS[type]);
				Library.print("Loaded icon for button type " + type);
			} catch (ArrayIndexOutOfBoundsException e) {
				Library.print("ERROR: IMAGE ICON DOES NOT EXIST");
			}
		}
		
		public void use() {
			//equip and dequip here
			
		}
		
	}
	
private class QArmorButton extends JButton implements QButton {
		
		private int type;
		
		public QArmorButton(int type) {
			this.type = type;
			addMouseListener(new QButtonMouseListener());
			setMargin(new Insets(0, 0, 0, 0));
			//IMPORTANT!!! Movement Key Listener will not function without setting focusable to false
			setFocusable(false);
			try {
				setIcon(Library.ITEM_ARMOR_ICONS[type]);
				Library.print("Loaded icon for button type " + type);
			} catch (ArrayIndexOutOfBoundsException e) {
				Library.print("ERROR: IMAGE ICON DOES NOT EXIST");
			}
		}
		
		public void use() {
			//equip and dequip here
			
		}
		
	}
	
	private class QButtonMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			((QButton)e.getSource()).use();
		}
		//unused
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		
	}
	
}
