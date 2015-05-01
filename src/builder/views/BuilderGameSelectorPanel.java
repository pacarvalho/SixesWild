package builder.views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import builder.controllers.ChooseBuilderGameController;
import views.IApplication;
import controllers.ChooseGameController;
import model.SixesWild;

public class BuilderGameSelectorPanel extends JPanel implements IApplication{
	
	JFrame frame;
	
	public BuilderGameSelectorPanel(JFrame frame){
		this.frame = frame;
		
		this.frame.setPreferredSize(new Dimension(500, 400));
		setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		
		JLabel lblTitle = new JLabel("Choose a Game Mode : ");
		lblTitle.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 30));
		
		/*
		 * Create the buttons
		 */
		JButton btnPuzzle = new JButton("Puzzle");
		JButton btnLightning = new JButton("Lightning");
		JButton btnRelease = new JButton("Release");
		JButton btnElimination = new JButton("Elimination");
		
		/*
		 * Create the choose game controller
		 */
		ChooseBuilderGameController gameController = new ChooseBuilderGameController(this, btnPuzzle, 
				btnLightning, btnRelease, btnElimination);
		
		/*
		 * Bind the buttons to their controllers
		 */
		btnPuzzle.addActionListener(gameController);
		btnLightning.addActionListener(gameController);
		btnRelease.addActionListener(gameController);
		btnElimination.addActionListener(gameController);
		
		// Place buttons on correct locations
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		// Place Title
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(lblTitle, c);
		
		// Place level buttons
		// Puzzle
		c.gridx = 0; // Column 
		c.gridy = 2; // Row
		c.gridwidth = 1; // Number of columns it spans
		c.ipady = 40; // Height in px
		this.add(btnPuzzle, c);
		
		// Lightning
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLightning, c);
		
		// Release
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnRelease, c);
		
		// Elimination
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnElimination, c);
	}
	/**
	 * 
	 */
	@Override
	public JFrame getFrame() {
		return this.frame;
	}

}
