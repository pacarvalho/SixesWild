package model;

/**
 * Special move: Swapping
 * 
 * @author Ozan
 *
 */

public class SwapSpecialMove implements IMove{
	
	/** Tile 1 to swap*/
	Tile tile1;
	
	/** Tile 2 to swap*/
	Tile tile2;
	
	/** Game model to make move*/
	SixesWild model;
	
	/** Board of the game instance*/
	Board board;
	
	/**
	 * Constructor
	 * @param tile1
	 * @param tile2
	 * @param model
	 */
	public SwapSpecialMove(Tile tile1, Tile tile2, SixesWild model){
		
		this.tile1 = tile1;
		this.tile2 = tile2;		
		
		this.model = model;
		this.board = model.getBoard();
	}
	
	/**
	 *  Does the swap move.
	 * 
	 * 
	 * return boolean()
	 */
	@Override
	public boolean doMove() {
		if(!this.valid()) {return false;}
		System.out.println("doing move");
		
		board.swapTwoTiles(tile1, tile2);
		
		
		return true;
	}
	
	/**
	 * Checks if the current selection of tiles is valid.
	 * 
	 * Any two different tiles that has a value between 1 and 5 is selected.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valid() {
		
		return (tile1 != tile2 && tileValid(tile1) && tileValid(tile2));
	}
	
	/**
	 * Determines if selected tile is a swappable tile
	 * 
	 * @param aTile
	 * @return
	 */
	private boolean tileValid(Tile aTile){
		int value = aTile.getValue();
		
		return (value > 0 ) && ( value < 6);
		
	}
}