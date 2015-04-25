package views;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

import model.SixesWild;

/*
 * Top level window manager class.
 * BOUNDARY
 * 
 * Contains: SplashPanel, MenuPanel, LevelPanel
 */
public class Application extends JFrame implements IApplication{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 508960598896593031L;
	
	JFrame frame;
	SplashPanel splashPanel;
	GameSelectorPanel gameSelectorPanel;
	LevelSelectorPanel puzzleLevelSelectorPanel, lightningLevelSelectorPanel;
	LevelSelectorPanel eliminationLevelSelectorPanel, releaseLevelSelectorPanel;
	//LevelPanel levelPanel;
	
	public Application(SixesWild m){
		/* Create all Objects */
		this.frame = new JFrame();
		this.splashPanel = new SplashPanel(this.frame);
		this.gameSelectorPanel = new GameSelectorPanel(this.frame, m);
		

		/* Set Frame Attributes */
		this.frame.setTitle("SixesWild");
		
		/* Show the wrath of the splash */
		splashPanel.showSplash();
		
		/* After splash vanishes, show the game selector menu */
		this.frame.getContentPane().add(this.gameSelectorPanel);
		this.frame.setBounds(100, 100, 1200, 1200);
		this.frame.pack();
		this.frame.setVisible(true);
		
		
		/* Close everything when done */
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}

	
}
