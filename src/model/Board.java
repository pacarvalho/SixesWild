package model;

import java.io.Serializable;
import java.util.Random;

/**
 * Board class. 
 * 
 * Contains a composition of tiles.
 * 
 * @author Paulo, Katie
 *
 */
public class Board implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -322533594946675843L;
	
	/**
	 * Game frequencies
	 * 
	 * Denotes the frequency with which values from 1-5 appear.
	 * 
	 * Note that index refers to the number 1 greater than it. Ex: index 1
	 * contains the value of the frequency for 2.
	 */
	int[] frequency = {1,1,1,1,1}; // Default
	
	/**
	 * Multiplier frequencies
	 * 
	 * Denotes the frequency with which x2/ x3 multiplier appears
	 */
	int[] multiplierFreq = {1,1};
	
	/**
	 * Chance of a multiplier appearing
	 * 
	 * Denotes the chance of a multiplier appearing opposed to no multiplier
	 */
	int chanceMultiplier;
	
	/**
	 * Max Move Limit
	 * 
	 * Determines the number of available moves in a given level
	 */
	int maxMoves;
	
	/**
	 * Score limit
	 * 
	 * Determines the score upon which a game is considered as won.
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
	
	/** Stores the tiles of the board in a 2D array */
	Tile[][] tiles;

	/**
	 * Constructor
	 */
	public Board(){
		this.tiles = new Tile[9][9];
		
		this.timeLimit = 0; // Default time
		this.scoreLimit = 0; // Default Max Score
		this.maxMoves = 20; // Default Max Moves
		this.chanceMultiplier = 0; // Default chance of multiplier
	}
	
	/**
	 * Returns the tiles from the board
	 * 
	 * @return Tile[][]
	 */
	public Tile[][] getTiles(){
		return tiles;
	}
	
	/**
	 * When called destroys a specific tile in the board 
	 * 
	 * Sets it to null.
	 * 
	 * @param t
	 */
	public boolean destroyTile(Tile t){
		if(t == null){return false;}
		
		tiles[t.row][t.col] = null;
		return true;
	}
	
	/**
	 * Sets a tile in the board to the given tile.
	 * 
	 * @param t
	 */
	public void setTile(Tile t){
		tiles[t.row][t.col] = t;
	}
	
	/**
	 * 
	 */
	public void setEliminationTileValue(Tile t){
		t.setEliminatedFlag(true);
	}
	
	/**
	 * Swaps the valeus of two tiles
	 */
	public void swapTwoTiles(Tile t1, Tile t2){
		int tempVal=t1.getValue();
		t1.setValue(t2.getValue());
		t2.setValue(tempVal);
		t1.setSelectedFlag(false);
		t2.setSelectedFlag(false);
	}
	
	/**
	 * Implements "gravity" on board
	 * 
	 * Moves pieces down and spawns new tiles when null tiles exist on the board.
	 */
	public boolean update(){
		
		int[] nullLocation = null;
		int ite = 0;
		int maxIteration = 500; 
		
		while (ite < maxIteration){
			// Check if there is a null in the tile array
			nullLocation = this.findNull();
			
			if (nullLocation == null) {break;} // No nulls found
			
			// If the null was found on the top row. Spawn a new tile.
			if (nullLocation[1] == 0){
				tiles[nullLocation[0]][nullLocation[1]] = this.spawnNewTile(nullLocation[0], nullLocation[1]);
				
			} else { // Will move piece above it down 
				
				// If the piece above the current one is an unmovable type spawn new tile
				if (tiles[nullLocation[0]][nullLocation[1]-1].getValue() == -1 || // Wall 
							tiles[nullLocation[0]][nullLocation[1]-1].getValue() == 0){ // Container
					
					tiles[nullLocation[0]][nullLocation[1]] = this.spawnNewTile(nullLocation[0], nullLocation[1]); // Spawn
			
				} else if (tiles[nullLocation[0]][nullLocation[1]-1] != null){
					// Checks all pieces above the current piece looking for a not-null. Once it is found.
					// It sets the current tile to that tile and sets that tile to null.
					
					tiles[nullLocation[0]][nullLocation[1]] =  
							new Tile(tiles[nullLocation[0]][nullLocation[1]-1].getValue(), nullLocation[0], nullLocation[1]);
					
					// Don't forget the multiplier!
					tiles[nullLocation[0]][nullLocation[1]].setMultiplier(tiles[nullLocation[0]][nullLocation[1]-1].getMultiplier());
					
					this.destroyTile(tiles[nullLocation[0]][nullLocation[1]-1]); // Delete Tile
				}		
			}
			
			// Increment interaction
			ite += 1;
		}
		
		// Do logic for falling sixes
		this.releaseGravity();
				
		return false;
	}
	
	/**
	 * Release Gravity logic
	 * 
	 * Checks the board for container tiles if a container tile is found it checks the tile above it
	 * If the tile above it is a 6 it is set to null and the container updates itself to a full container.
	 */
	public void releaseGravity(){
		for(int i = 0; i<9; i++){
			for(int j = 1; j<9; j++){
				if (this.tiles[i][j] != null && this.tiles[i][j-1] != null) {
					if(this.tiles[i][j].getValue() == 0){
						System.out.println("IM HERE?");
						if(this.tiles[i][j-1].getValue() == 6){
							System.out.println("IM HERE!");
							this.destroyTile(this.tiles[i][j-1]);
							this.tiles[i][j].setValue(-3);
							this.update();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Spawns a new tile based on frequency definition 
	 * 
	 * Gets the frequency definition outlined in the level and spawns a new tile.
	 * Note that it normalizes the frequency.
	 */
	public Tile spawnNewTile(int x, int y){
		Random rand = new Random();
		Tile t = null;
				
		if (frequency == null) { // No statistics is defined. All values have same prob
			return new Tile(rand.nextInt(5) + 1, x, y);
		}
		
		// Sum up all the frequency values
		int totalFrequency = 0; 
		for (int f: this.frequency){
			totalFrequency += f;
		}
		
		// Generate random number up to sum
		int chance = rand.nextInt(totalFrequency) + 1;
		// Decide which tile to spawn
		if (chance <= frequency[0]){
			t = new Tile(1, x, y);
		} else if (chance <= (frequency[0] + frequency[1])) {
			t = new Tile(2, x, y);
		} else if (chance <= (frequency[0] + frequency[1] + frequency[2])){
			t = new Tile(3, x, y);
		} else if (chance <= (frequency[0] + frequency[1] + frequency[2] + frequency[3])){
			t = new Tile(4, x, y);
		} else {
			t = new Tile(5, x, y);
		}
		
		// Set the multiplier for the tile
		int chanceM = this.getChanceMultiplierFrequency();
		
		if (chanceM > rand.nextInt(100) + 1) { // Chance of having a multiplier at ALL
			int sumChance = this.get2x3xFrequency(0) + this.get2x3xFrequency(1);
			
			if (this.get2x3xFrequency(1) < rand.nextInt(sumChance) + 1) { // Chance of having a 2X
				t.setMultiplier(2);
				
			} else {
				t.setMultiplier(3);
			}
		}
		
		return t;
		
		
	}
	
	/**
	 * Returns the location of a null
	 * 
	 * Returns an array containing the position of a null. Else returns null.
	 * 
	 * @return int array
	 */
	public int[] findNull(){
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (this.tiles[i][j] == null) { // Update location and return true
					return new int[]{i, j};
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Makes this Board a Default Board composed solely of nulls
	 * 
	 */
	public void createDefaultBoard(){
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				this.tiles[i][j] = null;
			}
		}
	}
	
	/**
	 * Prints neatly for debugging
	 */
	@Override
	public String toString(){
		String info = new String();
		
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				info += this.tiles[i][j] +  " ";
			}
			info += "\n";
		}
		
		return info;
	}
	
	/**
	 * Getter for the time limit attribute
	 */
	public int getTimeLimit(){
		return this.timeLimit;
	}
	
	/**
	 * Setter for the time limit
	 */
	public boolean setTimeLimit(int limit){
		if (limit <= 0) {return false;}
		
		this.timeLimit = limit;
		return true;
	}

	/**
	 * Getter for the score limit attribute
	 */
	public int getScoreLimit(){
		return this.scoreLimit;
	}
	
	/**
	 * Setter for the score limit
	 */
	public boolean setScoreLimit(int limit){
		if (limit <= 0) {return false;}
		
		this.scoreLimit = limit;
		return true;
	}
	
	/**
	 * Getter for frequency
	 */
	public int getFrequency(int index){
		if (index > 4 || index < 0) {index = 0;}
		
		return this.frequency[index];
		
	}
	
	/**
	 * Setter for frequency
	 */
	public boolean setFrequency(int index, int value){
		if (index > 4 || index < 0) {return false;}
		
		this.frequency[index] = value;
		
		return true;
	}
	
	/**
	 * Getter for max moves
	 */
	public int getMaxMoves(){
		return this.maxMoves;
	}
	
	/**
	 * Setter for max moves
	 */
	public boolean setMaxMoves(int max){
		this.maxMoves = max;
		return true;
	}
	
	/**
	 * Getter for multiplierFrequencies moves
	 */
	public int getChanceMultiplierFrequency(){
		return this.chanceMultiplier;
	}
	
	/**
	 * Setter for multiplierFrequencies moves
	 */
	public boolean setChanceMultiplierFrequency(int m){
		this.chanceMultiplier = m;
		return true;
	}
	
	/**
	 * Getter for Frequencies of each multiplier
	 */
	public int get2x3xFrequency(int index){
		if(index > 1 || index < 0) {return 0;}
		
		return this.multiplierFreq[index];
	}
	
	/**
	 * Getter for Frequencies of each multiplier
	 */
	public boolean set2x3xFrequency(int index, int value){
		if(index > 1 || index < 0) {return false;}
		
		this.multiplierFreq[index] = value;
		return true;
	}
	
}
