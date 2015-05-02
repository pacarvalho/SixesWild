package builder.controllers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import builder.model.BuilderSixesWild;
import builder.views.BuilderTileSelectorPanel;
import views.TileView;

/**
 * Selects the tile in the tileSelector that has been clicked.
 * 
 * @author Paulo, Katie
 *
 */
public class SelectedTileController extends MouseAdapter{
	
	/** Stores the JPanel */
	BuilderTileSelectorPanel tileSelector;
	
	/** Stores the TileViews */
	TileView tileViews[];
	
	/** Stores the model */
	BuilderSixesWild builder;
	
	/**
	 * 
	 * @param tileSelector
	 */
	public SelectedTileController(BuilderTileSelectorPanel tileSelector, BuilderSixesWild builder){
		this.tileSelector = tileSelector;
		this.tileViews = tileSelector.getTileViews();
		this.builder = builder;
		
	}
	
	/**
	 * Marks the selected tile as selected
	 */
	@Override
	public void mouseClicked(MouseEvent me){
		for (TileView t: this.tileViews){
			
			if (t.isSelected(me.getX(), me.getY())){
				t.getTile().setSelectedFlag(true);
				
				// Update the model
				this.builder.setTile(t.getTile());
				
			} else {
				t.getTile().setSelectedFlag(false);
			}
			
			t.update();
		}
	}

	
}
