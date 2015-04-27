package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
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
	IApplication view;
	
	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public ExitController(IApplication view){
		this.view = view;
	}
	
	/**
	 * Listener for button click. 
	 * 
	 * Changes the current JPanel to that of the GameSelector once button is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = this.view.getFrame();
		GameSelectorPanel gameSelectorPanel = new GameSelectorPanel(frame);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameSelectorPanel);
		frame.pack();
		
	}

}
