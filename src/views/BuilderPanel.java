package views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import controllers.ExitController;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JInternalFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

import java.awt.ComponentOrientation;

import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;

import java.awt.Color;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;

/*
 * 
 */

public class BuilderPanel extends JPanel implements IApplication {

	JFrame frame;
	int h=300,w=100;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public BuilderPanel(JFrame frame){
		super();
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(7*w, 5*w));
		
		// Create Labels
		// Title Label
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		//File name Label 
		JLabel lblfilename = new JLabel("fileName");
		
		// Create Buttons
		ExitController exitController = new ExitController(this);
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(exitController);
		
		// Create Board View
		BoardView boardView = new BoardView(this.frame);
		
		// Create Drop Down Menu 
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Mode"}));
		
		
		// SET UP LAYOUT !!
		
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
		this.add(boardView, c);

	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
