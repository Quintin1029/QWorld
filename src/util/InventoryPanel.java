package util;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import game.Library;
import game.PlayerStatManager;
import items.Item;

/**
 * The inventory display panel on the screen.
 * @author Quintin Harter
 *
 */
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
	private JPanel toolGridPanel;
	private JButton [] toolButtons;
	private JPanel buildingGridPanel;
	private JButton [] buildingButtons;
	
	/**
	 * Constructor.
	 * @param player the player to display the inventory of
	 */
	public InventoryPanel(PlayerStatManager player) {
		this.player = player;
		consumableButtons = new JButton[Library.CARRYING_CAPACITY];
		consumablesGridPanel = new JPanel();
		consumablesGridPanel.setLayout(new GridLayout((int) Math.ceil(Library.CARRYING_CAPACITY * 1. / WIDTH), WIDTH));
		for (int b = 0; b < Library.CARRYING_CAPACITY; b++) {
			consumableButtons[b] = new QButton(player.getConsumables()[b]);
			consumablesGridPanel.add(consumableButtons[b]);
		}
		
		toolButtons = new JButton[Library.CARRYING_CAPACITY];
		toolGridPanel = new JPanel();
		toolGridPanel.setLayout(new GridLayout((int) Math.ceil(Library.CARRYING_CAPACITY * 1. / WIDTH), WIDTH));
		for (int b = 0; b < Library.CARRYING_CAPACITY; b++) {
			toolButtons[b] = new QButton(player.getTools()[b]);
			toolGridPanel.add(toolButtons[b]);
		}
		
		buildingButtons = new JButton[Library.CARRYING_CAPACITY];
		buildingGridPanel = new JPanel();
		buildingGridPanel.setLayout(new GridLayout((int) Math.ceil(Library.CARRYING_CAPACITY * 1. / WIDTH), WIDTH));
		for (int b = 0; b < Library.CARRYING_CAPACITY; b++) {
			buildingButtons[b] = new QButton(player.getBuildings()[b]);
			buildingGridPanel.add(buildingButtons[b]);
		}
		
		setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		setLayout(new FlowLayout());
		add(consumablesGridPanel);
		add(toolGridPanel);
		add(buildingGridPanel);
		setFocusable(false);
	}
	
	/**
	 * A private class in InventoryPanel that handle the buttons used for the items.
	 * @author Quintin Harter
	 *
	 */
	private class QButton extends JButton {
		public Item item;
		
		/**
		 * Constructor.
		 * @param item the item to store in this QButton
		 */
		public QButton(Item item) {
			this.item = item;
			if (item != null)
				setIcon(item.getIcon());
			setFocusable(false);
			addMouseListener(new QButtonMouseListener());
			setBorder(BorderFactory.createLineBorder(Library.COLOR_SCHEME.getButtonBorderColor()));
			setBackground(Library.COLOR_SCHEME.getButtonColor());
		}
		
		/**
		 * Uses the item stored by the button (if the item is not null)
		 */
		public void use() {
			if (item != null)
				item.use();
		}
	}
	
	/**
	 * A private class in InventoryPanel that is used by QButton to handle clicks. DO NOT ATTACH TO ANYTHING OTHER THAN A QBUTTON!!!
	 * @author Quintin Harter
	 *
	 */
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
