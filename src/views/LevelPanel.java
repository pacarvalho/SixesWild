package views;

import gandomi.FortyThievesDeckController;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridBagLayoutInfo;
import java.awt.Rectangle;
import java.io.ObjectInputStream.GetField;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import controllers.BoardController;
import controllers.ExitController;

import javax.swing.SwingConstants;

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
	SpecialButtonsPanel specialBtnsPanel;
	SixesWild model;
	
	public LevelPanel(JFrame frame, SixesWild model, String title, String levelTitle){
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

		/*
		 * Create the board and make it appear
		 */
		BoardView boardView = new BoardView(this.frame, model);
		//boardView.setMouseAdapter(new BoardController(boardView, model));
		
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
		int menux=c.gridx+c.gridwidth;
		
		c.gridx = menux;
		c.gridy = 0;
		c.gridwidth = 1;
		this.add(btnMenu, c);
		
		
		// Place Special MovePanel�
		
		c.gridx = menux-1;
		c.gridy = 4;
		c.gridwidth = 3;
		add(getSpecialButtonsPanel(),c);
	}
	
	public SpecialButtonsPanel getSpecialButtonsPanel(){
		if (specialBtnsPanel == null){
			specialBtnsPanel = new SpecialButtonsPanel(model);
		}
		return specialBtnsPanel;	
	}
	
	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
