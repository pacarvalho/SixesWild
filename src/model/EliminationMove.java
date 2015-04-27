package model;

import java.util.ArrayList;

public class EliminationMove implements IMove {
	
	ArrayList<Tile> tiles;
	SixesWild model;
	Board board;
	
	public EliminationMove(ArrayList<Tile> tiles, SixesWild model){
		this.tiles = tiles;
		this.model = model;
		this.board = model.getBoard();
	}

	
	/**
	 * Does the "Elimination" move.
	 * 
	 * Checks if the selection of tiles result in a valid move. If so, 
	 * "selects" the selected tiles by calling method in board. Then calls
	 *  update method of boardView to fill slots with Elimination Tiles
	 * 
	 * @return boolean
	 */
	@Override
	public boolean doMove() {
		if(!this.valid()) {return false;}
		
		for(Tile t: tiles){
			board.setEliminationTileValue(t);
		}
		
		return true;
	}

	/**
	 * Checks if the current selection of tiles is valid.
	 * 
	 * Sum of tiles is 6 and no six, wall, immutable, or eliminated tiles are selected.
	 * 
	 * @return boolean
	 */
	@Override
	public boolean valid() {
		int count = 0;
		for (Tile t: tiles){
			// if the tile is a wall, or a container the move is invalid
			if(t.getValue() == 6 || t.getValue() == 0 || t.getValue() == -1 || t.getValue() == -2){
				return false;
			}
			
			count += t.getValue();
			
			// if the sum of the tiles is greater than six the move is invalid
			if(count > 6){
				return false;
			}
		}
		
		if(count == 6){
			return true;
		}
		
		return false;
	}

}
