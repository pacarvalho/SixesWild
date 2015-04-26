package model;

/**
 * 
 * Method overiding for Puzzle variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class PuzzleGame extends SixesWild {
	
	public PuzzleGame(){
		super();
	}

	/**
	 * 
	 */
	@Override
	public void initialize(Level level){
		this.board = level.board;
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
	
	/**
	 * Returns the board
	 */
	@Override
	public Board getBoard(){
		return this.board;
	}
	
}
