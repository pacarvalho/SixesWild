package controllers;

import views.IApplication;
import model.Board;
import model.SixesWild;


/**
 * Reset the model to initial state of the level on button click
 * 
 * @author OAkyildiz
 *
 */
public class ResetController {
	
	/**Sixes wild model*/
	SixesWild model;
	
	/**BoardView*/
	IApplication view;
	
	/** Board to read from and load into SixesWild */
	Board initalBoard;

	/**
	 * Constructor
	 * 
	 * @param model
	 * @param view
	 */
	public ResetController(SixesWild model, IApplication view) {
		super();
		this.model = model;
		this.view = view;
		//read from file
		//this.initalBoard = initalBoard;
	}
	
	
}
