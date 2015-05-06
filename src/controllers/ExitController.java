package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.SixesWild;
import views.GameSelectorPanel;
import views.IApplication;

/**
 * Controller for the Exit Button
 * 
 * Takes user from levelPanel to the GameSelectorPanel
 * 
 * @author Paulo
 *
 */
public class ExitController implements ActionListener{
	
	/** Stores Boundary */
	IApplication view;
	
	/** Stores Model */ 
	SixesWild model;
	
	/** Stores Level */
	int level;
	
	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public ExitController(IApplication view, SixesWild model, int level){
		this.view = view;
		this.model = model; 
		this.level = level;
	}
	
	/**
	 * Listener for button click. 
	 * 
	 * Changes the current JPanel to that of the GameSelector once button is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.model.updateLevelTracker(level); //When a level is closed update Level Tracker
		
		JFrame frame = this.view.getFrame();
		GameSelectorPanel gameSelectorPanel = new GameSelectorPanel(frame);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameSelectorPanel);
		frame.pack();
		
	}

}
