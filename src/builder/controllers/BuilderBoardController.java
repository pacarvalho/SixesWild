package builder.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.Tile;
import builder.model.BuilderSixesWild;
import views.BoardView;
import views.TileView;

/**
 * Controls the board building by adding tiles
 * 
 * @author Katie, Paulo
 *
 */
public class BuilderBoardController extends MouseAdapter{
	
	/** Builder Model */
	BuilderSixesWild model;
	
	/** Stores the Boundary */
	BoardView boardView;
	
	/**
	 * Constructor
	 * 
	 * @param boardView
	 * @param model
	 */
	public BuilderBoardController(BoardView boardView, BuilderSixesWild model){
		this.boardView = boardView;
		this.model = model;
	}
	
	/**
	 * Adds tiles to the board upon dragging
	 */
	@Override
	public void mouseDragged(MouseEvent me){
		
		// Set selected tiles to the type that is currently selected in tileSelectorPanel
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				TileView tv = this.boardView.getTileView(i,j);
				if (tv.isSelected(me.getX(), me.getY())){
					tv.setTile(new Tile(this.model.getTile().getValue(), i, j));
					tv.update();
				}
			}
		}
		
		this.boardView.validate();
	}
}
