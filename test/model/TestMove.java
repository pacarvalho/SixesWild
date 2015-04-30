package model;

import java.util.ArrayList;

import junit.framework.TestCase;


/**
 * Test Cases for the move class
 * 
 * 
 * @author Sean
 *
 */

public class TestMove extends TestCase{
	
	/** Game under test*/
	SixesWild model;
	/** Set up the game for testing */
	protected void setUp(){
		model = new PuzzleGame();
	}
	/** Tear down the model when done testing */
	protected void tearDown(){
		model = null;
	}
	
	public void testMoves(){
		ArrayList<Tile> tilesToMove;
		// TODO Add content to test case
	}

}
