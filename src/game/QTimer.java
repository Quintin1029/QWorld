package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * The timer used in the world.
 * @author Quintin Harter
 *
 */
public class QTimer {

	private UI ui;
	private Timer timer;
	private int time;
	
	/**
	 * Constructor
	 * @param ui the ui to send the time to
	 * @param time the time to set the timer to
	 */
	public QTimer(UI ui, int time) {
		this.ui = ui;
		this.time = time;
		timer = new Timer(1000, new Listener());
	}
	
	/**
	 * Called when the timer is up (currently does nothing).
	 */
	public void onTimeUp() {
		//TODO
	}
	
	/**
	 * Gets the time left in the timer.
	 * @return the time left in seconds
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Starts the timer.
	 */
	public void start() {
		timer.start();
	}
	
	/**
	 * Pauses the timer.
	 */
	public void pause() {
		timer.stop();
	}
	
	/**
	 * Private action listener used by the timer.
	 * @author Quintin Harter
	 *
	 */
	private class Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (--time <= 0) {
				timer.stop();
				onTimeUp();
			} else {
				ui.sendTime(time);
			}
		}
		
	}
	
}
