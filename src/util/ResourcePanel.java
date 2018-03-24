package util;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Library;
import game.PlayerStatManager;
import resources.ResourceStack;

/**
 * The JPanel that displays the resources in QWorld.
 * @author Quintin Harter
 *
 */
public class ResourcePanel extends JPanel {

	private PlayerStatManager player;
	private ResourceDisplayPanel panelWood;
	private ResourceDisplayPanel panelRock;
	private ResourceDisplayPanel panelGrass;
	private ResourceDisplayPanel panelIron;
	private ResourceDisplayPanel panelDark;
	
	private ResourceDisplayPanel woodPanel;
	
	/**
	 * Constructor.
	 * @param player the player to display the resources of
	 */
	public ResourcePanel(PlayerStatManager player) {
		this.player = player;
		setLayout(new FlowLayout());
		setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		panelWood = new ResourceDisplayPanel(ResourceStack.WOOD);
		panelRock = new ResourceDisplayPanel(ResourceStack.ROCK);
		panelGrass = new ResourceDisplayPanel(ResourceStack.GRASS);
		panelIron = new ResourceDisplayPanel(ResourceStack.IRON);
		panelDark = new ResourceDisplayPanel(ResourceStack.DARK);
		add(panelWood);
		add(panelRock);
		add(panelGrass);
		add(panelIron);
		add(panelDark);
		//add all resources: images and then text
		
	}
	
	/**
	 * Redraws the panel. Used in UI.js.
	 */
	public void redraw() {
		panelWood.redraw();
		panelRock.redraw();
		panelGrass.redraw();
		panelIron.redraw();
		panelDark.redraw();
	}
	
	/**
	 * A private class in ResourcePanel that represents an individual resource panel.
	 * @author Quintin Harter
	 *
	 */
	private class ResourceDisplayPanel extends JPanel{
		
		private JLabel numberLabel;
		private Icon icon;
		private int type;
		private String typeText;
		private int number;
		
		/**
		 * Constructor.
		 * @param type the type of resource to display (from ResourceStack.java)
		 */
		public ResourceDisplayPanel(int type) {
			numberLabel = new JLabel();
			numberLabel.setForeground(Library.COLOR_SCHEME.getTextColor());
			this.type = type;
			
			setLayout(new FlowLayout());
			setBackground(Library.COLOR_SCHEME.getBackgroundColor());
			
			switch(this.type) {
			case ResourceStack.WOOD: typeText = "Wood: "; break;
			case ResourceStack.ROCK: typeText = "Rock: "; break;
			case ResourceStack.GRASS: typeText = "Grass: "; break;
			case ResourceStack.IRON: typeText = "Iron: "; break;
			case ResourceStack.DARK: typeText = "Dark: "; break;
			default: typeText = "BADBADBAD ITEM: ";
			}
			
			try {
				icon = Library.RESOURCE_ICONS[player.getResource(type).getType()];
			} catch (ArrayIndexOutOfBoundsException e) {
				Library.print("ERROR: RESOURCE ICON DOES NOT EXIST");
				icon = null;
			}
			number = player.getResource(type).getNumber();
			
			JLabel iconLabel = new JLabel(icon);
			iconLabel.setForeground(Library.COLOR_SCHEME.getTextColor());
			add(iconLabel);
			add(numberLabel);
			redraw();
		}
		
		/**
		 * Redraws the individual resource panel.
		 */
		public void redraw() {
			number = player.getResource(type).getNumber();
			numberLabel.setText(typeText + number);
		}
		
	}
	
}
