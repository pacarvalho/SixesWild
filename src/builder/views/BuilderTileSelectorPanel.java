package builder.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import builder.model.BuilderSixesWild;
import model.SixesWild;
import model.Tile;
import views.TileView;

/**
 * Panel from which user selects which tile he intends to add to board
 * 
 * 
 * @author Paulo, Katie
 *
 */
public class BuilderTileSelectorPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5494638038395128897L;
	
	/** Parent Frame */
	JFrame frame;
	
	/** TileView Array */
	TileView tileViews[];
	
	/** Array of tiles */
	Tile tiles[];
	
	/** Current mouse adapter */
	MouseAdapter activeAdapter;
	
	/** Overall Model */
	BuilderSixesWild builder;
	
	/** Game Model */
	SixesWild model;
	
	/**
	 * Constructor
	 */
	BuilderTileSelectorPanel(JFrame frame, BuilderSixesWild builder, SixesWild model){
		
		this.frame = frame;
		this.builder = builder;
		this.model = model;
		
		// Create tile views
		if(this.model.getName() == "Release"){
			this.tileViews = new TileView[8];
			this.tiles = new Tile[8];
		} else {
			this.tileViews = new TileView[7];
			this.tiles = new Tile[7];
		}
		
		for (int i=0; i<tileViews.length; i++){
			this.tileViews[i] = new TileView();
		}

		// Create Normal Tiles and populate views
		for (int i=1; i<tiles.length; i++){
			this.tiles[i] = new Tile(i, i, 0);
			this.tileViews[i].setTile(this.tiles[i]);
		}
		
		// Wall Tile
		this.tiles[0] = new Tile(-1,0,0);
		this.tiles[0].setSelectedFlag(true); // Wall tile starts selected
		this.builder.setTile(this.tiles[0]);
		this.tileViews[0].setTile(this.tiles[0]);
		
		// Container Tile
		if(this.model.getName() == "Release"){
			this.tiles[7] = new Tile(0,7,0);
			this.tileViews[7].setTile(this.tiles[7]);
		}
		
		// Place tileViews in appropriate locations
		this.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i=0; i<tileViews.length; i++){
			c.gridx = i;
			c.gridy = 0;
			
			this.add(this.tileViews[i], c);
		}
		
	}
	
	/**
	 * Return the tileViews
	 */
	public TileView[] getTileViews(){
		return this.tileViews;
	}
	
	/** 
	 * Properly register new listener (and unregister old one if present). 
	 */
	public void setActiveAdapter(MouseAdapter ma) {
		this.removeMouseListener(activeAdapter);
		this.removeMouseMotionListener(activeAdapter);
		this.activeAdapter = ma;
		if (ma != null) { 
			this.addMouseListener(ma);
			this.addMouseMotionListener(activeAdapter);
		}
	}
	
	
	
	
}
