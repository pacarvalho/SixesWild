package model;
/**
 * Destroys a given tile, updates the board and 
 * switches back to default mouse adapter.
 * 
 * @author OAkyildiz
 *
 */
public class DestroyTileSpecialMove implements IMove {
	
	/** Tile to be destroyed */
	Tile tile1;
	/** Game model*/
	SixesWild model;
	/**Board model*/
	Board board;
	
	/**
	 * Constructor
	 * 
	 * @param tile
	 * @param model
	 */
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
		System.out.println("doing move");
		
		board.destroyTile(tile1);
		board.update();
		
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
		return (value > 0 )&& ( value < 6);
	}
	
}
