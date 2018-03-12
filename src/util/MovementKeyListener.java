package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;

/**
 * The key listener for movement. Maps the W, A, S, and D keys to moving.
 * @author Quintin Harter
 *
 */
public class MovementKeyListener  implements KeyListener{
	
	private Game game;
	
	/**
	 * Constructor
	 * @param game the game to run the key listener in
	 */
	public MovementKeyListener(Game game) {
		this.game = game;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//move the player
		if (e.getKeyChar() == 'w')
			game.attemptMove(Vector.VECTOR_UP);
		else if (e.getKeyChar() == 'd')
			game.attemptMove(Vector.VECTOR_RIGHT);
		else if (e.getKeyChar() == 's')
			game.attemptMove(Vector.VECTOR_DOWN);
		else if (e.getKeyChar() == 'a')
			game.attemptMove(Vector.VECTOR_LEFT);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		//do nothing
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing
	}

}
