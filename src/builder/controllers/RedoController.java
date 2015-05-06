package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import model.Board;
import model.SixesWild;
import builder.model.BuilderSixesWild;
import builder.views.BuilderPanel;

public class RedoController implements ActionListener{
	
	/** Create Boundary Object */
	BuilderPanel builderPanel;
	
	/** Create Game Model Object*/
	SixesWild model;
	
	/** Create Builder Model Object*/
	BuilderSixesWild builder;
	
	/** 
	 * Constructor
	 * 
	 * @param builderPanel
	 * @param builder
	 * @param model
	 */
	public RedoController(BuilderPanel builderPanel, BuilderSixesWild builder, SixesWild model){
		this.builderPanel = builderPanel;
		this.builder = builder;
		this.model = model;
	}


	/**
	 * Listener for Redo Button Click
	 * 
	 * When the Redo button is clicked a "future" board state is restored
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
Board board = this.model.getBoard();
		
		try{
			board = this.builder.redoMemento(board);
		} catch (EmptyStackException z) {
			return;
		}
		
		this.model.initialize(board);
		
		this.builderPanel.updateParameters();
	}

}
