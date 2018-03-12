package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import game.Library;
import game.PlayerStatManager;

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
	private double angleHome;
	
	public StatPanel(PlayerStatManager player) {
		
		topPanel = new JPanel();
		middlePanel = new JPanel();
		bottomPanel = new JPanel();
		
		this.player = player;
		
		percentWater = 1.;
		percentFood = 1.;
		percentHealth = 1.;
		angleHome = 0.;
		
		barWater = new JProgressBar();
		barWater.setMaximum(100);
		barWater.setForeground(Color.BLUE);
		barFood = new JProgressBar();
		barFood.setMaximum(100);
		barFood.setForeground(Color.GREEN);
		barHealth = new JProgressBar();
		barHealth.setMaximum(100);
		barHealth.setForeground(Color.RED);
		compass = new CompassPanel();
		
		labelWater = new JLabel((int)(percentWater * 100) + "%");
		labelFood = new JLabel((int)(percentFood * 100) + "%");
		labelHealth = new JLabel((int)(percentHealth * 100) + "%");

		topPanel.add(new JLabel("Water: "));
		topPanel.add(barWater);
		topPanel.add(labelWater);
		middlePanel.add(new JLabel("Food:   "));
		middlePanel.add(barFood);
		middlePanel.add(labelFood);
		bottomPanel.add(new JLabel("Health: "));
		bottomPanel.add(barHealth);
		bottomPanel.add(labelHealth);
		
		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());
		
		setLayout(new BorderLayout());
		
		borderPanel.add(topPanel, BorderLayout.NORTH);
		borderPanel.add(middlePanel, BorderLayout.CENTER);
		borderPanel.add(bottomPanel, BorderLayout.SOUTH);
		add(borderPanel, BorderLayout.WEST);
		add(compass, BorderLayout.CENTER);
		
		updatePanel();
	}

	
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
		double angle = 180 / Math.PI * Math.atan2(dY, dX) + 90;
		Library.print("Angle: " + angle);
		if (dX == 0)
			compass.setAngle((dY <= 0)? 0. : 180.);
		else
			compass.setAngle(angle);
	}
}
