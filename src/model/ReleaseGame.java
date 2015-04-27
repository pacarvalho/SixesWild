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
	public boolean hasWon(){
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasLost(){
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returns the board
	 */
	@Override
	public Board getBoard(){
		return this.board;
	}
	
	

}
