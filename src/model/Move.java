package model;

import java.util.ArrayList;

/**
 * 
 * 
 * @author Katie, Sean
 *
 */
public class Move implements IMove{
	
	ArrayList<Tile> tiles;
	SixesWild model;
	Board board;
	
	/**
	 * Constructor
	 * 
	 * @param tiles
	 * @param board
	 */
	public Move(ArrayList<Tile> tiles, SixesWild model){
		this.tiles = tiles;
		this.model = model;
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
	 * Sum of tiles is 6 and no six, wall, or immutable tiles are selected.
	 * 
	 * @return boolean
	 */
	public boolean valid(){ 
		int count = 0;
		for (Tile t: tiles){
			// if the tile is a six, a wall, or a container the move is invalid
			if(t.getValue() == 6 || t.getValue() == 0 || t.getValue() == -1){
				return false;
			}
			// if the any two tiles are diagonal return false
			for(int i = 0; i < tiles.size()-1; i++){
				for(int j = i+1; j<=tiles.size()-1;j++){
					if(tiles.get(i).getRow() == tiles.get(j).getRow()+1 || tiles.get(i).getRow() == tiles.get(j).getRow()-1){
						if(tiles.get(i).getColumn() == tiles.get(j).getColumn()+8 || tiles.get(i).getColumn() == tiles.get(j).getColumn()-8){
							return false;
						}
						if(tiles.get(i).getColumn() == tiles.get(j).getColumn()+10 || tiles.get(i).getColumn() == tiles.get(j).getColumn()-10){
							return false;
						}
					}
				}
			}

			count += t.getValue();
			
			// if the sum of the tiles is greater than six the move is invalid
			if(count > 6){
				return false;
			}
		}
		
		if(count == 6){
			model.updateMoves(1);
			model.updateScore();
			return true;
		}
		
		return false;
	}

}
