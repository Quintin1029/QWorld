package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import game.Library;
import game.PlayerStatManager;

/**
 * The panel display for player statistics.
 * @author Quintin Harter
 *
 */
public class StatPanel extends JPanel {

	private JPanel topPanel;
	private JPanel bottomPanel;
	private JPanel middlePanel;
	private JPanel borderPanel;

	private JProgressBar barWater;
	private JProgressBar barFood;
	private JProgressBar barHealth;
	private JLabel labelWater;
	private JLabel labelFood;
	private JLabel labelHealth;
	private CompassPanel compass;

	private PlayerStatManager player;

	private double percentWater;
	private double percentFood;
	private double percentHealth;
	
	/**
	 * Constructor
	 * @param player the player to track
	 * @author Quintin Harter
	 */
	public StatPanel(PlayerStatManager player) {
		
		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new JPanel();
		topPanel.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		middlePanel.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		bottomPanel.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		
		this.player = player;
		
		percentWater = 1.;
		percentFood = 1.;
		percentHealth = 1.;
		
		barWater = new JProgressBar();
		barWater.setMaximum(100);
		barWater.setPreferredSize(new Dimension(Library.WINDOW_SCREEN_PIXEL_WIDTH / 2, Library.WINDOW_SCREEN_PIXEL_WIDTH * 2 / 3 / 15));
		barWater.setForeground(Color.BLUE);
		barFood = new JProgressBar();
		barFood.setMaximum(100);
		barFood.setPreferredSize(new Dimension(Library.WINDOW_SCREEN_PIXEL_WIDTH / 2, Library.WINDOW_SCREEN_PIXEL_WIDTH * 2 / 3 / 15));
		barFood.setForeground(Color.GREEN);
		barHealth = new JProgressBar();
		barHealth.setMaximum(100);
		barHealth.setPreferredSize(new Dimension(Library.WINDOW_SCREEN_PIXEL_WIDTH / 2, Library.WINDOW_SCREEN_PIXEL_WIDTH * 2 / 3 / 15));
		barHealth.setForeground(Color.RED);
		compass = new CompassPanel();
		
		labelWater = new JLabel((int)(percentWater * 100) + "%");
		labelWater.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		labelWater.setForeground(Library.COLOR_SCHEME.getTextColor());
		labelFood = new JLabel((int)(percentFood * 100) + "%");
		labelFood.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		labelFood.setForeground(Library.COLOR_SCHEME.getTextColor());
		labelHealth = new JLabel((int)(percentHealth * 100) + "%");
		labelHealth.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		labelHealth.setForeground(Library.COLOR_SCHEME.getTextColor());

		JLabel labelTextWater = new JLabel("Water: ");
		labelTextWater.setForeground(Library.COLOR_SCHEME.getTextColor());
		topPanel.add(labelTextWater);
		topPanel.add(barWater);
		topPanel.add(labelWater);
		JLabel labelTextFood = new JLabel("Food:   ");
		labelTextFood.setForeground(Library.COLOR_SCHEME.getTextColor());
		middlePanel.add(labelTextFood);
		middlePanel.add(barFood);
		middlePanel.add(labelFood);
		JLabel labelTextHealth = new JLabel("Health: ");
		labelTextHealth.setForeground(Library.COLOR_SCHEME.getTextColor());
		bottomPanel.add(labelTextHealth);
		bottomPanel.add(barHealth);
		bottomPanel.add(labelHealth);
		
		borderPanel = new JPanel();
		borderPanel.setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		borderPanel.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		
		borderPanel.add(topPanel, BorderLayout.NORTH);
		borderPanel.add(middlePanel, BorderLayout.CENTER);
		borderPanel.add(bottomPanel, BorderLayout.SOUTH);
		add(borderPanel, BorderLayout.WEST);
		add(compass, BorderLayout.CENTER);
		setPreferredSize(new Dimension(Library.WINDOW_SCREEN_PIXEL_WIDTH, Library.WINDOW_SCREEN_PIXEL_WIDTH * 7 / 6 / 8));
		
		updatePanel();
	}

	/**
	 * Updates the panel based on the player
	 * @author Quintin Harter
	 */
	public void updatePanel() {
		percentWater = player.getWater() / player.getMaxWater() * 100;
		percentFood = player.getFood() / player.getMaxFood() * 100;
		percentHealth = player.getHealth() / player.getMaxHealth() * 100;
		
		barWater.setValue((int) (percentWater));
		barFood.setValue((int) (percentFood));
		barHealth.setValue((int) (percentHealth));
		//compass.passAngle(angleHome);
		
		labelWater.setText((int)(percentWater) + "%");
		labelFood.setText((int)(percentFood) + "%");
		labelHealth.setText((int)(percentHealth) + "%");
		
		double dX = player.getPosition().getX() - player.getHome().getX();
		double dY = player.getPosition().getY() - player.getHome().getY();
		double angle = 180 / Math.PI * Math.atan2(dY, dX) - 90;
		Library.print("Angle: " + angle);
		if (dX == 0)
			compass.setAngle((dY <= 0)? 180 : 0);
		else
			compass.setAngle(angle);
	}
}
