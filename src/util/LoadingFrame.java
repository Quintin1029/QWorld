package util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import game.Library;

/**
 * The class used for the JFrame created while generating the world
 * @author Quintin Harter
 *
 */
public class LoadingFrame extends JFrame {

	private JProgressBar mainBar;
	private JProgressBar subBar;
	private JLabel mainLabel;
	private JLabel subLabel;
	
	public LoadingFrame() {
		mainBar = new JProgressBar(0, 100);
		mainBar.setForeground(Color.RED);
		mainBar.setPreferredSize(new Dimension(Library.WINDOW_LOADING_WIDTH * 2 / 3, Library.WINDOW_LOADING_HEIGHT / 5));
		subBar = new JProgressBar(0, 100);
		subBar.setForeground(Color.RED);
		subBar.setPreferredSize(new Dimension(Library.WINDOW_LOADING_WIDTH * 2 / 3, Library.WINDOW_LOADING_HEIGHT / 5));
		mainLabel = new JLabel("Building game...");
		mainLabel.setForeground(Color.GREEN);
		mainLabel.setFont(new Font("Arial", Font.PLAIN, Library.LOADING_FONT_SIZE));
		subLabel = new JLabel("Building game...");
		subLabel.setForeground(Color.GREEN);
		subLabel.setFont(new Font("Arial", Font.PLAIN, Library.LOADING_FONT_SIZE));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		p1.add(mainBar);
		p1.add(mainLabel);
		p1.add(subBar);
		p1.add(subLabel);
		p1.setBackground(Color.DARK_GRAY);
		p1.setBorder(BorderFactory.createLineBorder(Color.GRAY, Library.BORDER_SIZE));
		
		add(p1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Library.WINDOW_LOADING_WIDTH, Library.WINDOW_LOADING_HEIGHT);
		setLocationRelativeTo(null);
		setResizable(false);
		setUndecorated(true);
		setVisible(true);
	}
	
	/**
	 * Updates the main bar and text
	 * @param percent the new percent to display on the bar
	 * @param text the new text to display below the bar
	 */
	public void updateLoaderMainBar(double percent, String text) {
		mainBar.setValue((int) percent);
		mainLabel.setText(text);
	}
	
	/**
	 * Updates the secondary bar and text
	 * @param percent the percent to display on the bar
	 * @param text the new text to display below the bar
	 */
	public void updateLoaderSubBar(double percent, String text) {
		subBar.setValue((int) percent);
		subLabel.setText(text);
	}
	
	/**
	 * Destroys this JFrame (Releases all memory back to the CPU)
	 */
	public void kill() {
		setVisible(false);
	}
	
}
