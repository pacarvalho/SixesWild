package model;

import java.awt.Point;
import java.util.HashMap;

/**
 * Board class. 
 * 
 * Contains a composition of tiles.
 * 
 * @author Paulo, Katie
 *
 */
public class Board {
	

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
		
	
	// Given a set of tiles the board
	// takes these new tiles as its own
	// and loops through them to determine which
	// tiles have been set to empty and then performs
	// the desired action of updating the pieces
	public void update(){
		// TODO
	}
	
	
	
}
