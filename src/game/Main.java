package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * The main class of QWorld. Uses {@code game.run();}
 * 
 * @author Quintin Harter
 *
 */
public class Main {

	/**
	 * Runs the game.
	 * 
	 * @author Quintin Harter
	 */
	public static void main(String[] args) {
		if (Library.DEBUG_FILE) { //false unless debugging
			try {
				System.setOut(new PrintStream(new File("debuglog.txt")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		Game game = new Game();	
	}

}
