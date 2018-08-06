package game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import landmarks.Landmark;
import util.InventoryPanel;
import util.KillButton;
import util.MovementKeyListener;
import util.QGraphics;
import util.ResourcePanel;
import util.StatPanel;
import util.TimePanel;
import util.Vector;
import zones.Zone;

/**
 * The class that handles all of the user interface for QWorld
 * @author Quintin Harter
 */
public class UI {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel gridPanel;
	private JPanel inventoryPanel;
	private TimePanel timePanel;
	private StatPanel statPanel;
	private ResourcePanel resourcePanel;
	private PlayerStatManager player;

	private JLabel [] [] labelHolder;
	
	/**
	 * Default constructor
	 * @param player the player
	 * @author Quintin Harter
	 */
	public UI(PlayerStatManager player) {
		this.player = player;
	}
	
	/**
	 * Runs the user interface for the game
	 * @param game the game being played
	 * @author Quintin Harter
	 */
	public void run(Game game) {
		
		//create & register the font
		Font font;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/unifont-10.0.07.ttf").openStream());
		} catch (FontFormatException | IOException e) {
			Library.print("INVALID FONT FILE");
			font = Font.getFont("Arial");
		}
		GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
		graphics.registerFont(font);
		font = font.deriveFont(Library.FONT_SIZE);
		
		//instantiate the main JFrame
		frame = new JFrame("QWorld");
		frame.setSize(Library.FRAME_PIXEL_WIDTH, Library.FRAME_PIXEL_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		
		//instantiate the main JPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		
		//create and load default grid
		gridPanel = new JPanel();
		gridPanel.setBackground(Library.COLOR_SCHEME.getWorldBorderColor());
		gridPanel.setBorder(BorderFactory.createLineBorder(Library.COLOR_SCHEME.getWorldBorderColor(), 5, false));
		gridPanel.setPreferredSize(new Dimension(Library.WINDOW_SCREEN_PIXEL_WIDTH, Library.WINDOW_SCREEN_PIXEL_HEIGHT));
		gridPanel.setLayout(new GridLayout(Library.WINDOW_SCREEN_CHAR_WIDTH, Library.WINDOW_SCREEN_CHAR_HEIGHT, 0, 0));
		labelHolder = new JLabel[Library.WINDOW_SCREEN_CHAR_WIDTH][Library.WINDOW_SCREEN_CHAR_HEIGHT];
		for (int x = 0; x < Library.WINDOW_SCREEN_CHAR_WIDTH; x++)
			for (int y = 0; y < Library.WINDOW_SCREEN_CHAR_HEIGHT; y++) {
				labelHolder[y][x] = new JLabel("" + Library.LANDMARK_NULL, 0);
				labelHolder[y][x].setFont(font);
				labelHolder[y][x].setOpaque(true);
				labelHolder[y][x].setSize(Library.WINDOW_SCREEN_PIXEL_WIDTH / Library.WINDOW_SCREEN_CHAR_WIDTH, Library.WINDOW_SCREEN_PIXEL_HEIGHT / Library.WINDOW_SCREEN_CHAR_HEIGHT);
				gridPanel.add(labelHolder[y][x]);
			}
		
		//create and load inventory panel
		inventoryPanel = new InventoryPanel(player);
		
		//create and load time panel
		timePanel = new TimePanel(15 * 60);
		
		//create and load stat panel
		statPanel = new StatPanel(player);
		
		//create and load resource panel
		resourcePanel = new ResourcePanel(player);
		
		//create window & begin game
		mainPanel.add(gridPanel);
		JPanel subPanel = new JPanel(new BorderLayout());
		subPanel.add(new KillButton(frame, Library.COLOR_SCHEME, this), BorderLayout.NORTH);
		subPanel.add(timePanel, BorderLayout.CENTER);
		subPanel.add(inventoryPanel, BorderLayout.SOUTH);
		subPanel.setBackground(new Color(0, 0, 0, 0));
		mainPanel.add(subPanel);
		mainPanel.add(statPanel);
		mainPanel.add(resourcePanel);
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 4));
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.addKeyListener(new MovementKeyListener(game));
	}

	/**
	 * Redraws the user interface.
	 * @param world the world in the game
	 * @param zones the zones in the game
	 * @param pPos the player's current position
	 * @author Quintin Harter
	 */
	public void redrawScreen(Landmark[][] world, Zone [] [] zones, Vector pPos) {
		Library.print("Redrawing screen...");
		//redraw the screen to center the player
		//if the player is near the edge of the world, make the outside LANDMARK_NULL
		for (int x = 0; x < Library.WINDOW_SCREEN_CHAR_WIDTH; x++)
			for (int y = 0; y < Library.WINDOW_SCREEN_CHAR_HEIGHT; y++) {
				try {
					Color bcolor = world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getBackgroundColor();
					Color fcolor = world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getForegroundColor();
					if (world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getIcon() == null) {
						labelHolder[x][y].setIcon(null);
						labelHolder[x][y].setBackground((bcolor == null)? zones[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getGroundColor() : bcolor);
						labelHolder[x][y].setForeground((fcolor == null)? Color.BLACK : fcolor);
						labelHolder[x][y].setText("" + world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getChar());
					} else {
						ImageIcon base = world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getIcon();
						ImageIcon ground = zones[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getGroundLandmark().getIcon();
						if (ground != null)
							labelHolder[x][y].setIcon(QGraphics.overlay(base, ground));
						else
							labelHolder[x][y].setIcon(base);
						labelHolder[x][y].setText("");
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					labelHolder[x][y].setText("" + Library.LANDMARK_NULL);
					labelHolder[x][y].setBackground(Color.BLACK);
					labelHolder[x][y].setForeground(Color.BLACK);
				}
			}
		//draw the player
		//labelHolder[Library.WINDOW_SCREEN_CHAR_WIDTH / 2][Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].setText("" + Library.LANDMARK_PLAYER);
		ImageIcon ground = zones[pPos.getX()][pPos.getY()].getGroundLandmark().getIcon();
		if (ground != null) {
			labelHolder[Library.WINDOW_SCREEN_CHAR_WIDTH / 2][Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].setIcon(QGraphics.overlay(Library.LANDMARK_ICONS[2], ground));
		} else
			labelHolder[Library.WINDOW_SCREEN_CHAR_WIDTH / 2][Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].setIcon(Library.LANDMARK_ICONS[2]);
		labelHolder[Library.WINDOW_SCREEN_CHAR_WIDTH / 2][Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].setText("");
		//update stats
		statPanel.updatePanel();
		//update resources
		resourcePanel.redraw();
	}
	
	/**
	 * Sends the time to the time panel.
	 * @param time the time left in seconds
	 */
	public void sendTime(int time) {
		timePanel.setTime(time);
	}
	
	/**
	 * Exits the ui.
	 */
	public void exit() {
		frame.dispose();
	}
	
	/**
	 * Displays a dialogue box to tell the user something
	 * @param dialogue the string to display
	 * @param title the title of the box to display
	 */
	public void displayDialogue(String dialogue, String title) {
		JOptionPane.showMessageDialog(frame, dialogue, title, JOptionPane.OK_OPTION);
	}
	
	/**
	 * Displays a yes or no box to ask the user something
	 * @param message the message to display
	 * @param title the title of the box to display
	 * @return the response of the user
	 */
	public boolean displayYesNo(String message, String title) {
		return JOptionPane.showConfirmDialog(frame, message, title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
	}
}