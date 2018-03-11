package game;

import javax.swing.*;

import landmarks.Landmark;
import util.MovementKeyListener;
import util.Vector;

import java.awt.*;
import java.io.IOException;

public class UI {

	JFrame frame;
	JPanel mainPanel;
	JPanel gridPanel;
	JPanel inventoryPanel;
	JPanel statPanel;
	
	JLabel [] [] labelHolder;
	
	public void run(Game game) {
		
		//create the font
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
		
		frame = new JFrame("QWorld");
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(Library.WINDOW_SCREEN_CHAR_WIDTH, Library.WINDOW_SCREEN_CHAR_HEIGHT, 0, 0));
		labelHolder = new JLabel[Library.WINDOW_SCREEN_CHAR_WIDTH][Library.WINDOW_SCREEN_CHAR_HEIGHT];
		for (int x = 0; x < Library.WINDOW_SCREEN_CHAR_WIDTH; x++)
			for (int y = 0; y < Library.WINDOW_SCREEN_CHAR_HEIGHT; y++) {
				labelHolder[y][x] = new JLabel("" + Library.LANDMARK_NULL, 0);
				labelHolder[y][x].setFont(font);
				gridPanel.add(labelHolder[y][x]);
			}
		
		mainPanel.add(gridPanel, BorderLayout.CENTER);
		frame.add(mainPanel);
		frame.setVisible(true);
		frame.addKeyListener(new MovementKeyListener(game));
	}

	public void redrawScreen(Landmark[][] world, Vector pPos) {
		Library.print("Redrawing screen...");
		//redraw the screen to center the player
		//if the player is near the edge of the world, make the outside LANDMARK_NULL
		for (int x = 0; x < Library.WINDOW_SCREEN_CHAR_WIDTH; x++)
			for (int y = 0; y < Library.WINDOW_SCREEN_CHAR_HEIGHT; y++) {
				try {
					//labelHolder[x][y].setText("\u007D");
					//labelHolder[x][y].setIcon(new ImageIcon("src/icons/Ground.bmp"));
					labelHolder[x][y].setText("" + world[x + pPos.getX() - Library.WINDOW_SCREEN_CHAR_WIDTH / 2][y + pPos.getY() - Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].getChar());
				} catch (ArrayIndexOutOfBoundsException e) {
					labelHolder[x][y].setText("" + Library.LANDMARK_NULL);
				}
			}
		//draw the player
		labelHolder[Library.WINDOW_SCREEN_CHAR_WIDTH / 2][Library.WINDOW_SCREEN_CHAR_HEIGHT / 2].setText("" + Library.LANDMARK_PLAYER);
	}
	
}
