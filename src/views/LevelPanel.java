package views;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import controllers.BoardController;
import controllers.ExitController;
import controllers.LevelTimer;
import model.EliminationGame;
import model.LevelTracker;
import model.LightningGame;
import model.PuzzleGame;
import model.ReleaseGame;
import model.SixesWild;

/**
 * Panel where game is played.
 * 
 * @author Paulo, Katie, Sean
 *
 */
public class LevelPanel extends JPanel implements IApplication{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7240445879684423199L;
	
	/** Parent Container */
	JFrame frame;
	
	SixesWild model;
	
	BoardView boardView;
	
	SpecialButtonsPanel specialBtnsPanel;
	
	JLabel scoreView;
	
	JLabel countdownView;
	
	StarPanel starView;
	
	/**
	 * Hashmap of all components
	 * 
	 */
	private HashMap<String, Component> componentMap;
	
	/**
	 * Constructor
	 * 
	 * @param frame
	 * @param model
	 * @param title
	 * @param levelTitle
	 */
	public LevelPanel(JFrame frame, SixesWild model, String title, String levelTitle, int level){
		super();
		
		this.model = model;
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(700, 550));
		this.boardView = null;
		this.starView = new StarPanel(model);
		this.starView.setName("Star");
		this.scoreView = new JLabel(""+model.getCurrentScore());
		this.scoreView.setName("Score");
		
		//If the level is a LightningGame set up and display timer.
		if(this.model instanceof LightningGame){
	
			this.countdownView = new JLabel(""+ ((LightningGame) model).getRemainingTimeString());
			this.countdownView.setName("Timer");
			countdownView.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 25));
			LevelTimer thisTim = new LevelTimer((LightningGame) this.model, this);
			//Action listener for timer.
			((LightningGame) this.model).getTimer().addActionListener(thisTim);
			((LightningGame) this.model).getTimer().start();
		}
		//else, use move counter
		else
			this.countdownView = new JLabel(""+ model.getNumMoves());
			this.countdownView.setName("Moves");
		//Set a few fonts
		countdownView.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 24));
		this.scoreView.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 24));
		//Plug in levelView to updater
		this.model.getUpdater().setLevelView(this);
		/*
		 * Create title, subtitle, timer, score labels and bind them to their controllers
		 */
		JLabel lblTitle = new JLabel(title + " Mode");
		lblTitle.setName("Title");
		lblTitle.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 40));
		
		JLabel lblLevel = new JLabel(levelTitle);
		lblLevel.setName("Level");
		lblLevel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 25));
		
		// Deserialize Level Tracker for high score
		
		LevelTracker lt = null;
		
		try {
			lt = (LevelTracker)deserialize("resources/levels/level_tracker.txt");
			
		} catch(IOException e){
			e.printStackTrace();
			
		} catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
		
		int highScore = 0;
		
		if (lt != null && level < 5) {
			if (this.model instanceof LightningGame){
				highScore = lt.lightningScore[level-1];
				
			} else if (this.model instanceof PuzzleGame) {
				highScore = lt.puzzleScore[level-1];
				
			} else if (this.model instanceof ReleaseGame) {
				highScore = lt.releaseScore[level-1];
				
			} else if (this.model instanceof EliminationGame) {
				highScore = lt.eliminationScore[level-1];
				
			} else {
				highScore = 0;
				
			}	
		}
		
		//PRevious High score
		JLabel lblHighScore = new JLabel("HI: " + highScore); // NES games reference
		lblHighScore.setName("High Score");
		lblHighScore.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 24));
		
		
		/* 
		 * Create button to return to main menu and bind it to its controller
		 */
		JButton btnMenu = new JButton("Menu");
		btnMenu.setName("Menu");
		ExitController exitController = new ExitController(this, model, level);
		btnMenu.addActionListener(exitController);

		/*
		 * Create the board and make it appear
		 * Set up boardViews controller
		 */
		boardView = new BoardView(this.frame, model);
		boardView.setName("Board");
		BoardController boardControl = new BoardController(boardView, model);
		boardView.setActiveAdapter(boardControl);
		
		/*
		 * Place everything where they belong using a gridBagLayout
		 */
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		
		// Place Title
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 13;
		this.add(lblTitle, c);
		
		// Place Level label
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 13;
		this.add(lblLevel, c);
		
//		// Place Timer
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.EAST;
		c.ipady = 15; // Height in px
		this.add(countdownView, c);
		
		// Place Score
		c.gridx = 12;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 15; // Height in px
		c.anchor = GridBagConstraints.SOUTHEAST;
		this.add(scoreView, c);
		
		//Place HighScore
		c.gridx = 12;
		c.gridy = 4;		
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 15; // Height in px
		c.anchor = GridBagConstraints.WEST;
		this.add(lblHighScore, c);
		
		// NOTE THAT THE WAY WE PLACE THE BOARD
		// APPEARS TO DISTORT THE SIZE OF CELLS (3,3) & (4,3)
		// Place the Board (VERY IMPORTANT!!!)
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 9;
		c.gridheight = 9;
		c.anchor = GridBagConstraints.WEST;
		this.add(boardView, c);
		
		// Place Menu Button
		int menux=c.gridx+c.gridwidth;
		
		c.gridx = menux;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight =1;
		c.anchor = GridBagConstraints.NORTHEAST;
		this.add(btnMenu, c);
		
		//Place Star Panel
		c.gridx = menux;
		c.gridy = 3;
		c.gridwidth = 1;
		
		this.add(starView, c);
		
		//Listen to score
		//scoreView.addPropertyChangeListener("text",new StarUpdater(model, stars));
		
		// Place Special MovePanel
		c.gridx = menux;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight =6;
		c.anchor = GridBagConstraints.SOUTHEAST;
		add(this.getSpecialButtonsPanel(),c);
		
		// Add the buttons to the hashmap. This is to make testing easier
		createComponentMap();
	}
	
	/**
	 * Get the CountdownView.
	 * @return
	 */
	public JLabel getCountdownView() {
		return countdownView;
	}

	/**
	 * Return the Special Button Panel
	 * 
	 * @return
	 */
	public SpecialButtonsPanel getSpecialButtonsPanel(){
		if (this.specialBtnsPanel == null){
			this.specialBtnsPanel = new SpecialButtonsPanel(boardView, model);
			this.specialBtnsPanel.setName("Special");
		}	
		return this.specialBtnsPanel;	
	}
	
	/**
	 * Return the boardView
	 * 
	 * @return
	 */
	public BoardView getBoardView() {
		return this.boardView;
	}
	
	/**
	 * Return the model -- FOR TESTING ONLY
	 * 
	 * @return
	 */
	public SixesWild getModel(){
		return this.model;
	}
	
	/**
	 *  Return the starView
	 * @return
	 */
	public StarPanel getStarView() {
		return this.starView;
	}
	/**
	 *  Return the scoreView
	 * @return
	 */
	public JLabel getScoreView(){
		return this.scoreView;

	}
	/**
	 * Return the parent JFrame
	 */
	@Override
	public JFrame getFrame() {
		return this.frame;
	}
	
	/**
	 * Loads a serialized object
	 */
	public Object deserialize(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		ois.close();
		
		return obj;
	}
	
	 /**
	  * Create hashmap of components (buttons) on the panel
	  */
	 private void createComponentMap() {
	        componentMap = new HashMap<String,Component>();
	        Component[] components = this.getComponents();
	        for (int i=0; i < components.length; i++) {
	                componentMap.put(components[i].getName(), components[i]);
	        }
	}
	 
	 /**
	  * Get a component by its name
	  */

	public Component getComponentByName(String name) {
	        if (componentMap.containsKey(name)) {
	                return (Component) componentMap.get(name);
	        }
	        else return null;
	}
}
