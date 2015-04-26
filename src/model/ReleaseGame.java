package model;

/**
 * 
 * Method overiding for Release variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class ReleaseGame extends SixesWild {
	
	public ReleaseGame(){
		super();
	}
	
	/**
	 * 
	 */
	@Override
	public void initialize(Level level){
		
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasWon(){
		return false;
	}
	
	/**
	 * Return "Release"
	 */
	@Override
	public String getName(){
		return "Release";
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
