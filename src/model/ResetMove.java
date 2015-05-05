package model;
/**
 * Shuffles the board
 * 
 * @author OAkyildiz
 *
 */

public class ResetMove implements IMove{
	
	/** Game model */
	SixesWild model;
	/**Board of that game*/
	Board board;
	
	/**
	 * Constructor
	 * @param model
	 */
	public ResetMove(SixesWild model){
		
;		
		
		this.model = model;
		this.board = model.getBoard();
	}
	/**
	 *  Shuffles the board
	 * 
	 * 
	 * return boolean()
	 */
	@Override
	public boolean doMove() {
		if(!this.valid()) {return false;}
		System.out.println("resetting");
		for(int i = 0; i<9; i++){
			for(int j = 1; j<9; j++){
				Tile tile = board.tiles[i][j];
				if ( tileValid(tile)){
					board.destroyTile(tile);
					Tile newTile =board.spawnNewTile(i, j);
					board.setTile(newTile);;
				}
			}
		}
		return true;
	}
	
	/**
	 * Checks if the move is valid. This move is currently always valid.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valid() {
		
		return true;
	}
	
	/**
	 * Checks if the tiles are valid, eligible to be destroyed.
	 * @param aTile
	 * @return
	 */
	private boolean tileValid(Tile aTile){
		int value = aTile.getValue();
		
		return (value > 0) && ( value < 6)  && !aTile.getEliminatedFlag() ;
		
	}
}
