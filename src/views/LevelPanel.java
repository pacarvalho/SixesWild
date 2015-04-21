package views;

import java.awt.Dimension;
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
	
	public LevelPanel(JFrame frame, String title){
		super();
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(700, 700));
		
		/*
		 * Create title, subtitle, timer, score labels and bind them to their controllers
		 */
		JLabel lblTitle = new JLabel("gameMode");
		
		JLabel lblLevel = new JLabel(title);
		
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
		c.gridwidth = 6;
		this.add(lblTitle, c);
		
		// Place Level label
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 6;
		this.add(lblLevel, c);
		
		// Place Timer
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(lblTime, c);
		
		// Place Score
		c.gridx = 5;
		c.gridy = 2;
		c.gridwidth = 1;
		this.add(lblScore, c);
		
		// Place the Board (VERY IMPORTANT!!!)
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 6;
		this.add(boardView, c);
		
		// Place Menu Button
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 1;
		this.add(btnMenu, c);
		
		
		
	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
