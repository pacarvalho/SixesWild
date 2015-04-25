package builder.views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import controllers.ExitController;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.DefaultComboBoxModel;

import views.BoardView;
import views.IApplication;
import model.SixesWild;

/*
 * 
 */

public class BuilderPanel extends JPanel implements IApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5020862675511089854L;
	
	JFrame frame;
	SixesWild model;
	
	
	int h=120,w=190;
	// the constructor takes in model
	public BuilderPanel(JFrame frame){
		super();
		
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(5*w, 5*h));
		
		this.initialize();
		 
	}
	
	
	
	void initialize(){
		// ***********************
		// *****Create Labels*****
		// ***********************
		// Title Label
		
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		//File name Label 
		JLabel lblfilename = new JLabel("fileName");
		
		// X: Label
		JLabel lblX = new JLabel("X : ");
		
		// Y: Label
		JLabel lblY = new JLabel("Y : ");
		
		// TimeLimit Label
		JLabel lblTimeLimit = new JLabel("Time Limit : ");
		
		// ScoreLimit Label
		JLabel lblScoreLimit = new JLabel("Score Limit : ");
		
		// Probability Labels
		JLabel lblProbabilityOf1 = new JLabel("Probability of 1 : ");
		JLabel lblProbabilityOf2 = new JLabel("Probability of 2 : ");
		JLabel lblProbabilityOf3 = new JLabel("Probability of 3 : ");
		JLabel lblProbabilityOf4 = new JLabel("Probability of 4 : ");
		JLabel lblProbabilityOf5 = new JLabel("Probability of 5 : ");
		JLabel lblProbabilityOf6 = new JLabel("Probability of 6 : ");
		
		// ***********************
		// ****Create Buttons*****
		// ***********************
		// Menu Button
		ExitController exitController = new ExitController(this);
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(exitController);
		
		// New Button
		JButton btnNew = new JButton("New");
		
		// Load Button
		JButton btnOpen = new JButton("Load");
		
		// Save Button
		JButton btnSave = new JButton("Save");
		
		// Review Button
		JButton btnReview = new JButton("Review");
		
		// Undo Button
		JButton btnUndo = new JButton("Undo");
		
		// ***********************
		// ***Create TextFields***
		// ***********************
		// X: Text Fields
		JTextField xTextField = new JTextField();
		xTextField.setColumns(5);
		
		// Y: Text Fields
		JTextField yTextField = new JTextField();
		yTextField.setColumns(5);
		
		// TimeLimit TextFields
		JTextField timeLimitText = new JTextField();
		timeLimitText.setColumns(5);
		
		// ScoreLimit TextFields
		JTextField scoreLimitText = new JTextField();
		scoreLimitText.setColumns(5);
		
		// ***********************
		// ****Create Sliders*****
		// ***********************
		// Create Sliders
		JSlider slider_1 = new JSlider();
		JSlider slider_2 = new JSlider();
		JSlider slider_3 = new JSlider();
		JSlider slider_4 = new JSlider();
		JSlider slider_5 = new JSlider();
		JSlider slider_6 = new JSlider();
		
		// ***********************
		// *****Create Misc*******
		// ***********************
		// Create Board View
		BoardView boardView = new BoardView(this.frame);
		
		// Create Drop Down Menu 
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Mode"}));
		
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
		
		// Place Drop down menu
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		this.add(comboBox, c);
		
		// Place file name Label 
		c.gridx = 2;
		c.gridy = 1;
		c.gridwidth = 2;
		this.add(lblfilename, c);
		
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
		this.add(btnReview, c);
		
		// Place Review Button
		c.gridx = 4;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(btnUndo, c);
		
		// Place X: Label
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblX, c);
		
		// Place Y: Label
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblY, c);
		
		// Place X: TextField
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(xTextField, c);
		
		// Place Y: TextField
		c.gridx = 3;
		c.gridy = 3;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(yTextField, c);
		
		// Place TimeLimit Label
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblScoreLimit, c);
		
		// Place ScoreLimit Label
		c.gridx = 2;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblTimeLimit, c);
		
		// Place TimeLimit TextField
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(timeLimitText, c);
		
		// Place ScoreLimit TextField
		c.gridx = 3;
		c.gridy = 4;
		c.gridwidth = 1;
		c.ipady = 3; 
		this.add(scoreLimitText, c);
		
		// Place Probability Label 1
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf1, c);
		
		// Place Probability Label 2
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf2, c);
		
		// Place Probability Label 3
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf3, c);
		
		// Place Probability Label 4
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf4, c);
		
		// Place Probability Label 5
		c.gridx = 0;
		c.gridy = 9;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf5, c);
		
		// Place Probability Label 6
		c.gridx = 0;
		c.gridy = 10;
		c.gridwidth = 1;
		c.ipady = 25; 
		this.add(lblProbabilityOf6, c);
		
		//Place Slider 1
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_1, c);
		
		//Place Slider 2
		c.gridx = 1;
		c.gridy = 6;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_2, c);
		
		//Place Slider 3
		c.gridx = 1;
		c.gridy = 7;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_3, c);
		
		//Place Slider 4
		c.gridx = 1;
		c.gridy = 8;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_4, c);
		
		//Place Slider 5
		c.gridx = 1;
		c.gridy = 9;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_5, c);
		
		//Place Slider 6
		c.gridx = 1;
		c.gridy = 10;
		c.gridwidth = 4;
		c.ipady = 25; 
		this.add(slider_6, c);		

	}
	
	

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
