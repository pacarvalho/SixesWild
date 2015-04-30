package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import views.BoardView;
import views.TileView;

import model.SixesWild;
import model.SwapSpecialMove;
import model.Tile;

public class SwapController extends MouseAdapter{

	/** Stores the BoardView */
	BoardView boardView;
	
	/** Game Model */
	SixesWild model;
	
	/** First selected Tile */
	Tile tile1;
	
	/** Second selected Tile */
	Tile tile2;
	
	public SwapController(BoardView boardView, SixesWild model ){
		
		this.model = model;
		this.boardView = boardView;
		
		tile1 = null;
		tile2 = null;
		
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
				
				SwapSpecialMove move = new SwapSpecialMove(tile1,tile2,  model);
				
				//Perform
				move.doMove();
				
				// Tell the board to update itself such that changes in tiles are relfected in GUI
				boardView.updateBoardView();
				
				//clear tile
				this.tile1 = null;
				this.tile2 = null;
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
					if(tile1 == null){
						
						tile1 = tView.getTile();
						return false;
						
						}
					else if(tile1 !=  tView.getTile()){
						
						tile2 =  tView.getTile();
						return true;
					}
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