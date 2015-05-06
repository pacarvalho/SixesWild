package views;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import model.SixesWild;

/**
 * Panel for the stars
 * @author OAkyildiz
 *
 */
public class StarPanel extends JPanel{
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1454068787628241271L;
	
	/** Labels for stars */
	JLabel[] stars = new JLabel[3];
	
	/** Time boolean */
	boolean time;
	
	/** Game Model */
	SixesWild model;
	
	/** Yellow star */
	static final Icon onStar = new ImageIcon("resources/Star.gif");
	
	/** Shaded star */
	static final Icon offStar = new ImageIcon("resources/NStar.gif");
	
	/**
	 * Constructor
	 * 
	 * @param model
	 */
	public StarPanel(SixesWild model){
		
		this.model = model;
		//time = model instanceof LightningGame; 
		
		
		initialize();
		
		
	}
	
	/**
	 * Initialize the star panel
	 */
	private void initialize(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		for(int m=0; m<3; m++ ){
			stars[m] = new JLabel("", offStar, SwingConstants.CENTER);
			this.add(stars[m]);
		}
			
	}
	
	/**
	 * Update the status of the stars
	 * 
	 * @param toggle
	 */
	public void updateStars(int toggle){
		
		if((toggle & SixesWild.FIRST) == SixesWild.FIRST)
			toggleStar(0);
		
		if((toggle & SixesWild.SECOND) == SixesWild.SECOND)
			toggleStar(1);
		
		if((toggle & SixesWild.SECOND) == SixesWild.SECOND)
			toggleStar(2);
	}
	
	/**
	 * Toggle the state of a given star
	 * 
	 * @param i
	 */
	private void toggleStar(int i) {
		
		if(stars[i].getIcon() == offStar)
			stars[i].setIcon(onStar);
		else
			stars[i].setIcon(offStar);
		
		stars[i].repaint();
	}

	
}