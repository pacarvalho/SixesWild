package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import model.Move;
import model.SixesWild;
import model.Tile;
import views.BoardView;

public class BoardController extends MouseAdapter {
	
	BoardView boardView;
	SixesWild model;
	ArrayList<Tile> selectedTiles;
	
	public BoardController(BoardView boardView, SixesWild model){
		this.boardView = boardView;
		this.model = model;
		this.selectedTiles = new ArrayList<Tile>();
	}
	
	public void mouseDragged(MouseEvent me) {
		// Something something...
		// Loop through tileViews in board View and find out which tiles have been
		// selected and add to an ArrayList<Tiles>
		// Each tile should know where in the board it is located
	}
	
	public void mouseReleased(MouseEvent me){
		Move move = new Move(selectedTiles, model.getBoard());
		// move.doMove();
		// boardView.updateBoardView(model.board);
	}	

}
