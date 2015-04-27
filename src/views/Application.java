package views;

import javax.swing.JFrame;

/**
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
	
	/** Parent Frame */
	JFrame frame;
	
	/** Splash Panel */
	SplashPanel splashPanel;
	
	/** Game Selector Panel */
	GameSelectorPanel gameSelectorPanel;
	
	/** 
	 * Constructor
	 */
	public Application(){
		/* Create all Objects */
		this.frame = new JFrame();
		this.splashPanel = new SplashPanel(this.frame);
		this.gameSelectorPanel = new GameSelectorPanel(this.frame);
		

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
