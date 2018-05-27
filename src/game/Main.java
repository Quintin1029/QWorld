package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * The main method of QWorld. Uses {@code game.run();}
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
		if (Library.DEBUG_FILE) {
			try {
				System.setOut(new PrintStream(new File("debuglog.txt")));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		Game game = new Game();
		
		
		//Line l1 = new Line(new Vector(0, 0), new Vector(1, 1));
		//Line l2 = new Line(new Vector(0, 0), new Vector(1, 2));
		//Library.print("" + Vector.lineSegmentsIntersect(new Vector(0, 0), new Vector(3, 0), new Vector(1, -1), new Vector(2, 3)));
		
		
		
		//RangeGenerator rg = new RangeGenerator(20, 30, 5, 10, 5);		
		
		
	}

}
