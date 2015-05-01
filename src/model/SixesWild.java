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
	
	/**Number of stars earned*/
	int stars;
	
	/** Monitor the number of moves made */
	int numMoves;
	
	/** Create a board for the game */
	Board board;
	
	/** Star unlock multipliers */
	private double win1 = 1;
	private double win2 = 1.3;
	private double win3 = 1.7;
	
	/**Star flags*/
	public static final int FIRST = 1; 	// 2^^0
	public static final int SECOND = 2; // 2^^1
	public static final int THIRD = 4;  // 2^^2
	
	/** Constructor */
	public SixesWild(){
		this.currentScore = 0;
		this.numMoves = 0;
		this.board = null;
		this.stars = 0;
	}
	
	/**
	 * Initializes a game to reflect the loaded settings and variation.
	 */
	public void initialize(Board board){
		this.board = board;
		this.win1 *= board.scoreLimit;
		this.win2 *= board.scoreLimit;
		this.win3 *= board.scoreLimit;
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
	 * Returns the currentScore
	 */
	public int getCurrentScore() {
		return this.currentScore;
	}
	abstract public void updateScore();
	
	/** evaluates if a star is earned or lost */
	// migth be moved to Board
	public int assessScore(){
		int EVAL = 0;
		int score = getCurrentScore();
		
		if(score >= win3)
			EVAL= 7;
		
		else if(score >= win2)
			EVAL = 3;
		
		else if(score >= win1)
			EVAL = 1;
		
		int change = this.stars^EVAL;
		this.stars=EVAL;
		
		return change;
	}
}
