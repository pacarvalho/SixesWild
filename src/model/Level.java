package model;

import java.io.Serializable;

/**
 * Contains specifications for a given level
 * 
 * This class contains the startup conditions for a specific level. It is originally generated
 * in the gameBuilder and is loaded and passed as an argument to initialize of the given variation
 * inside the chooseLevelController.
 * 
 * @author Paulo, Katie
 *
 */
public class Level implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3863177480366707855L;

	/** 
	 * Values of the board as a 2 dimensional array.
	 * 
	 * Numbers 1-5 denote a mutable tiles with the given number.
	 * Number 6 is immutable tile.
	 * Number 0 is a receptable for receiving a 6.
	 * Number -1 for wall type tile
	 */
	Board board;
	
	/**
	 * Game frequencies
	 * 
	 * Denotes the frequency with which values from 1-5 appear.
	 * 
	 * Note that index refers to the number 1 greater than it. Ex: index 1
	 * contains the value of the frequency for 2.
	 */
	int[] frequency;
	
	/**
	 * Score limit
	 * 
	 * Determines the score upon which a game is considered as having been won.
	 */
	int scoreLimit;
	
	/**
	 * Time limit
	 * 
	 * Determines a time at which a game is considered to have been lost. Note that
	 * this attributes is only considered in lightning type games. 
	 * 
	 * It should be preferably set to 0 for other types.
	 */
	int timeLimit;
	
	/**
	 * Constructor
	 * 
	 * This is the constructor to build a default level. The default board will be composed
	 * only of 2's.
	 */
	public Level(){
		// Create the default board
		this.board = new Board();
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				Tile t = new Tile(2, i, j);
				this.board.setTile(t);
			}
		}
		
		// Set all frequencies to same probability of each
		this.frequency = new int[5];
		for (int i=0; i<5; i++){
			this.frequency[i] = 1;
		}
		
		// Set the score and time limit
		this.scoreLimit = 100;
		this.timeLimit = 100;
		
		
	}
	
	
	
}
