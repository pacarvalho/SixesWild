package builder.views;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import builder.controllers.BuilderBoardController;
import builder.controllers.LoadLevelController;
import builder.controllers.RedoController;
import builder.controllers.ResetBoardController;
import builder.controllers.SaveLevelController;
import builder.controllers.SelectedTileController;
import builder.controllers.SliderController;
import builder.controllers.UndoController;
import builder.controllers.chanceMultiplierController;
import builder.controllers.maxMoveController;
import builder.controllers.scoreLimitController;
import builder.controllers.timeLimitController;
import builder.model.BuilderSixesWild;
import builder.controllers.ExitController;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JSlider;
import views.BoardView;
import views.IApplication;
import model.Board;
import model.SixesWild;

/*
 * 
 */
/**
 * View class for the Builder
 * 
 * @author Anurag, Katie, OAkyildiz
 *
 */
public class BuilderPanel extends JPanel implements IApplication {

	/** Serial ID */
	private static final long serialVersionUID = -5020862675511089854L;
	
	
	/** Parent Frame */
	JFrame frame;
	
	/** Game Model*/
	SixesWild model;
	
	/** Height and Width of the panel */
	int h = 140, w = 210;
	
	/** Overall Builder Model */
	BuilderSixesWild builder;
	
	/**
	 * Constructor
	 * 
	 * @param frame
	 * @param model
	 */
	public BuilderPanel(JFrame frame, SixesWild model){
		super();
		
		this.model = model;
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(5*w, 5*h));
		
		// Make the builder model
		this.builder = new BuilderSixesWild();
		
		// Create a default board
		Board board = new Board();
		board.createDefaultBoard();
		this.model.initialize(board);
		
		// Initialize the view
		this.init();
		 
	}
	
	/**
	 * Initializes the view
	 */
	public void init(){
		// ***********************
		// *****Create Labels*****
		// ***********************
		// Title Label
		JLabel lblLevelBuilder = new JLabel(model.getName() + " Level Builder");
		lblLevelBuilder.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		// TimeLimit Label
		JLabel lblTimeLimit = new JLabel("Time Limit : ");
		
		// ScoreLimit Label
		JLabel lblScoreLimit = new JLabel("Score Limit : ");
		
		// ChanceOfMultiplier Label
		JLabel lblChance = new JLabel("Mulitplier Chance : ");
		
		//MaxMove Label
		JLabel lblMaxMove = new JLabel("Max Moves : ");
		
		// Probability of Tile Labels
		JLabel lblProbabilityOf1 = new JLabel("Probability of 1 : ");
		JLabel lblProbabilityOf2 = new JLabel("Probability of 2 : ");
		JLabel lblProbabilityOf3 = new JLabel("Probability of 3 : ");
		JLabel lblProbabilityOf4 = new JLabel("Probability of 4 : ");
		JLabel lblProbabilityOf5 = new JLabel("Probability of 5 : ");
		
		// Chance of Multiplier Labels
		JLabel lblChanceOfMultiplier = new JLabel("Chance 2x/3x : ");
		
		// ***********************
		// ****Create Buttons*****
		// ***********************
		// Menu Button
		ExitController exitController = new ExitController(this);
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(exitController);
		
		// Reset Button
		ResetBoardController resetController = new ResetBoardController(this, this.builder, this.model);
		JButton btnNew = new JButton("Reset");
		btnNew.addActionListener(resetController);
		
		// Load Button
		LoadLevelController loadLevel = new LoadLevelController(this, this.model);
		JButton btnOpen = new JButton("Load");
		btnOpen.addActionListener(loadLevel);
		
		// Save Button
		SaveLevelController saveLevel = new SaveLevelController(this, this.model);
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(saveLevel);
		
		// Undo Button
		UndoController undoController = new UndoController(this, this.builder, this.model);
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(undoController);
		
		// Redo Button
		RedoController redoController = new RedoController(this, this.builder, this.model);
		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(redoController);
		
		// ***********************
		// ***Create TextFields***
		// ***********************
		
		// TimeLimit TextFields and bind to their controllers
		JTextField timeLimitText = new JTextField(this.model.getBoard().getTimeLimit() + ""); // Integer is cast to string to display
		timeLimitController timeController = new timeLimitController(this, this.builder, this.model, timeLimitText); // Controller
		timeLimitText.addActionListener(timeController);
		timeLimitText.setColumns(5);
		
		
		// ScoreLimit TextFields
		JTextField scoreLimitText = new JTextField(this.model.getBoard().getScoreLimit() + "");
		scoreLimitController scoreController = new scoreLimitController(this, this.builder, this.model, scoreLimitText); // Controller
		scoreLimitText.addActionListener(scoreController);
		scoreLimitText.setColumns(5);
		
		// chanceOfMultiplier TextField
		JTextField chanceMultiplier = new JTextField(this.model.getBoard().getChanceMultiplierFrequency() + "");
		chanceMultiplierController multiController = new chanceMultiplierController(this, this.builder, this.model, chanceMultiplier); // Controller
		chanceMultiplier.addActionListener(multiController);
		chanceMultiplier.setColumns(5);
		
		// MaxMove TextField
		JTextField maxMove = new JTextField(this.model.getBoard().getMaxMoves() + "");
		maxMoveController maxMoveController = new maxMoveController(this, this.builder, this.model, maxMove);// Controller
		maxMove.addActionListener(maxMoveController);
		maxMove.setColumns(5);
		
		// ***********************
		// ****Create Sliders*****
		// ***********************
		// Create Sliders
		//TODO : Better array of sliders implementation
		JSlider slider_1 = new JSlider(1, 10, this.model.getBoard().getFrequency(0));
		JSlider slider_2 = new JSlider(1, 10, this.model.getBoard().getFrequency(1));
		JSlider slider_3 = new JSlider(1, 10, this.model.getBoard().getFrequency(2));
		JSlider slider_4 = new JSlider(1, 10, this.model.getBoard().getFrequency(3));
		JSlider slider_5 = new JSlider(1, 10, this.model.getBoard().getFrequency(4));
		
		// Create Multiplier Frequency Slider
		JSlider slider_x = new JSlider(1, 10, this.model.getBoard().get2x3xFrequency(0));
		
		JSlider sliders[] = {slider_1, slider_2, slider_3, slider_4, slider_5, slider_x};
		
		SliderController sliderController = new SliderController(this, this.builder, this.model, sliders); // Controller
		
		slider_1.addChangeListener(sliderController);
		slider_2.addChangeListener(sliderController);
		slider_3.addChangeListener(sliderController);
		slider_4.addChangeListener(sliderController);
		slider_5.addChangeListener(sliderController);
		slider_x.addChangeListener(sliderController);
	
		
		// **************************
		// ***** Create Board *******
		// **************************
		// Create Board View and bound it to controller
		BoardView boardView = new BoardView(this.frame, this.model);
		
		BuilderBoardController boardController = new BuilderBoardController(boardView, this.builder, this.model);
		boardView.setActiveAdapter(boardController);
		
		// ****************************************
		// ***** Create Tile Selector Panel *******
		// ****************************************
		// And bind it to controller
		BuilderTileSelectorPanel tileSelector = new BuilderTileSelectorPanel(this.frame, this.builder, this.model);
		SelectedTileController selectedTileController = new SelectedTileController(tileSelector, this.builder);
		tileSelector.setActiveAdapter(selectedTileController);
		
		// **************************
		// ***** Create Bunny*******
		// **************************
		JLabel bunny = new JLabel("", new ImageIcon("resources/BunnyBuilder.gif"), SwingConstants.CENTER);

		// ***********************
		// ****LAYOUT SET-UP !****
		// ***********************
		
		// Place buttons on correct locations
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
				
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		// Place Title
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 8;
		this.add(lblLevelBuilder, c);
		
		// Place menu button 
		c.gridx = 9; // Column 
		c.gridy = 1; // Row
		c.gridwidth = 1; 
		this.add(btnMenu, c);
		
		// NOTE THAT THE WAY WE PLACE THE BOARD
		// APPEARS TO DISTORT THE SIZE OF CELLS (3,3) & (4,3)
		// Place the Board (VERY IMPORTANT!!!)
		c.gridx = 5;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 10;
		this.add(boardView, c);
		
		// Place New button
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(btnNew, c);
		
		// Place Load Button
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		this.add(btnOpen, c);
		
		// Place Save Button
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(btnSave, c);
		
		// Place Review Button
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(btnUndo, c);
		
		// Place Review Button
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(btnRedo, c);
		
		// Place ScoreLimit Label
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblScoreLimit, c);
		
		// Place TimeLimit Label
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblTimeLimit, c);
		
		// Place Chance of Multiplier Label
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblChance, c);
		
		// Place Max Move Label
		c.gridx = 2;
		c.gridy = 5;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblMaxMove, c);
		
		// Place ScoreLimit TextField
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(scoreLimitText, c);
		
		// Place TimeLimit TextField
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(timeLimitText, c);
		
		//Enable and disable the Lightning Text Field depending on game type
		if(this.model.getName() != "Lightning"){
			timeLimitText.setEnabled(false);
		} else {
			timeLimitText.setEnabled(true);
		}
		
		// Place  Chance of Multiplier TextField
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(chanceMultiplier, c);
		
		// Place  MaxMove TextField
		c.gridx = 3;
		c.gridy = 5;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(maxMove, c);
		
		if(this.model.getName() == "Lightning"){
			maxMove.setEnabled(false);
		} else {
			maxMove.setEnabled(true);
		}
		
		// Place Probability Label 1
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf1, c);
		
		// Place Probability Label 2
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf2, c);
		
		// Place Probability Label 3
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf3, c);
		
		// Place Probability Label 4
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf4, c);
		
		// Place Probability Label 5
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf5, c);
		
		// Place Chance of Multiplier Label
		c.gridx = 0;
		c.gridy = 11;
		c.gridwidth = 1;
		c.ipady = 15; 
		this.add(lblChanceOfMultiplier, c);
		
		
		//Place Slider 1
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_1, c);
		
		//Place Slider 2
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_2, c);
		
		//Place Slider 3
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_3, c);
		
		//Place Slider 4
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_4, c);
		
		//Place Slider 5
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_5, c);
		
		//Place Multiplier Slider
		c.gridx = 1;
		c.gridy = 11;
		c.gridwidth = 4;
		c.ipady = 15; 
		this.add(slider_x, c);
		
		// Add TileSelectorPanel
		c.gridx = 2;
		c.gridy = 15;
		c.gridwidth = 5;
		c.ipady = 25;
		this.add(tileSelector, c);
		
		// Add Bunny
		c.gridx = 9;
		c.gridy = 15;
		c.gridwidth = 1;
		c.ipady = 0;
		this.add(bunny, c);

	}
	
	
	/**
	 * Returns the JFrame
	 */
	@Override
	public JFrame getFrame() {
		return this.frame;
	}
	
	/** 
	 * Updates all parameters from the model
	 * 
	 * Usually called after a new board is loaded
	 */
	public boolean updateParameters(){
		this.removeAll();
		
		this.init();
		
		this.validate();
		
		return true;
	}
}
