package views;

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
		this.frame.getContentPane().add(
		    new JLabel("", new ImageIcon("src/Bunny.gif"), SwingConstants.CENTER));
		this.frame.setBounds(500, 150, 300, 200);
		this.frame.setVisible(true);
		try {
		    Thread.sleep(2000);
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
