package model;

/**
 * Abstract class for SixesWild.
 * 
 * All variation of the game should extend this class.
 * 
 * @author Paulo
 *
 */
abstract public class SixesWild {
	
	/** Keeps the current Score of the game */
	int currentScore;
	
	/** Keeps the max score of the Game */
	int maxScore;
	
	/** Create a board for the game */
	Board board;
	
	/** Move attribute */
	IMove move;
	
	/** Constructor */
	public SixesWild(){
		//TODO: FIND BETTER SUBSTITUTE FOR NULL ~
		this.board = null;
	}
	
	/**
	 * Initializes a game to reflect the loaded settings and variation.
	 */
	public void initialize(Level level){
		
	}
	
	/**
	 * Returns true if a game is in a won state. Else it returns false.
	 */
	public boolean hasWon(){
		return false;
	}
	
	/**
	 * Returns the name of the variation
	 */
	public String getName(){
		return null;
	}
	
	/**
	 * Returns true if the game is at a lost state. 
	 * 
	 * Ex: The timer has run out in the lightning variation.
	 */
	public boolean hasLost(){
		return false;
	}
	
	/**
	 * Returns the board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	/**
	 * Method that incrememnts the score by 1
	 * 
	 */
	public void updateScore(){
		this.currentScore += 1;
	}
}
