package util;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import colorschemes.ColorScheme;
import game.Library;
import game.UI;

/**
 * The button that ends the program on click
 * @author Quintin Harter
 *
 */
public class KillButton extends JButton {

	/**
	 * Constructor
	 * @param frameToKill the JFrame to close when the button is clicked
	 * @param cs the color scheme (for aesthetics)
	 * @param ui the UI (for displaying the 'are you sure you want to quit' question)
	 */
	public KillButton(JFrame frameToKill, ColorScheme cs, UI ui) {
		setPreferredSize(new Dimension(Library.QBUTTON_HEIGHT_AND_WIDTH * 3, Library.WINDOW_SCREEN_PIXEL_HEIGHT / 7));
		setBackground(cs.getButtonColor());
		setForeground(cs.getTextColor());
		setFocusable(false);
		setText("Quit");
		addActionListener(new Listener(frameToKill, ui));
	}
	
	/**
	 * The private action listener class for KillButton
	 * @author Quintin Harter
	 *
	 */
	private class Listener implements ActionListener {
		
		private JFrame frameToKill;
		private UI ui;
		
		/**
		 * Constructor
		 * @param frameToKill the JFrame to kill
		 * @param ui the ui
		 */
		public Listener(JFrame frameToKill, UI ui) {
			this.frameToKill = frameToKill;
			this.ui = ui;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ui.displayYesNo("Are you sure you want to quit?", "Quit?")) {
				frameToKill.dispose();
				System.exit(0);
			}
		}
		
	}
	
}
