package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Board;
import model.SixesWild;
import model.Tile;

public class BoardView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 987297049106251275L;

	JFrame frame;
	SixesWild model;
	Board board;
	TileView[][] tileViews = new TileView[9][9];
	
	public BoardView(JFrame frame, SixesWild model){
		super();
		this.frame = frame;
		this.model = model;
		this.board = model.getBoard();
		
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
	
	// Update Board View
	// It is called in the Board controller
	// It takes in a board object and sets its TileViews
	// with the appropriate Tiles
	public void updateBoard(Board board){
		this.board = board;
		Tile[][] tileSet = this.board.getTiles();
		
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				Tile tile = tileSet[i][j];
				tileViews[i][j].setTile(tile);
			}
		}	
	}
	
}
