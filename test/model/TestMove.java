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
	
	/** Method to test the move class*/
	public void testMoves(){
		// set the value of all tiles to 2 and check
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				board.tiles[i][j].setValue(2);
				assertEquals(board.tiles[i][j].getValue(),2);
			}
		}
		
		ArrayList<Tile> validMoveTiles = new ArrayList<Tile>();
		validMoveTiles.add(board.tiles[1][1]);
		validMoveTiles.add(board.tiles[1][2]);
		validMoveTiles.add(board.tiles[1][3]);
		
		Move validMove = new Move(validMoveTiles,model);
		assertEquals(validMove.valid(),true);
		// TODO Add content to test case
	}

}
