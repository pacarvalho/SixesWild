package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import model.SixesWild;
import controllers.ChooseCustomLevelController;
import controllers.ChooseLevelController;

public class LevelSelectorPanel extends JPanel implements IApplication{
	/**
	 * ID For Multithreaded runs
	 */
	private static final long serialVersionUID = -5640806150838492981L;
	
	/** Parent frame */
	JFrame frame;
	
	/** Game Model */
	SixesWild model;
	
	public LevelSelectorPanel(JFrame frame, SixesWild m) {
		
		this.frame = frame;
		this.model = m;
		
		JLabel lblSelectLevel = new JLabel(m.getName());
		lblSelectLevel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 45));
		
		JLabel lblPuzzleLevels = new JLabel("Select Level");
		
		/*
		 * Create level buttons and bind them to their controllers
		 */
		
		JButton btnLevel1 = new JButton("Level 1");
		JButton btnLevel2 = new JButton("Level 2");
		JButton btnLevel3 = new JButton("Level 3");
		JButton btnLevel4 = new JButton("Level 4");
		
		ChooseLevelController chooseLevelController = new ChooseLevelController(model, this, btnLevel1, btnLevel2,
				btnLevel3, btnLevel4);
		
		btnLevel1.addActionListener(chooseLevelController);
		btnLevel2.addActionListener(chooseLevelController);
		btnLevel3.addActionListener(chooseLevelController);
		btnLevel4.addActionListener(chooseLevelController);
		
		/*
		 * Create the choose custom level button and bind it to its controller
		 */
		JButton btnCustomLevel = new JButton("Choose Your Own!");
		ChooseCustomLevelController customController = new ChooseCustomLevelController(this.model, this);
		btnCustomLevel.addActionListener(customController);
		
		// Place buttons on correct locations
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		// Place Title
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(lblSelectLevel, c);
		
		// Place Subtitle
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		c.ipady = 25; // Height in px
		this.add(lblPuzzleLevels, c);
		
		// Place level buttons
		// Level 1
		c.gridx = 0; // Column 
		c.gridy = 2; // Row
		c.gridwidth = 1; // Number of columns it spans
		c.ipady = 40; // Height in px
		this.add(btnLevel1, c);
		
		// Level 2
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLevel2, c);
		
		// Level 3
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLevel3, c);
		
		// Level 4
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLevel4, c);
		
		// Place custom level button
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.ipady = 20;
		this.add(btnCustomLevel, c);
		
	}
	
	@Override
	public JFrame getFrame() {
		return this.frame;
	}

}
