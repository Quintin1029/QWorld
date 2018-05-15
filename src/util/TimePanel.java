package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePanel extends JPanel {
	
	private int time;
	public JLabel label;
	
	public TimePanel(int time) {
		this.time = time;
		label = new JLabel("0:00");
		label.setFont(new Font("Helvetica", Font.BOLD, 30));
		label.setForeground(Color.RED);
		add(label);
		setBackground(new Color(0, 0, 0, 0));
		update();
	}
	
	public void update() {
		label.setText(time / 60 + ":" + time % 60);
	}
	
	public void setTime(int time) {
		this.time = time;
		update();
	}
	
}
