package model;

/**
 * 
 * Method overiding for Puzzle variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class PuzzleGame extends SixesWild {

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
	 * 
	 */
	@Override
	public String getName(){
		return "Puzzle";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasLost(){
		return false;
	}
}
