package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import colorschemes.ColorScheme;
import game.UI;

public class KillButton extends JButton {

	public KillButton(JFrame frameToKill, ColorScheme cs, UI ui) {
		setSize(50, 50);
		setBackground(cs.getButtonColor());
		setForeground(cs.getTextColor());
		setFocusable(false);
		setText("Quit");
		addActionListener(new Listener(frameToKill, ui));
	}
	
	private class Listener implements ActionListener {
		
		private JFrame frameToKill;
		private UI ui;
		
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
