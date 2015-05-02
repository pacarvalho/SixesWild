package builder.model;

import views.TileView;
import model.Tile;

/**
 * 
 * @author Katie, Paulo
 *
 */
public class BuilderSixesWild {
	
	/** 
	 * Tile to be added
	 * 
	 * Stores the prototype tile that will be added to the board in the builder.
	 */
	Tile toBeAddedTile;
	
	public BuilderSixesWild(){
		
	}

	/**
	 * Sets the tile
	 * 
	 * @param t
	 */
	public void setTile(Tile t) {
		this.toBeAddedTile = t;
		
	}
	
	/**
	 * Gets the tile
	 */
	public Tile getTile() {
		return this.toBeAddedTile;
		
	}
	
}






