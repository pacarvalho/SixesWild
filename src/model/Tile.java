package model;

import java.io.Serializable;

/**
 * General type of tile which can be clicked.
 * 
 * @author Paulo, Katie, Sean
 *
 */
public class Tile implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3051808425738414764L;

	/**
	 * Value of the Tile
	 * 
	 * -3 is a container tile with a six in it
	 * -1 is a wall tile
	 * 	0 is a container tile
	 * 	1-5 are normal tiles
	 * 	6 is a six tile 
	 */
	int value;
	
	/** Row location of the tile in array */
	int row;
	
	/** Column location of the tile in array */
	int col;
	
	/** Value of the score multiplier */
	int multiplier;
	
	/**
	 * Indicates the tile is selected
	 * 
	 * Used by the builder to indicate which tile should be added to the board. It is also used in the 
	 * game to indicate which tiles are currently selected during a move.
	 */
	boolean selectedFlag;
	
	/**
	 * Indicates the tile has been eliminated
	 * 
	 * Used by the elimination game in computing which tiles have been eliminated
	 */
	boolean eliminatedFlag;
	
	
	/**
	 * Constructor
	 */
	public Tile(int value, int row, int col){
		this.value = value;
		this.row = row;
		this.col = col;
		
		this.multiplier = 1;
		this.selectedFlag = false;
		this.eliminatedFlag = false;
	}
	
	/**
	 * Returns the value of the tile
	 * @return int
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * Returns the column of the tile
	 * @return int
	 */
	public int getColumn(){
		return this.col;
	}
	
	/**
	 * Returns the row of the tile
	 * @return int
	 */
	public int getRow(){
		return this.row;
	}
	
	/**
	 * Sets the value of the tile
	 * @return void
	 */
	public boolean setValue(int x){
		if(x <= 6){
			this.value = x;
			return true;}
		else return false;
	}
	
	/**
	 * Getter method for has been selected attribute
	 */
	public boolean getSelectedFlag(){
		return this.selectedFlag;
	}
	
	/**
	 * Setter method for the has been selected attribute
	 */
	public boolean setSelectedFlag(boolean value){
		this.selectedFlag = value;
		
		return true;
	}
	
	/**
	 * Sets the score multiplier 
	 * 
	 * @param x
	 * @return
	 */
	public boolean setMultiplier(int x){
		if(0 < x ||x < 4){
			this.multiplier = x;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the multiplier for the tile
	 * 
	 * @return
	 */
	public int getMultiplier(){
		return this.multiplier;
	}
	
	/**
	 * Pretty printing of tile value
	 */
	@Override
	public String toString(){
		return "Tile Value: " + this.value;
	}

	/**
	 * Getter method for eliminated flag
	 * 
	 * @return
	 */
	public boolean getEliminatedFlag() {
		return this.eliminatedFlag;
	}
	
	/**
	 * Setter method for eliminated flag
	 */
	public boolean setEliminatedFlag(boolean value){
		this.eliminatedFlag = value;
		
		return true;
	}
	
	

}
