package game;

import javax.swing.*;

import landmarks.Landmark;
import util.MovementKeyListener;
import util.StatPanel;
import util.Vector;
import zones.Zone;

import java.awt.*;
import java.io.IOException;

/**
 * The class that handles all of the user interface for QWorld
 * @author Quintin Harter
 */
public class UI {

	private JFrame frame;
	private JPanel mainPanel;
	private JPanel gridPanel;
	private JPanel inventoryPanel;
	private StatPanel statPanel;
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
		frame.setSize(500, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//instantiate the main JPanel
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		//create and load default grid
		gridPanel = new JPanel();
		gridPanel.setSize(new Dimension(Library.WINDOW_SCREEN_PIXEL_WIDTH, Library.WINDOW_SCREEN_PIXEL_HEIGHT));
		gridPanel.setLayout(new GridLayout(Library.WINDOW_SCREEN_CHAR_WIDTH, Library.WINDOW_SCREEN_CHAR_HEIGHT, 0, 0));
		labelHolder = new JLabel[Library.WINDOW_SCREEN_CHAR_WIDTH][Library.WINDOW_SCREEN_CHAR_HEIGHT];
		for (int x = 0; x < Library.WINDOW_SCREEN_CHAR_WIDTH; x++)
			for (int y = 0; y < Library.WINDOW_SCREEN_CHAR_HEIGHT; y++) {
				labelHolder[y][x] = new JLabel("" + Library.LANDMARK_NULL, 0);
				labelHolder[y][x].setFont(font);
				labelHolder[y][x].setOpaque(true);
				gridPanel.add(labelHolder[y][x]);
			}
		
		//create and load stat panel
		statPanel = new StatPanel(player);
		
		//create window & begin game
		mainPanel.add(gridPanel, BorderLayout.CENTER);
		mainPanel.add(statPanel, BorderLayout.SOUTH);
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
					labelHolder[x][y].setBackground(WorldGenerator.getZoneAtPosition(zones, new Vector(x, y)).getGroundColor());
					labelHolder[x][y].setText("" + world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getChar());
				} catch (ArrayIndexOutOfBoundsException e) {
					labelHolder[x][y].setText("" + Library.LANDMARK_NULL);
				}
			}
		//draw the player
		labelHolder[Library.WINDOW_SCREEN_CHAR_WIDTH / 2][Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].setText("" + Library.LANDMARK_PLAYER);
		
		//update stats
		statPanel.updatePanel();
	}
	
}
