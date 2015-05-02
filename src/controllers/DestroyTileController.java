package controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



import views.BoardView;
import views.TileView;
import model.DestroyTileSpecialMove;
import model.SixesWild;
import model.Tile;
/**
 * Handles the mouse events for DestroyTile  which is activated by button click.
 * Creates, validates and realizes the move.
 * 
 * @author OAkyildiz
 *
 */
public class DestroyTileController extends MouseAdapter{

	/** Stores the BoardView */
	BoardView boardView;
	
	/** Game Model */
	SixesWild model;
	
	/**Selected Tile */
	Tile tile;
	
	
	/**
	 * Constructor
	 * 
	 * @param boardView
	 * @param model
	 */
	public DestroyTileController(BoardView boardView, SixesWild model ){
		
		this.model = model;
		this.boardView = boardView;
		
		this.tile = null;
		
	}
	/**
	 * Selects a tile on mouse press.
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent me){
		if (me.getModifiers() == MouseEvent.BUTTON3_MASK) { 
			tile.setSelectedFlag(false);
			boardView.updateBoardView();
			this.unregister();
			return;
			
		}
		else this.selectTile(me.getX(), me.getY());
	}
	/**
	 * On mouse press performs the move if ready
	 * On right click, Cancels the move and switches to boardView MouseAdatper
	 * 
	 */
	@Override
	public void mouseReleased(MouseEvent me){
		
		// cancel move on right click)
	
		
		if(tile != null){
			System.out.println("Tile selected");
			DestroyTileSpecialMove move = new DestroyTileSpecialMove(tile, this.model);
				
			//Perform and update remaining moves
			move.doMove();
			model.setSpecQuotas(1, -1);
				
			// Tell the board to update itself such that changes in tiles are relfected in GUI
			boardView.updateBoardView();
				
			//clear tile
			
			

			//Change MosueAdapter
			this.unregister();
		}
		
	}
	
	/**
	 * Tries to select a tile on mouseClicked location
	 * 
	 * @param clickX
	 * @param clickY
	 * @return
	 */
	private boolean selectTile(int clickX, int clickY){
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TileView tView = boardView.getTileView(i, j);
				if(tView.isSelected(clickX, clickY)){
					this.tile=tView.getTile();
					tView.getTile().setSelectedFlag(true);
					tView.update();
					return true;
				}
			}
		}
		//no tile selected
		return false;	
	}
	/**
	 * Activates this mouse adapter to create move
	 */
	public void register(){
		boardView.setActiveAdapter(this);
	}
	/**
	 * switches to boardView MouseAdatper
	 */
	 
	public void unregister(){
		boardView.setActiveAdapter(new BoardController(boardView, model));
	}
	
}