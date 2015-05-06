package model;

/**
 * 
 * Method overiding for Release variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class ReleaseGame extends SixesWild {
	
	/** 
	 * Constructor
	 */
	public ReleaseGame(){
		super();
	}
	
	/**
	 * Return "Release"
	 */
	@Override
	public String getName(){
		return "Release";
	}
	
	/**
	 * Returns true when game is won
	 * 
	 * Checks that all containers have been filled
	 */
	@Override
	public boolean hasWon(){
		Tile[][] tiles = this.board.getTiles();
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				if(tiles[i][j].getValue() == 0){
					return false;
				}
			}
		}
		
		return true;
	}
	
	

}
