package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;

/**
 * The key listener for movement. Maps the W, A, S, and D keys to moving.
 * 
 * @author Quintin Harter
 *
 */
public class MovementKeyListener implements KeyListener {

	private Game game;
	private char justPressed = '~';
	private boolean released = true;

	/**
	 * Constructor
	 * 
	 * @param game
	 *            the game to run the key listener in
	 */
	public MovementKeyListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// move the player
		if (released || justPressed != e.getKeyChar()) {
			released = false;
			justPressed = e.getKeyChar();
			if (justPressed == 'w')
				game.attemptMove(Vector.VECTOR_UP);
			else if (justPressed == 'd')
				game.attemptMove(Vector.VECTOR_RIGHT);
			else if (justPressed == 's')
				game.attemptMove(Vector.VECTOR_DOWN);
			else if (justPressed == 'a')
				game.attemptMove(Vector.VECTOR_LEFT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		released = true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// do nothing
	}

}
