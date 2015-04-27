package model;

/**
 * General type of tile which can be clicked.
 * 
 * @author Paulo, Katie
 *
 */
public class Tile{
	
	/**
	 * Value of the Tile
	 * 
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
	 * Returns the value of the tile
	 * @return int
	 */
	public int getValue(){
		return this.value;
	}
	
	/**
	 * Pretty printing of tile value
	 */
	@Override
	public String toString(){
		return "Tile Value: " + this.value;
	}
	
	

}
