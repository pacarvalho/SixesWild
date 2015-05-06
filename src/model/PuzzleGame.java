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
	 * Constructor
	 */
	public PuzzleGame(){
		super();
	}
	
	/**
	 * Returns name of variation
	 */
	@Override
	public String getName(){
		return "Puzzle";
	}
	
	/**
	 * Determines that a game is won
	 * 
	 * Based on max score
	 */
	@Override
	public boolean hasWon(){
		// Check for max score.
		if (this.board.getScoreLimit() <= this.getCurrentScore()){
			return true;
		}
		
		return false;
	}
	
}
