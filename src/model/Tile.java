package model;

import java.awt.Color;

/**
 * General type of tile which can be clicked.
 * 
 * @author Paulo, Katie
 *
 */
public class Tile{
	
	int value;
	int row;
	int col;
	
	/**
	 * Constructor
	 */
	public Tile(int value, int row, int col){
		this.value = value;
		this.row = row;
		this.col = col;
	}
	
	/**
	 * Determine whether the tile has been selected.
	 * @return boolean
	 */
	public boolean isSelected(int x, int y) {
		
		return false;
	}
	
	/**
	 * 
	 */
	
	

}
