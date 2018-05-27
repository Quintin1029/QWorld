package util;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Library;
import game.PlayerStatManager;
import resources.Resource;

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
		
	/**
	 * Constructor.
	 * @param player the player to display the resources of
	 */
	public ResourcePanel(PlayerStatManager player) {
		this.player = player;
		setLayout(new FlowLayout());
		setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		panelWood = new ResourceDisplayPanel(Resource.WOOD);
		panelRock = new ResourceDisplayPanel(Resource.ROCK);
		panelGrass = new ResourceDisplayPanel(Resource.GRASS);
		panelIron = new ResourceDisplayPanel(Resource.IRON);
		panelDark = new ResourceDisplayPanel(Resource.DARK);
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
		private Resource type;
		private String typeText;
		private int number;
		
		/**
		 * Constructor.
		 * @param type the type of resource to display (from ResourceStack.java)
		 */
		public ResourceDisplayPanel(Resource type) {
			numberLabel = new JLabel();
			numberLabel.setForeground(Library.COLOR_SCHEME.getTextColor());
			this.type = type;
			
			setLayout(new FlowLayout());
			setBackground(Library.COLOR_SCHEME.getBackgroundColor());
			
			switch(this.type) {
			case WOOD: typeText = "Wood: "; break;
			case ROCK: typeText = "Rock: "; break;
			case GRASS: typeText = "Grass: "; break;
			case IRON: typeText = "Iron: "; break;
			case DARK: typeText = "Dark: "; break;
			default: typeText = "BADBADBAD ITEM: ";
			}
			
			try {
				icon = getIcon();
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
		
		/**
		 * Gets the icon that corresponds with this panel.
		 * @return the icon that corresponds with this resource.
		 */
		public ImageIcon getIcon() {
			switch(type) {
			case WOOD: return Library.RESOURCE_ICONS[0];  
			case ROCK: return Library.RESOURCE_ICONS[1];
		    case GRASS: return Library.RESOURCE_ICONS[2];
		    case IRON: return Library.RESOURCE_ICONS[3];
	        case DARK: return Library.RESOURCE_ICONS[4]; 
	        case CLOUD: return Library.RESOURCE_ICONS[5];
			}
			return null;
		}
	}
}
