package model;

/**
 * 
 * Method overiding for Puzzle variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class PuzzleGame extends SixesWild {

	/*
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
	
	/**
	 * Determines that a game has been lost
	 * 
	 * Maximum number of moves has been reached but score has not
	 */
	@Override
	public boolean hasLost(){
		
//		// Check for max score. // TODO
//		if ((this.board.getScoreLimit() > this.getCurrentScore())){
//			return true;
//		}
		
		return false;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
}
