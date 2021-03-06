package model;

import java.util.ArrayList;

/**
 * Move class for the elimination move.
 * 
 * @author Katie, Sean
 *
 */

public class EliminationMove implements IMove {
	
	/** Array of selected tiles */
	ArrayList<Tile> tiles;
	
	/** Game Model */
	SixesWild model;
	
	/** Game Board */
	Board board;
	
	/** Multiplier for extra score */
	int multiplierTotal;
	
	/**
	 * Constructor
	 * 
	 * @param tiles
	 * @param model
	 */
	public EliminationMove(ArrayList<Tile> tiles, SixesWild model){
		this.tiles = tiles;
		this.model = model;
		this.board = model.getBoard();
		this.multiplierTotal = 1;
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
		
		model.updateMoves(-1);
		model.updateScore(this.multiplierTotal*10*this.tiles.size());
		
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
		
		// If the game is lost do not allow more moves
		if (this.model.hasLost()) {return false;}
		
		//If the move limit has been reached
		if(model.getNumMoves() <= 0){
			return false;
		}
		
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
		
		int count = 0;
		for (Tile t: tiles){
			// if the tile is a wall, or a container the move is invalid
			if(t.getValue() == 6 || t.getValue() == 0 || t.getValue() == -1 || t.getValue() == -2){
				return false;
			}
			
			if(model.getNumMoves() <= 0){
				return false;
			}
			
			count += t.getValue();
			
			// Note: any time the Move.valid() method is called the multiplier will be incremented
			this.multiplierTotal = this.multiplierTotal * t.getMultiplier();
			
		}
		
		if(count == 6){
			return true;
		}
		
		return false;
	}

}
