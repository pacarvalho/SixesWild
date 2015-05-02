package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import model.SixesWild;
import builder.model.BuilderSixesWild;
import builder.views.BuilderPanel;

/**
 * 
 * @author Paulo, Katie
 *
 */

public class scoreLimitController implements ActionListener{
	/** Create Boundary Object */
	BuilderPanel builderPanel;
	
	/** Create Game Model Object*/
	BuilderSixesWild builder;
	
	/** Create Game Model Object*/
	SixesWild model;
	
	/** Text Field */
	JTextField text;

	/**
	 * Constructor
	 * 
	 * @param builderPanel
	 * @param builder
	 * @param model
	 * @param timeLimitText 
	 */
	public scoreLimitController(BuilderPanel builderPanel, BuilderSixesWild builder, SixesWild model, JTextField text){
		this.builderPanel = builderPanel;
		this.builder = builder;
		this.model = model;
		this.text = text;
	}
	
	/**
	 * Listener for Text Field Enter Click
	 * 
	 * When enter is pressed on the text field, update the model and add to undo stack
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		
		this.builder.createMemento(this.model.getBoard()); // Save memento
		
		int limit = 0;
		
		// If the user enters a non-integer value, assume 0.
		try{ 
			limit = Integer.parseInt(this.text.getText());
		} catch (NumberFormatException z) {
			System.out.println(z.getStackTrace());
		}
		
		this.model.getBoard().setScoreLimit(limit);
	}
}
