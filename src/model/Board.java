package model;

import java.awt.Point;
import java.io.Serializable;
import java.util.HashMap;

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
	
	/** Stores the tiles of the board in a 2D array */
	Tile[][] tiles;

	/**
	 * Constructor
	 */
	public Board(){
		this.tiles = new Tile[9][9];
	}
	
	/**
	 * Returns the tiles from the board
	 * 
	 * @return
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
	 * Implements "gravity" on board
	 * 
	 * Moves pieces down and spawns new tiles when null tiles exist on the board.
	 */
	public boolean update(){
		
		int[] nullLocation = null;
		int ite = 0;
		int maxIteration = 81; 
		
		while (ite < maxIteration){
			// Check if there is a null in the tile array
			nullLocation = this.findNull();
			
			if (nullLocation == null) {return true;} // No nulls found
			
			// If the null was found on the top row. Spawn a new tile.
			if (nullLocation[1] == 0){
				tiles[nullLocation[0]][nullLocation[1]] = this.spawnNewTile();
			}
			
		}
		
		return false;
	}
	
	/**
	 * Spawns a new tile based on frequency definition 
	 * 
	 * Gets the frequency definition outlined in the level and spawns a new tile.
	 * Note that it normalizes the frequency.
	 */
	public Tile spawnNewTile(){
		
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
	
}
