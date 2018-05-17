package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import util.TimePanel;

public class QTimer {

	private UI ui;
	private Timer timer;
	private int time;
	
	public QTimer(UI ui, int time) {
		this.ui = ui;
		this.time = time;
		timer = new Timer(1000, new Listener());
	}
	
	public void onTimeUp() {
		//TODO
	}
	
	public int getTime() {
		return time;
	}
	
	public void start() {
		timer.start();
	}
	
	public void pause() {
		timer.stop();
	}
	
	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Library.print("Test");
			if (--time <= 0) {
				timer.stop();
				onTimeUp();
			} else {
				ui.sendTime(time);
			}
		}
		
	}
	
}
