package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	ScoreStarUpdater updater;

	/** Monitor the number of moves remiaining */
	int numMoves;
	

	/** Create a board for the game */
	Board board;
	
	/** Star unlock multipliers */
	public static final double WIN1 = 1;
	public static final double WIN2 = 1.5;
	public static final double WIN3 = 1.9;
	
	/**Star flags*/
	public static final int FIRST = 1; 	// 2^^0
	public static final int SECOND = 2; // 2^^1
	public static final int THIRD = 4;  // 2^^2
	public static final int DEFAULT =1;
	
	/**
	 *  Constructor
	 * 
	 */
	public SixesWild(){
		this.currentScore = 0;
		this.board = null;
		this.stars = 0;
		this.specQuotas = new int[]{3,1,1};
		
	}
	
	/**
	 * Initializes a game to reflect the loaded settings and variation.
	 */
	public void initialize(Board board){
		this.board = board;
		this.setUpdater(new ScoreStarUpdater(this));
		this.numMoves = board.getMaxMoves();
	}
	
	/**
	 * Returns the board
	 */
	public Board getBoard(){
		return this.board;
	}
	
	/**
	 * Returns the number of moves remaining.
	 */
	public int getNumMoves() {
		return numMoves;
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
		this.numMoves += change;
		return true;
	}
	
	/**
	 * Update the Level Tracker
	 * 
	 * If upon calling this method the current score is greater than that stored in the level tracker
	 * It updates the level tracker.
	 * 
	 * Also unlocks the next level when a previous leve is won. Winning check is performed by hasWon()
	 * 
	 * @return boolean
	 */
	public boolean updateLevelTracker(int currentLevel){
		
		if (currentLevel == 5) {return false;} // Custom levels are not tracked!
		
		currentLevel -= 1; // Recall that level 1 should be level 0!
		
		// Deserialize the level tracker
		LevelTracker lt = null;
		try{
			lt = (LevelTracker) deserialize("resources/levels/level_tracker.txt");
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		// Check that a level tracker was opened
		if(lt == null){ 
			System.out.println("LevelTracker not found");
			return false; 
		}
		
		// Update current instance of level tracker
		if( this instanceof PuzzleGame){
			if (this.currentScore > lt.puzzleScore[currentLevel]){
				lt.puzzleScore[currentLevel] = currentScore;
			}
			
			if (this.hasWon() && (currentLevel < 3)) {
				lt.puzzleLocked[currentLevel +1 ] = false;
			}
			
		} else if (this instanceof EliminationGame){
			if (this.currentScore > lt.eliminationScore[currentLevel]){
				lt.eliminationScore[currentLevel] = currentScore;
			}
			
			if (this.hasWon() && (currentLevel < 3)) {
				lt.eliminationLocked[currentLevel + 1] = false;
			}
			
		}  else if (this instanceof LightningGame){
			if (this.currentScore > lt.lightningScore[currentLevel]){
				lt.lightningScore[currentLevel] = currentScore;
			}
			
			if (this.hasWon() && (currentLevel < 3)) {
				lt.lightningLocked[currentLevel + 1] = false;
			}
			
		}  else if (this instanceof ReleaseGame){
			if (this.currentScore > lt.releaseScore[currentLevel]){
				lt.releaseScore[currentLevel] = currentScore;
			}
			
			if (this.hasWon() && (currentLevel < 3)) {
				lt.releaseLocked[currentLevel + 1] = false;
			}
		}
		
		// Serialize the level tracker
		try {
			serialize(lt, "resources/levels/level_tracker.txt");
		} catch (IOException z) {
			z.printStackTrace();
		} 
		
		return true;
		
	}
	
	/**
	 * Resets the Level Tracker 
	 * 
	 * This method is for debugging, it resets the level tracker values to 
	 * relock all levels
	 */
	public void resetLevelTracker(){
		LevelTracker lt = new LevelTracker();
		
		try {
			serialize(lt, "resources/levels/level_tracker.txt");
		} catch (IOException z) {
			z.printStackTrace();
		} 
	}
	
	
	/**
	 * Serializes the LevelTracker
	 */
	public void serialize(Object obj, String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		
		fos.close();
	}
	
	/**
	 * Loads a serialized object
	 */
	public Object deserialize(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		ois.close();
		
		return obj;
	}
	
	/**
	 * Returns true if the game is at a lost state. 
	 * 
	 * Ex: The timer has run out in the lightning variation.
	 */
	public boolean hasLost(){
		return false; //For now...
	}
	
	/**
	 *  Returns the remaining allowed special moves
	 *  
	 */
	public int getSpecQuotas(int i) {
		return specQuotas[i];
	}
	
	/**
	 * Increments or decrements the specified special move quota buy int change"
	 * 
	 */
	public boolean changeSpecQuotas(int index, int change) {
		this.specQuotas[index] += change;
		return true;
	}
	
	/**
	 *  Sets the quota for given special move
	 */
	public boolean setSpecQuotas(int index, int number) {
		this.specQuotas[index] = number;
		return true;
	}
	
	/**
	 * Returns the score related GUI updater for this  model
	 * @return
	 */
	public ScoreStarUpdater getUpdater() {
		return updater;
	}
	
	/**
	 * Sets the score GUI updater (controller)
	 * @param updater
	 */
	public void setUpdater(ScoreStarUpdater updater) {
		this.updater = updater;
	}
	
	/**
	 * Returns the currentScore
	 */
	public int getCurrentScore() {
		return this.currentScore;
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
	 * Updates the score with game specific metrics.
	 * 
	 * Has not been used in any of the game implementations.
	 */
	abstract public void updateScore();

}
