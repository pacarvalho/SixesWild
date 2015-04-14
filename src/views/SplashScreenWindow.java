package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreenWindow extends JWindow {
	
	
	public SplashScreenWindow(JFrame f){	
		this.initializeSplash(f);
	}
	
	public void initializeSplash(JFrame window){
		//TODO  : Figure out how to access gif directly from Sixes Wild
		// Also figure out how to quit the splash window 
		window.getContentPane().add(
		    new JLabel("", new ImageIcon("/Users/katiegandomi/Documents/workspace/SixesWild/src/Bunny.gif"), SwingConstants.CENTER));
		window.setBounds(500, 150, 300, 200);
		window.setVisible(true);
		try {
		    Thread.sleep(5000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		window.getContentPane().removeAll();
	}

}
