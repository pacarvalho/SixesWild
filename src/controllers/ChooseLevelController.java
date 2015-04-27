package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Board;
import model.SixesWild;
import views.IApplication;
import views.LevelPanel;

/**
 * 
 * Panel where a level is chosen. 
 * 
 * Loads the board from file and instantiates controllers responsible for starting the actual game.
 * 
 * @author Paulo, Katie, Sean
 *
 */
public class ChooseLevelController implements ActionListener{
	
	/** Buttons */
	JButton btnLevel1, btnLevel2, btnLevel3, btnLevel4;
	
	/** Game Model */
	SixesWild model;
	
	/** Parent JPanel */
	IApplication view;
	
	/** Title of the JPanel */
	String title;
	
	/**
	 * Constructor
	 * 
	 * @param m
	 * @param view
	 * @param btnLevel1
	 * @param btnLevel2
	 * @param btnLevel3
	 * @param btnLevel4
	 */
	public ChooseLevelController(SixesWild m, IApplication view, JButton btnLevel1, JButton btnLevel2,
				JButton btnLevel3, JButton btnLevel4){
		this.model = m;
		this.view = view;
		this.title = m.getName(); // Get the variation name
		
		this.btnLevel1 = btnLevel1;
		this.btnLevel2 = btnLevel2;
		this.btnLevel3 = btnLevel3;
		this.btnLevel4 = btnLevel4;
		
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		// CREATE A DEFAULT LEVEL FOR DEBUGGING
		// TODO: Implement proper level creation from de-serialization
		Board level = new Board();
		level.update(); // Populate the board
		
		if(e.getSource() == this.btnLevel1){
			// Initialize the level
			this.model.initialize(level); // TODO: Pass correct level. This is a dummy!!!
			
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title, 
					"Level 1"); //title once entity is implemented
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel2){
			// Initialize the level
			this.model.initialize(level); // TODO: Pass correct level. This is a dummy!!!
						
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title, 
					"Level 2");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel3){
			// Initialize the level
			this.model.initialize(level); // TODO: Pass correct level. This is a dummy!!!
			
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title, 
					"Level 3");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel4){
			// Initialize the level
			this.model.initialize(level); // TODO: Pass correct level. This is a dummy!!!
			
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title,
					"Level 4");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
	}
}