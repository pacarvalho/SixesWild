package model;

/**
 * Abstract class for SixesWild.
 * 
 * All variation of the game should extend this class.
 * 
 * @author Paulo, Katie
 *
 */
abstract public class SixesWild {
	
	/** Keeps the current Score of the game */
	int currentScore;
	
	/** Create a board for the game */
	Board board;
	
	/** Constructor */
	public SixesWild(){
		this.currentScore = 0;
		this.board = null;
	}
	
	/**
	 * Initializes a game to reflect the loaded settings and variation.
	 */
	public void initialize(Board board){
		this.board = board;
	}
	
	/**
	 * Returns the board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	//ABSTRACT METHODS
	/**
	 * Returns true if a game is in a won state. Else it returns false.
	 */
	abstract public boolean hasWon();
	
	/**
	 * Returns the name of the variation
	 */
	abstract public String getName();
	
	/**
	 * Returns true if the game is at a lost state. 
	 * 
	 * Ex: The timer has run out in the lightning variation.
	 */
	abstract public boolean hasLost();
	
	/**
	 * Method that incrememnts the score by 1
	 * 
	 */
	abstract public void updateScore();
}
