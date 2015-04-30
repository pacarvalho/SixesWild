package model;

/**
 * General type of tile which can be clicked.
 * 
 * @author Paulo, Katie, Sean
 *
 */
public class Tile{
	
	//TODO Add Multiplier Attribute and Selected boolean 
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
	
	/** Vaule of the score multiplier */
	int multiplier;
	
	
	/**
	 * Constructor
	 */
	public Tile(int value, int row, int col){
		this.value = value;
		this.row = row;
		this.col = col;
		this.multiplier = 1;
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
	
	public boolean setMultiplier(int x){
		if(0 < x ||x < 4){
			this.multiplier = x;
			return true;}
		else return false;
	}
	
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
	
	

}
