package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;


import controllers.BoardController;

import controllers.ExitController;

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
		this.scoreView = new JLabel(""+model.getCurrentScore());
		this.countdownView = new JLabel();
		
		this.scoreView.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 24));
		//Plug in levelView to updater
		this.model.getUpdater().setLevelView(this);
		/*
		 * Create title, subtitle, timer, score labels and bind them to their controllers
		 */
		JLabel lblTitle = new JLabel(title + " Mode");
		lblTitle.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 40));
		
		JLabel lblLevel = new JLabel(levelTitle);
		lblLevel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 25));
		
		//JLabel lblTime = new JLabel("time");
		
		
		
		/* 
		 * Create button to return to main menu and bind it to its controller
		 */
		JButton btnMenu = new JButton("Menu");
		ExitController exitController = new ExitController(this, model, level);
		btnMenu.addActionListener(exitController);
		
		/*
		 * Create special move buttons and bind them to their controllers
		 */
		// TODO: ADD HERE

		/*
		 * Create the board and make it appear
		 * Set up boardViews controller
		 */
		boardView = new BoardView(this.frame, model);
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
//		c.gridx = 0;
//		c.gridy = 2;
//		c.gridwidth = 1;
//		c.anchor = GridBagConstraints.EAST;
//		c.ipady = 15; // Height in px
//		this.add(lblTime, c);
		
		// Place Score
		c.gridx = 12;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight =1;
		c.ipady = 15; // Height in px
		c.anchor = GridBagConstraints.SOUTHEAST;
		this.add(scoreView, c);
		
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
		c.gridy = 4;
		c.gridwidth = 1;
		c.gridheight = 7;
		c.anchor = GridBagConstraints.SOUTHEAST;
		add(this.getSpecialButtonsPanel(),c);
	}
	
	/**
	 * Getter for Special Button Panel
	 * 
	 * @return
	 */
	public SpecialButtonsPanel getSpecialButtonsPanel(){
		if (this.specialBtnsPanel == null){
			this.specialBtnsPanel = new SpecialButtonsPanel(boardView, model);
		}	
		return this.specialBtnsPanel;	
	}
	
	/**
	 * G Return the boardView
	 * 
	 * @return
	 */
	public BoardView getBoardView() {
		return this.boardView;
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
}
