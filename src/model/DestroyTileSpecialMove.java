package model;

public class DestroyTileSpecialMove implements IMove {
	
	Tile tile1;

	SixesWild model;
	Board board;
	
	public DestroyTileSpecialMove(Tile tile, SixesWild model){
		
		this.tile1 = tile;
	
		this.model = model;
		this.board = this.model.getBoard();
	}
	/**
	 *  Destroys a selected tile
	 * 
	 * 
	 * return boolean()
	 */

	@Override
	public boolean doMove() {
		if(!this.valid()) {return false;}
		
		board.destroyTile(tile1);
		
		return true;
	}
	
	/**
	 * Checks if the target Tile is valid.
	 *  
	 * 
	 * Any two different tiles that has a value between 1 and 5 can be selected.
	 * 
	 * @return boolean
	 */

	@Override
	public boolean valid() {
		
		int value = this.tile1.getValue();
		
		return (value < 0 )&& ( value > 6);
	}
	

}
