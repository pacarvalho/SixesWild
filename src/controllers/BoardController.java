package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.EliminationGame;
import model.IMove;
import model.Move;
import model.SixesWild;
import model.Tile;
import model.EliminationMove;
import views.BoardView;
import views.TileView;

/**
 * Heart of the software. 
 * 
 * Determines which tiles have been selected, calls the appropriate move class. 
 * 
 * @author Paulo, Katie
 *
 */
public class BoardController extends MouseAdapter {
	
	BoardView boardView;
	SixesWild model;
	ArrayList<Tile> selectedTiles;
	
	public BoardController(BoardView boardView, SixesWild model){
		this.boardView = boardView;
		this.model = model;
		this.selectedTiles = new ArrayList<Tile>();
	}
	
	/**
	 * Determines which tiles have been selected
	 * 
	 * Loop through tileViews in board View and find out which tiles have been
	 * selected and add to an ArrayList<Tiles>
	 * Each tile should know where in the board it is located
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		String s = "Mouse Drag: " + me.getX() + ", " + me.getY();
		System.out.println(s);
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TileView tView = boardView.getTileView(i, j);
				if(tView.isSelected(me.getX(), me.getY()) && !selectedTiles.contains(tView.getTile())){
					System.out.println("Tile has been added!"); // TODO For debugging!
					this.selectedTiles.add(tView.getTile());
				}
			}
		}
	}
	
	public void mouseReleased(MouseEvent me){
		IMove move;
		
		if(model instanceof EliminationGame){
			move = new EliminationMove(selectedTiles, model);
		} else {
			move = new Move(selectedTiles, model);
		}
		
		move.doMove();
		
		boardView.updateBoardView();
		
		// Empty the list of tiles
		this.selectedTiles.clear();
	}	

}
