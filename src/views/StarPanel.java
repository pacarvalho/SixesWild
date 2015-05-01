package views;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author OAkyildiz
 *
 */
public class StarPanel extends JPanel{
	
	JLabel star1, star2, star3;
	
	public StarPanel(){
		
		initialize();
	}
	
	private void initialize(){
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		//addStars
	}
}
