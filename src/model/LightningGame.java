package model;


/**
 * 
 * Method overiding for Lightning variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class LightningGame extends SixesWild {
	
	public LightningGame(){
		super();
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasWon(){
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public String getName(){
		return "Lightning";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasLost(){
		return false;
	}
	
	/**
	 * Returns the board
	 */
	@Override
	public Board getBoard(){
		return this.board;
	}
}
