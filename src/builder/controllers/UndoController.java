package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import builder.model.BuilderSixesWild;
import builder.views.BuilderPanel;
import model.Board;
import model.SixesWild;
/**
 * 
 * @author Paulo, Katie
 *
 */

public class UndoController implements ActionListener{
	
	/** Create Boundary Object */
	BuilderPanel builderPanel;
	
	/** Create Game Model Object*/
	SixesWild model;
	
	/** Create Builder Model Object*/
	BuilderSixesWild builder;
	
	/**
	 * Constructor 
	 * 
	 * @param boardPanel
	 * @param model
	 */
	public UndoController(BuilderPanel builderPanel, BuilderSixesWild builder, SixesWild model){
		this.builderPanel = builderPanel;
		this.builder = builder;
		this.model = model;
	}
	
	
	/**
	 * Listener for Undo Button Click
	 * 
	 * When the undo button is clicked a previous board state is restored
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		Board currentState = this.model.getBoard();
		Board newState = this.builder.undoMemento(currentState);
		this.model.initialize(newState);
		
		this.builderPanel.updateParameters();
	}

}
