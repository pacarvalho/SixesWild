package views;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BoardView extends JPanel{
	
	JFrame frame;
	
	TileView[][] tiles = new TileView[9][9];
	
	public BoardView(JFrame frame){
		this.frame = frame;
		
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				tiles[i][j] = new TileView();
				this.setBounds(72*i,72*j, 72, 72);
				this.add(tiles[i][j]);
			}
		}
		
		this.frame.getContentPane().add(this);
		this.frame.pack();
	}
}
