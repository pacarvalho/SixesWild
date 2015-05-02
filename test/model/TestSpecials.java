package model;

import junit.framework.TestCase;

public class TestSpecials extends TestCase {

	/** Game under test*/
	SixesWild model;
	/** Board used during test */
	Board board;
	
	/** Set up the game for testing */
	protected void setUp(){
		model = new LightningGame();
		board = new Board();
		board.update(); // populate the board
		model.initialize(board);
		
	}
	/** Tear down the model when done testing */
	protected void tearDown(){
		board = null; // memory deallocation will be handled by GC yes?
		model = null;
	}
	/**
	 * Special Move Tests 
	 */
	public void testSwap(){
		Tile tile1 = board.tiles[1][3];
		Tile tile2 = board.tiles[2][4];
		
		int value1 = tile1.getValue();
		int value2 = tile2.getValue();
		
		SwapSpecialMove validSwapMove = new SwapSpecialMove(tile1, tile2, model);
		assertTrue(validSwapMove.valid());	
		
		validSwapMove.doMove();
		//assert values swapped
		assertEquals(tile1.getValue(),value2);
		assertEquals(tile2.getValue(),value1);
		//locations are the same
		assertEquals(tile1.getColumn(),3);		
		
		//set tile to immutable
		board.setTile(new Tile(0,5,3));
		Tile immutable = board.tiles[5][3];
		//test new assigned tile
		assertEquals(immutable.getValue(),0);
		
		SwapSpecialMove invalidSwapMove = new SwapSpecialMove(immutable, tile2, model);
		assertFalse(invalidSwapMove.valid());	
		
		//check that board doesn't change after trying to perform move
		invalidSwapMove.doMove();
		assertEquals(immutable.getValue(),0);
		//TODO test quotas for s. moves after it's implemented
	}
	
	public void testDestroy(){
		
		board.setTile(new Tile(0,5,3));
		Tile immutable = board.tiles[5][3];
		
		DestroyTileSpecialMove invDest = new DestroyTileSpecialMove(immutable, model);
		assertFalse(invDest.valid());
		
		//check that board doesn't change after trying to perform move
		invDest.doMove();
		assertEquals(immutable.getValue(),0);
		
		Tile tile1 = board.tiles[5][6];
		Tile tile2 = board.tiles[5][5];
		
		System.out.println(tile1);
		System.out.println(tile2);
		
		int aboveValue = tile2.getValue();
		//check a new valid move
		DestroyTileSpecialMove valDEst = new DestroyTileSpecialMove(tile1, model);
		assertTrue(valDEst.valid());
		
		//test performing it
		valDEst.doMove();
		assertEquals(board.tiles[5][6].getValue(), aboveValue);
		assertNotSame(board.tiles[5][5], tile2);
		
		
	}
	public void testReset(){
		
	}

}
