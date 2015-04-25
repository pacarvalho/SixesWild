package model;

/**
 * Method overriding for elimination variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class EliminationGame extends SixesWild {
	
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
		return "Elimination";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasLost(){
		return false;
	}

}
