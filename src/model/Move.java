package model;

import java.util.ArrayList;

/**
 * 
 * 
 * @author katiegandomi
 *
 */
public class Move implements IMove{
	
	ArrayList<Tile> tiles;
	Board board;
	
	/**
	 * Constructor
	 * 
	 * @param tiles
	 * @param board
	 */
	public Move(ArrayList<Tile> tiles, SixesWild model){
		this.tiles = tiles;
		this.board = model.getBoard();
	}
	
	/**
	 * Does the "Normal" move.
	 * 
	 * Checks if the selection of tiles result in a valid move. If so, 
	 * destroys the selected tiles by calling method in board. Then calls
	 * update method of board to fill in empty spots.
	 * 
	 * @return boolean
	 */
	public boolean doMove(){
		if(!this.valid()){return false;}
		
		for (Tile t: tiles){
			board.destroyTile(t);
		}	
		
		board.update();
		return true;
	}
	
	
	/**
	 * Checks if the current selection of tiles is valid.
	 * 
	 * No 6 is selected, sum of tiles is 6, no wall or imutable.
	 * 
	 * @return boolean
	 */
	public boolean valid(){
		return true;
	}

}
