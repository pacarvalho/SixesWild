package controllers;

import model.SixesWild;
import views.BoardView;

public class BoardController extends java.awt.event.MouseAdapter {
	
	BoardView boardView;
	SixesWild model;
	
	public BoardController(BoardView boardView, SixesWild model){
		this.boardView = boardView;
		this.model = model;
	}
	
	public void mouseDragged(java.awt.event.MouseEvent me) {
		// Something something...
		// Loop through tileViews in board View and find out which tiles have been
		// selected and add to an ArrayList<Tiles>
		// Each tile should know where in the board it is located
	}
	
	public void mouseReleased(java.awt.event.MouseEvent me){
		// TileMove move = new Tilemove(arrayList, model.board);
		// move.doMove();
		// boardView.updateBoardView(model.board);
	}	

}
