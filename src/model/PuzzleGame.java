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
