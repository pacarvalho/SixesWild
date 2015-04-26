package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Tile;

public class TileView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 964151512745429204L;
	
	/**
	 * Tile that belongs to this tileView
	 */
	Tile tile;
	
	/**
	 * Constructor for creating a TileView for null tile
	 */
	public TileView(){
		
	}
	
	/**
	 * Sets the TileView tile
	 * 
	 * @param tile
	 */
	public void setTile(Tile tile){
		this.tile = tile;
		
	}
	
	/**
	 * Returns the TileView tile
	 * 
	 * @return Tile
	 */
	public Tile getTile(){
		return this.tile;
	}
	
	/**
	 * Updates the TileView to reflect current state
	 */
	public boolean update(){
		if (this.tile.getValue() == 1){
			this.add(new JLabel("", new ImageIcon("resources/1Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 2) {
			this.add(new JLabel("", new ImageIcon("resources/2Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 3) {
			this.add(new JLabel("", new ImageIcon("resources/3Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 4) {
			this.add(new JLabel("", new ImageIcon("resources/4Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 5) {
			this.add(new JLabel("", new ImageIcon("resources/5Tile.gif"), SwingConstants.CENTER));
		} 
		
		return true;
	}
	
	
}
