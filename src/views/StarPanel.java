package views;

import java.awt.FlowLayout;

import javax.swing.Icon;
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
	
	JLabel[] stars = new JLabel[3];
	boolean time;
	
	/**Game */
	SixesWild model;
	
	static final Icon onStar = new ImageIcon("resources/Star.gif");
	static final Icon offStar = new ImageIcon("resources/NStar.gif");
	
	/**
	 * 
	 * @param model
	 */
	public StarPanel(SixesWild model){
		
		this.model = model;
		time = model instanceof LightningGame; 
		
		
		initialize();
		
		
	}
	
	private void initialize(){
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		if(!time){
			for(int m=0; m<3; m++ ){
				stars[m] = new JLabel("", offStar, SwingConstants.CENTER);
				this.add(stars[m]);
			}
		}
		else{
			for(int m=0; m<3; m++ ){
				stars[m] = new JLabel("", onStar, SwingConstants.CENTER);
				this.add(stars[m]);
			}
		}
			
	}
	public void updateStars(int toggle){
		
		if((toggle & SixesWild.FIRST) == SixesWild.FIRST)
			toggleStar(0);
		
		if((toggle & SixesWild.SECOND) == SixesWild.SECOND)
			toggleStar(1);
		
		if((toggle & SixesWild.SECOND) == SixesWild.SECOND)
			toggleStar(2);
	}
	
	//*toggle the given star*/
	private void toggleStar(int i) {
		
		if(stars[i].getIcon() == offStar)
			stars[i].setIcon(onStar);
		else
			stars[i].setIcon(offStar);
		
		stars[i].repaint();
	}

	
}