package views;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import controllers.ExitController;

import javax.swing.SwingConstants;

/*
 * 
 */
public class LevelPanel extends JPanel implements IApplication{
	
	JFrame frame;
	
	public LevelPanel(JFrame frame, String title, String levelTitle){
		super();
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(800, 700));
		
		/*
		 * Create title, subtitle, timer, score labels and bind them to their controllers
		 */
		JLabel lblTitle = new JLabel(title + " Mode");
		lblTitle.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 40));
		
		JLabel lblLevel = new JLabel(levelTitle);
		lblLevel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 25));
		
		JLabel lblTime = new JLabel("time");
		
		JLabel lblScore = new JLabel("score");
		
		/* 
		 * Create button to return to main menu and bind it to its controller
		 */
		JButton btnMenu = new JButton("Menu");
		ExitController exitController = new ExitController(this);
		btnMenu.addActionListener(exitController);
		
		/*
		 * Create special move buttons and bind them to their controllers
		 */
		JButton btnSpecial3 = new JButton("S3");
		
		JButton btnSpecial2 = new JButton("S2");
		
		JButton btnSpecial1 = new JButton("S1");
		
		/*
		 * Create the board and make it appear
		 */
		BoardView boardView = new BoardView(this.frame);
		
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
		c.gridwidth = 12;
		this.add(lblTitle, c);
		
		// Place Level label
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 12;
		this.add(lblLevel, c);
		
		// Place Timer
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 15; // Height in px
		this.add(lblTime, c);
		
		// Place Score
		c.gridx = 11;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 15; // Height in px
		this.add(lblScore, c);
		
		// NOTE THAT THE WAY WE PLACE THE BOARD
		// APPEARS TO DISTORT THE SIZE OF CELLS (3,3) & (4,3)
		// Place the Board (VERY IMPORTANT!!!)
		c.gridx = 2;
		c.gridy = 3;
		c.gridwidth = 9;
		this.add(boardView, c);
		
		// Place Menu Button
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		this.add(btnMenu, c);
		
		// Place Special Move Button 1
		c.gridx = 11;
		c.gridy = 4;
		c.gridwidth = 1;
		this.add(btnSpecial1, c);
		
		// Place Special Move Button 2
		c.gridx = 12;
		c.gridy = 4;
		c.gridwidth = 1;
		this.add(btnSpecial2, c);
		
		// Place Special Move Button 3
		c.gridx = 13;
		c.gridy = 4;
		c.gridwidth = 1;
		this.add(btnSpecial3, c);

	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
