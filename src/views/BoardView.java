package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Board;
import model.SixesWild;
import model.Tile;

/**
 * Board View
 * 
 * Creates and places all tile views. Contains methods for updating tile views once the tiles
 * which they contain are replaced.
 * 
 * @author Katie, Paulo
 *
 */
public class BoardView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 987297049106251275L;

	/** Parent Frame */
	JFrame frame;
	
	/** Game Mode */
	SixesWild model;
	
	/** Game Board */
	Board board;
	
	/** 2D Array of TileView */
	TileView[][] tileViews = new TileView[9][9];
	
	/** Current mouse adapter */
	MouseAdapter activeAdapter;
	

	/**
	 * Constructor
	 * 
	 * @param frame
	 * @param model
	 */
	public BoardView(JFrame frame, SixesWild model){
		super();
		this.frame = frame;
		this.model = model;
		this.board = model.getBoard();
		this.activeAdapter = null;
		
		Tile[][] tileSet = this.board.getTiles();
		
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		// The boardView is made up of tileViews that remain
		// in their assigned position throughout the game and do not
		// move. Each tileView is assigned a tile and the tiles between the 
		// tileViews are free to move around
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				c.gridx = i;
				c.gridy = j;
				c.gridwidth = 1;
				
				Tile tile = tileSet[i][j];
				TileView tView = new TileView();
				tView.setTile(tile);
				tileViews[i][j] = tView;
				this.add(tileViews[i][j], c);
			}
		}
	}
	
	/**
	 * Updates the baord view
	 * 
	 * Usually called in the board controller
	 * Updates all tileView to reflect its current tile 
	 */
	public void updateBoardView(){
		Tile[][] tileSet = this.board.getTiles();
		
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				this.tileViews[i][j].setTile(tileSet[i][j]);
			}
		}
		
		this.validate();
	}
	
	/**
	 * Returns the TileView at the given array coordinates
	 * 
	 * @param i
	 * @param j
	 * @return TileView 
	 */
	public TileView getTileView(int i, int j){
		return this.tileViews[i][j];
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
