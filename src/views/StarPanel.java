package views;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.LightningGame;
import model.SixesWild;
/**
 * 
 * @author OAkyildiz
 *
 */
public class StarPanel extends JPanel{
	
	JLabel star1, star2, star3;
	boolean time;
	
	/**Game */
	SixesWild model;
	
	/**
	 * 
	 * @param model
	 */
	public StarPanel(SixesWild model){
		
		this.model = model;
		time = model instanceof LightningGame; 
		
		JLabel earnedS = new JLabel("", new ImageIcon("resources/Star"), SwingConstants.CENTER);
		JLabel notS = new JLabel("", new ImageIcon("resources/NSTAR.gif"), SwingConstants.CENTER);
		
		initialize();
		
		
	}
	
	private void initialize(){
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		//addStars
	}
	private void addStars(){
		
	}

	public void assesScore(){
		
	}
}