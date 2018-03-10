package util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;

public class MovementKeyListener  implements KeyListener{
	
	private Game game;
	
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
