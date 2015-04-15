package views;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/*
 * Splash Panel
 */
public class SplashPanel extends JWindow implements IApplication{
	
	JFrame frame;
	
	public SplashPanel(JFrame frame){	
		this.frame = frame;
	}
	
	public void showSplash(){
		/*
		 * Place image gif and credits
		 */
		JLabel image = new JLabel("", new ImageIcon("src/Bunny.gif"), SwingConstants.CENTER);
		image.setBounds(100, 100, 100, 100);
		JLabel credits = new JLabel("", new ImageIcon("resources/namesSplash.gif"), SwingConstants.CENTER);
		credits.setBounds(150, 300, 600, 200);
		
		this.frame.setBounds(150, 150, 600, 600);
		
		this.frame.getContentPane().add(image);
		this.frame.getContentPane().add(credits);
		this.frame.setVisible(true);
		// Show for 5 seconds
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		this.frame.setVisible(false);
		this.frame.getContentPane().removeAll();
	}
	
	@Override
	public JFrame getFrame() {
		return this.frame;
	}

}
