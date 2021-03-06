package views;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 * Splash Panel
 * 
 * @author Katie
 *
 */
public class SplashPanel extends JWindow implements IApplication{
	
	/** ID for Multithreaded */
	private static final long serialVersionUID = 2259867932539124367L;
	
	/** Parent frame */
	JFrame frame;
	
	/**
	 * Constructor
	 * 
	 * @param frame
	 */
	public SplashPanel(JFrame frame){	
		this.frame = frame;
	}
	
	
	/**
	 * Set up Splash Window 
	 * 
	 * This method adds all atributes to the splash window
	 */
	public void showSplash(){
		/*
		 * Place image gif and credits
		 */
		JLabel image = new JLabel("", new ImageIcon("resources/Bunny.gif"), SwingConstants.CENTER);
		image.setBounds(10, 15, 100, 100);
		JLabel background = new JLabel("", new ImageIcon("resources/gradient.png"), SwingConstants.CENTER);
		background.setBounds(0, 0, 500, 500);
		JLabel credits = new JLabel("", new ImageIcon("resources/namesSplash.gif"), SwingConstants.CENTER);
		credits.setBounds(0, 40, 600, 200);
		JLabel title = new JLabel("Team Hyperion~", SwingConstants.CENTER);
		title.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 30));
		title.setBounds(0, 5, 600, 150);
		
		this.frame.setBounds(150, 170, 600, 300);
		this.frame.getContentPane().add(image);
		this.frame.getContentPane().add(title);
		this.frame.getContentPane().add(credits);
		this.frame.getContentPane().add(background);
		this.frame.setVisible(true);
		
		// Show for 5 seconds
		try {
		    Thread.sleep(4000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		this.frame.setVisible(false);
		this.frame.getContentPane().removeAll();
	}
	
	/**
	 * Returns parent JFrame
	 */
	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
