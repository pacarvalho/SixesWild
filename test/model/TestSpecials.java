package model;

import junit.framework.TestCase;

/**
 * Test Special moves by imitating the mouse
 * 
 * @author OAkyildiz
 *
 */
public class TestSpecials extends TestCase {

	/** Game under test*/
	SixesWild model;
	/** Board used during test */
	Board board;
	
	/** Set up the game for testing */
	protected void setUp(){
		model = new PuzzleGame();
		board = new Board();
		board.update(); // populate the board
		model.initialize(board);
		
	}
	/** Tear down the model when done testing */
	protected void tearDown(){
		board = null; // memory deallocation will be handled by GC yes?
		model = null;
	}
	
	
	public void testReset() {
		// TODO Auto-generated method stub
		
	}
	public void testDestroy() {
		// TODO Auto-generated method stub
		
	}
	public void testSwap() {
		// TODO Auto-generated method stub
		
	}
}
