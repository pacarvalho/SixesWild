package model;

/**
 * Method overriding for elimination variation of the game goes here.
 * 
 * @author Paulo, Katie, OAkyildiz
 *
 *
 */
public class EliminationGame extends SixesWild {
	
	public EliminationGame(){
		super();
		this.stars = 7;
		this.specQuotas = new int[]{1,0,1};
	}
	
	/**
	 * Returns the name of this variation
	 */
	@Override
	public String getName(){
		return "Elimination";
	}
	
	/**
	 * Returns true if the game is won
	 * 
	 * Checks to see if there are any tiles that have 
	 * not yet been eliminated
	 */
	@Override
	public boolean hasWon(){
		Tile[][] tiles = this.board.getTiles();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(!tiles[i][j].eliminatedFlag){
					return false;
				}
			}
		}
		
		return true;
	}


}
