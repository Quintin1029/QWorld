package util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class LoadingFrame extends JFrame {

	private JProgressBar mainBar;
	private JProgressBar subBar;
	private JLabel mainLabel;
	private JLabel subLabel;
	
	public LoadingFrame() {
		mainBar = new JProgressBar(0, 100);
		mainBar.setForeground(Color.RED);
		subBar = new JProgressBar(0, 100);
		subBar.setForeground(Color.RED);
		mainLabel = new JLabel("Building game...");
		mainLabel.setForeground(Color.GREEN);
		subLabel = new JLabel("Building game...");
		subLabel.setForeground(Color.GREEN);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		
		p1.add(mainBar);
		p1.add(mainLabel);
		p1.add(subBar);
		p1.add(subLabel);
		p1.setBackground(Color.DARK_GRAY);
		
		add(p1);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(275, 150);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void updateLoaderMainBar(double percent, String text) {
		mainBar.setValue((int) percent);
		mainLabel.setText(text);
	}
	
	public void updateLoaderSubBar(double percent, String text) {
		subBar.setValue((int) percent);
		subLabel.setText(text);
	}
	
	public void kill() {
		setVisible(false);
	}
	
}
