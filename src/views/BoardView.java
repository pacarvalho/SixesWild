package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardView extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 987297049106251275L;

	JFrame frame;
	
	TileView[][] tiles = new TileView[9][9];
	
	public BoardView(JFrame frame){
		super();
		this.frame = frame;
		
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				c.gridx = i;
				c.gridy = j;
				c.gridwidth = 1;
				
				tiles[i][j] = new TileView();
				
				this.add(tiles[i][j], c);
			}
		}
		
	}
}
