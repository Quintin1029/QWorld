package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Library;

/**
 * The panel used to display the remaining time in the world before the apocalypse
 * @author Quintin Harter
 *
 */
public class TimePanel extends JPanel {
	
	private int time;
	public JLabel label;
	
	/**
	 * Constructor
	 * @param time the current time in seconds
	 */
	public TimePanel(int time) {
		this.time = time;
		label = new JLabel("0:00");
		label.setFont(new Font("Helvetica", Font.BOLD, 30));
		label.setForeground(Color.RED);
		add(label);
		setBackground(Library.COLOR_SCHEME.getBackgroundColor());
		update();
	}
	
	/**
	 * updates the label (usually use setTime instead)
	 */
	public void update() {
		label.setText(time / 60 + ":" + ((time % 60 <= 9)? ("0" + time % 60) : (time % 60)));
	}
	
	/**
	 * Sets the time to the specified value and then updates the label
	 * @param time the new time
	 */
	public void setTime(int time) {
		this.time = time;
		update();
	}
	
}
