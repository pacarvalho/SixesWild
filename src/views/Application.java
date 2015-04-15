package views;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/*
 * Top level window manager class.
 * BOUNDARY
 * 
 * Contains: SplashPanel, MenuPanel, LevelPanel
 */
public class Application extends JFrame implements IApplication{
	
	JFrame frame;
	SplashPanel splashPanel;
	GameSelectorPanel gameSelectorPanel;
	LevelSelectorPanel puzzleLevelSelectorPanel, lightningLevelSelectorPanel;
	LevelSelectorPanel eliminationLevelSelectorPanel, releaseLevelSelectorPanel;
	//LevelPanel levelPanel;
	
	public Application(){
		/* Create all Objects */
		this.frame = new JFrame();
		this.splashPanel = new SplashPanel(this.frame);
		this.gameSelectorPanel = new GameSelectorPanel(this.frame);
		this.puzzleLevelSelectorPanel = new LevelSelectorPanel(this.frame);
		this.lightningLevelSelectorPanel = new LevelSelectorPanel(this.frame);
		this.releaseLevelSelectorPanel = new LevelSelectorPanel(this.frame);
		this.eliminationLevelSelectorPanel = new LevelSelectorPanel(this.frame);
		
		/* Set Frame Attributes */
		this.frame.setTitle("SixesWild Is Wild");
		
		/* Show the wrath of the splash */
		splashPanel.showSplash();
		
		/* After splash vanishes, show the game selector menu */
		this.frame.getContentPane().add(this.gameSelectorPanel);
		this.frame.pack();
		this.frame.setVisible(true);
		
		/* Close everything when done */
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	
}
