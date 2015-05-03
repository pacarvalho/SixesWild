package model;

import java.util.ArrayList;

/**
 * Move class for the elimination move.
 * 
 * @author Katie, Sean
 *
 */

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
		
		
		// Check if game has been won or lost
		this.model.checkGameState();
		
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
		// if the any two tiles are diagonal return false
		// if the any two tiles are diagonal return false
		for(int i = 0; i < tiles.size()-1; i++){
			int j = i+1;
			if(tiles.get(i).getRow() == tiles.get(j).getRow()+1 || tiles.get(i).getRow() == tiles.get(j).getRow()-1){
				if(tiles.get(i).getColumn() == tiles.get(j).getColumn()+1 || tiles.get(i).getColumn() == tiles.get(j).getColumn()-1){
					return false;
				}
			}
		}
		
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
