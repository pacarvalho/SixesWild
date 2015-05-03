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
					board.spawnNewTile(i, j);
					board.update();
				}
			}
		}
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
		
		return true;
	}
	
	private boolean tileValid(Tile aTile){
		int value = aTile.getValue();
		
		return (value > 0) && ( value < 6)  && !aTile.getEliminatedFlag() ;
		
	}
}
