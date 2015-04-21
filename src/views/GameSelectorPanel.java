package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import controllers.ChooseGameController;
import controllers.StartBuilderController;

import java.awt.SystemColor;


public class GameSelectorPanel extends JPanel implements IApplication{
	JFrame frame;
	
	public GameSelectorPanel(JFrame frame){
		this.frame = frame;
		
		this.frame.setPreferredSize(new Dimension(500, 400));
		
		setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		
		JLabel lblTitle = new JLabel("Sixes Wild !");
		lblTitle.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 45));
		
		JLabel lblSelectAGame = new JLabel("Select a Game Mode");
		
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
		ChooseGameController gameController = new ChooseGameController(this, btnPuzzle, 
				btnLightning, btnRelease, btnElimination);
		
		/*
		 * Bind the buttons to their controllers
		 */
		btnPuzzle.addActionListener(gameController);
		btnLightning.addActionListener(gameController);
		btnRelease.addActionListener(gameController);
		btnElimination.addActionListener(gameController);
		
		/*
		 * Builder button. 
		 */
		JButton btnLevelBuilder = new JButton("Level Builder");
		StartBuilderController builderStartController  = new StartBuilderController(this,btnLevelBuilder);
		btnLevelBuilder.addActionListener(builderStartController);
		
		
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
		
		// Place Subtitle
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		c.ipady = 40; // Height in px
		this.add(lblSelectAGame, c);
		
		// Place level buttons
		// Puzzle
		c.gridx = 0; // Column 
		c.gridy = 2; // Row
		c.gridwidth = 1; // Number of columns it spans
		c.ipady = 40; // Height in px
		c.weightx = 1.0;
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
		
		// Place custom level button
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.ipady = 20;
		this.add(btnLevelBuilder, c);
	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
