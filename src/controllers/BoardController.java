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
	
	/** Stores the BoardView */
	BoardView boardView;
	
	/** Game Model */
	SixesWild model;
	
	/** List of selected tiles */
	ArrayList<Tile> selectedTiles;
	
	/**
	 * Constructor 
	 * 
	 * @param boardView
	 * @param model
	 */
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
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TileView tView = boardView.getTileView(i, j);
				if(tView.isSelected(me.getX(), me.getY()) && !selectedTiles.contains(tView.getTile())){
					this.selectedTiles.add(tView.getTile());
					tView.getTile().setSelectedFlag(true);
					tView.update();
				}
			}
		}
	}
	
	/**
	 * Determines when the user has finished selecting tiles
	 * 
	 * Once this even it triggered we call the doMove(). Notice that there are two
	 * different types of move decided by instanceof.
	 */
	public void mouseReleased(MouseEvent me){
		IMove move;
		
		for (Tile t: this.selectedTiles){
			t.setSelectedFlag(false);
		}
		
		if(model instanceof EliminationGame){
			move = new EliminationMove(selectedTiles, model);
		} else {
			move = new Move(selectedTiles, model);
		}
		
		// Perform the move
		move.doMove();
		
		// Tell the board to update itself such that changes in tiles are relfected in GUI
		boardView.updateBoardView();
		
		// Empty the list of tiles
		this.selectedTiles.clear();
	}	

}
