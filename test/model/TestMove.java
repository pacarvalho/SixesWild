package model;

import java.util.ArrayList;

import junit.framework.TestCase;


/**
 * Test Cases for the move class
 * 
 * 
 * @author Sean, OAkyildiz
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
		
		// Check a valid move
		board.tiles[1][1].setMultiplier(2);
		
		ArrayList<Tile> validMoveTiles = new ArrayList<Tile>();
		validMoveTiles.add(board.tiles[1][1]);
		validMoveTiles.add(board.tiles[1][2]);
		validMoveTiles.add(board.tiles[1][3]);
		
		
		Move validMove = new Move(validMoveTiles,model);
		validMove.doMove();
		assertEquals(validMove.valid(),true);
		assertEquals(model.currentScore,60);
		
		// Reset the value of the moved tiles
		board.tiles[1][1].setValue(2);
		board.tiles[1][2].setValue(2);
		board.tiles[1][3].setValue(2);
		
		// Check a diagonal move
		ArrayList<Tile> diagonalMoveTiles1 = new ArrayList<Tile>();
		diagonalMoveTiles1.add(board.tiles[1][1]);
		diagonalMoveTiles1.add(board.tiles[1][2]);
		diagonalMoveTiles1.add(board.tiles[2][3]);
		
		Move diagonalMove1 = new Move(diagonalMoveTiles1,model);
		assertEquals(diagonalMove1.valid(),false);
		
		ArrayList<Tile> diagonalMoveTiles2 = new ArrayList<Tile>();
		diagonalMoveTiles2.add(board.tiles[2][1]);
		diagonalMoveTiles2.add(board.tiles[2][2]);
		diagonalMoveTiles2.add(board.tiles[1][1]);
		
		Move diagonalMove2 = new Move(diagonalMoveTiles2,model);
		assertEquals(diagonalMove2.valid(),false);
		
		// Check a move with too small a score
		ArrayList<Tile> smallMoveTiles = new ArrayList<Tile>();
		smallMoveTiles.add(board.tiles[2][1]);
		smallMoveTiles.add(board.tiles[2][2]);

		
		Move smallMove = new Move(smallMoveTiles,model);
		assertEquals(smallMove.valid(),false);

		// Check a move with too large a score
		ArrayList<Tile> largeMoveTiles = new ArrayList<Tile>();
		largeMoveTiles.add(board.tiles[2][1]);
		largeMoveTiles.add(board.tiles[2][2]);
		largeMoveTiles.add(board.tiles[1][2]);
		largeMoveTiles.add(board.tiles[2][3]);

		Move largeMove = new Move(largeMoveTiles,model);
		assertEquals(largeMove.valid(),false);
		
		// Check a move which includes a six
		board.tiles[2][1].setValue(6);
		ArrayList<Tile> sixMoveTiles = new ArrayList<Tile>();
		sixMoveTiles.add(board.tiles[2][1]);
		sixMoveTiles.add(board.tiles[2][2]);
		sixMoveTiles.add(board.tiles[1][2]);

		Move sixMove = new Move(sixMoveTiles,model);
		assertEquals(sixMove.valid(),false);	
	}

	/** Method to test the elimination move class*/
	public void testElimMoves(){
		// set the value of all tiles to 2 and check
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				board.tiles[i][j].setValue(2);
				assertEquals(board.tiles[i][j].getValue(),2);
			}
		}
		
		// Check a valid move
		ArrayList<Tile> validMoveTiles = new ArrayList<Tile>();
		validMoveTiles.add(board.tiles[1][1]);
		validMoveTiles.add(board.tiles[1][2]);
		validMoveTiles.add(board.tiles[1][3]);
		
		EliminationMove validMove = new EliminationMove(validMoveTiles,model);
		assertEquals(validMove.valid(),true);
		
		// Check a diagonal move
		ArrayList<Tile> diagonalMoveTiles1 = new ArrayList<Tile>();
		diagonalMoveTiles1.add(board.tiles[1][1]);
		diagonalMoveTiles1.add(board.tiles[1][2]);
		diagonalMoveTiles1.add(board.tiles[2][3]);
		
		EliminationMove diagonalMove1 = new EliminationMove(diagonalMoveTiles1,model);
		assertEquals(diagonalMove1.valid(),false);
		
		ArrayList<Tile> diagonalMoveTiles2 = new ArrayList<Tile>();
		diagonalMoveTiles2.add(board.tiles[2][1]);
		diagonalMoveTiles2.add(board.tiles[2][2]);
		diagonalMoveTiles2.add(board.tiles[1][1]);
		
		EliminationMove diagonalMove2 = new EliminationMove(diagonalMoveTiles2,model);
		assertEquals(diagonalMove2.valid(),false);
		
		// Check a move with too small a score
		ArrayList<Tile> smallMoveTiles = new ArrayList<Tile>();
		smallMoveTiles.add(board.tiles[2][1]);
		smallMoveTiles.add(board.tiles[2][2]);

		
		EliminationMove smallMove = new EliminationMove(smallMoveTiles,model);
		assertEquals(smallMove.valid(),false);

		// Check a move with too large a score
		ArrayList<Tile> largeMoveTiles = new ArrayList<Tile>();
		largeMoveTiles.add(board.tiles[2][1]);
		largeMoveTiles.add(board.tiles[2][2]);
		largeMoveTiles.add(board.tiles[1][2]);
		largeMoveTiles.add(board.tiles[2][3]);

		EliminationMove largeMove = new EliminationMove(largeMoveTiles,model);
		assertEquals(largeMove.valid(),false);
		
		// Check a move which includes a six
		board.tiles[2][1].setValue(6);
		ArrayList<Tile> sixMoveTiles = new ArrayList<Tile>();
		sixMoveTiles.add(board.tiles[2][1]);
		sixMoveTiles.add(board.tiles[2][2]);
		sixMoveTiles.add(board.tiles[1][2]);

		EliminationMove sixMove = new EliminationMove(sixMoveTiles,model);
		assertEquals(sixMove.valid(),false);	
	}
}
