package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import views.BoardView;
import views.TileView;
import model.DestroyTileSpecialMove;
import model.SixesWild;
import model.Tile;

public class DestroyTileController extends MouseAdapter{

	/** Stores the BoardView */
	BoardView boardView;
	
	/** Game Model */
	SixesWild model;
	
	/**Selected Tile */
	Tile tile;
	
	public DestroyTileController(BoardView boardView, SixesWild model ){
		
		this.model = model;
		this.boardView = boardView;
		
		tile = null;
		
	}
	/**
	 * Selects the clicked tile and performs the move if ready
	 * 
	 * 
	 */
	@Override
	public void mouseClicked(MouseEvent me){
		if(this.isActive()){
			if(this.selectTile(me.getX(), me.getY())){
				
				DestroyTileSpecialMove move = new DestroyTileSpecialMove(tile, model);
				
				//Perform
				move.doMove();
				
				// Tell the board to update itself such that changes in tiles are relfected in GUI
				boardView.updateBoardView();
				
				//clear tile
				this.tile=null;
				this.unregister();
				//ChangeListener
			}
		}
	}
	//TODO rightClick to cancel change controller

	private boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	
	}
	
	private boolean selectTile(int clickX, int clickY){
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TileView tView = boardView.getTileView(i, j);
				if(tView.isSelected(clickX, clickY)){
					this.tile=tView.getTile();
					return true;
				}
			}
		}
		//no tile selected
		return false;	
	}
	
	public void register(){
		
	}

	
	public void unregister(){
		
	}
	
}