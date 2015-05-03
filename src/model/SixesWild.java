package model;

import controllers.ScoreStarUpdater;

/**
 * Abstract class for SixesWild.
 * 
 * All variation of the game should extend this class.
 * 
 * @author Paulo, Katie, Sean, OAkyildiz
 *
 */
abstract public class SixesWild {
	
	/** Keeps the current Score of the game */
	int currentScore;
	
	/**Number of stars earned*/
	public int stars;

	/**Array of number of remaining special moves*/
	int[] specQuotas = new int[3];
	
	/**Listener for score changes*/
	private ScoreStarUpdater updater;

	/** Monitor the number of moves made */
	int numMoves;
	
	/** Create a board for the game */
	Board board;
	
	/** Star unlock multipliers */
	public double win1 = 1;
	public double win2 = 1.3;
	public double win3 = 1.7;
	
	/**Star flags*/
	public static final int FIRST = 1; 	// 2^^0
	public static final int SECOND = 2; // 2^^1
	public static final int THIRD = 4;  // 2^^2
	
	public static final int DEFAULT =1;
	
	/** Constructor */
	public SixesWild(){
		this.currentScore = 0;
		this.numMoves = 0;
		this.board = null;
		this.stars = 0;
		this.specQuotas = new int[]{3,1,1};
		this.setUpdater(new ScoreStarUpdater(this));
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
	 * Calls the hasWon and hasLost methods. 
	 * 
	 * Serializes the LevelTracker when appropriate
	 */
	public void checkGameState() {
		if (this.hasWon()) {
			// TODO
			
		} else if (this.hasLost()) {
			// TODO
			
		}
		
	}
	
	/**
	 * Method that increments that changes score by given value
	 * 
	 */
	public boolean updateScore(int change){ 
		this.currentScore = this.currentScore+change;
		this.getUpdater().scoreUpdated();
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
	
	public int getSpecQuotas(int i) {
		return specQuotas[i];
	}

	public boolean changeSpecQuotas(int index, int change) {
		this.specQuotas[index] += change;
		return true;
	}
	public boolean setSpecQuotas(int index, int number) {
		this.specQuotas[index] = number;
		return true;
	}

	public ScoreStarUpdater getUpdater() {
		return updater;
	}

	public void setUpdater(ScoreStarUpdater updater) {
		this.updater = updater;
	}

}
