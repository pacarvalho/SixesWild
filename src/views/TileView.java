package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TileView extends JPanel{
	
	public TileView(){
		
		this.add(new JLabel("", new ImageIcon("src/Bunny.gif"), SwingConstants.CENTER));
	}
}