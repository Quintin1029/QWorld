package util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Library;
import game.PlayerStatManager;
import game.UI;
import items.Item;

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
		
		setLayout(new FlowLayout());
		add(consumablesGridPanel);
		add(toolGridPanel);
		add(buildingGridPanel);
		setFocusable(false);
	}
	
	private class QButton extends JButton {
		public Item item;
		
		public QButton(Item item) {
			this.item = item;
			if (item != null)
				setIcon(item.getIcon());
			setFocusable(false);
			addMouseListener(new QButtonMouseListener());
		}
		
		public void use() {
			if (item != null)
				item.use();
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
