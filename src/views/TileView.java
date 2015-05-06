package views;

import java.awt.Color;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import model.Tile;

/**
 * View for the tiles.
 * 
 * Places appropriate gif depending on the value of the tile and surrounds with appropriate border.
 * 
 * @author Paulo, Katie
 *
 */
public class TileView extends JPanel{
	
	/**
	 * Serial ID for multithreading
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
		this.update();
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
	 * Returns true if the mouse Drag coordinates are within view
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isSelected(int x, int y){
		return this.getBounds().contains(new Point(x, y));
	}
	
	
	/**
	 * Updates the TileView to reflect current state
	 */
	public boolean update(){
		this.removeAll();
		
		if(this.tile == null){
			this.add(new JLabel("", new ImageIcon("resources/NullTile.gif"), SwingConstants.CENTER));
			this.setBorder(new EmptyBorder(3,3,3,3));
			
			return true; // Important!
			
		} else if (this.tile.getValue() == 1){
			this.add(new JLabel("", new ImageIcon("resources/1Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 2) {
			this.add(new JLabel("", new ImageIcon("resources/2Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 3) {
			this.add(new JLabel("", new ImageIcon("resources/3Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 4) {
			this.add(new JLabel("", new ImageIcon("resources/4Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 5) {
			this.add(new JLabel("", new ImageIcon("resources/5Tile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 6){
			this.add(new JLabel("", new ImageIcon("resources/6Tile.gif"), SwingConstants.CENTER));
			
		}  else if (this.tile.getValue() == -1) {
			this.add(new JLabel("", new ImageIcon("resources/WallTile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == 0) {
			this.add(new JLabel("", new ImageIcon("resources/ContainerTile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == -2){
			this.add(new JLabel("", new ImageIcon("resources/EliminatedTile.gif"), SwingConstants.CENTER));
			
		} else if (this.tile.getValue() == -3){
			this.add(new JLabel("", new ImageIcon("resources/ContainerTileWSix.gif"), SwingConstants.CENTER));
			
		} else {
			this.add(new JLabel("", new ImageIcon("resources/NullTile.gif"), SwingConstants.CENTER));
			return false;
		}
		
		// If the tile is selected mark it as such
		this.setBorder(null);
		if (this.tile.getSelectedFlag()){
			this.setBorder(new BevelBorder(BevelBorder.LOWERED));
			
		} else if (this.tile.getEliminatedFlag()){
			this.setBorder(new BevelBorder(BevelBorder.RAISED));
			
		} else if (this.tile.getMultiplier() == 2) { // 2X multiplier
			this.setBorder(new LineBorder(Color.blue, 3));
			
		} else if (this.tile.getMultiplier() == 3) { // 3X multiplier
			this.setBorder(new LineBorder(Color.red, 3));
			
		} else {
			this.setBorder(new EmptyBorder(3,3,3,3));
			
		}
		
		return true;
		
	}
	
	
}
