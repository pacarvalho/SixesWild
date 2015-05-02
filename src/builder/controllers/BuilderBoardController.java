package builder.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.SixesWild;
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
	
	/** Stores the game */
	SixesWild game;
	
	/**
	 * Constructor
	 * 
	 * @param boardView
	 * @param model
	 */
	public BuilderBoardController(BoardView boardView, BuilderSixesWild model, SixesWild game){
		this.boardView = boardView;
		this.model = model;
		this.game = game;
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
					Tile tile = new Tile(this.model.getTile().getValue(), i, j);
					tv.setTile(tile);
					
					this.game.getBoard().setTile(tile); // Update the overall board
					
					tv.update();
				}
			}
		}
		
		this.boardView.validate();
	}
	
	/**
	 * Upon mouse press save a memento
	 */
	@Override
	public void mousePressed(MouseEvent me){
		this.model.createMemento(this.game.getBoard());
	}
}
