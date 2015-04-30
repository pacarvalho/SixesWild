package model;

/**
 * Abstract class for SixesWild.
 * 
 * All variation of the game should extend this class.
 * 
 * @author Paulo, Katie, Sean
 *
 */
abstract public class SixesWild {
	
	/** Keeps the current Score of the game */
	int currentScore;
	
	/** Monitor the number of moves made */
	int numMoves;
	
	/** Create a board for the game */
	Board board;
	
	/** Constructor */
	public SixesWild(){
		this.currentScore = 0;
		this.numMoves = 0;
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
	
	/**
	 * Method that increments that changes score by given value
	 * 
	 */
	public boolean updateScore(int change){ 
		this.currentScore = this.currentScore+change;
		return true;
	}
	
	/**
	 * Method that increments the number of moves made by a given value
	 * 
	 */
	public boolean updateMoves(int change){ // Should we check if the game is lost in this method?
		this.numMoves = this.numMoves + change;
		return true;
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
	 * Returns the name of the variation
	 */
	abstract public void updateScore();
}
