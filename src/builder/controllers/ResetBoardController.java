package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Board;
import model.SixesWild;
import builder.model.BuilderSixesWild;
import builder.views.BuilderPanel;

/**
 * Resets the builder to default settings.
 * 
 * @author Paulo
 *
 */
public class ResetBoardController implements ActionListener{
	
	/** Create Boundary Object */
	BuilderPanel builderPanel;
	
	/** Create Game Model Object*/
	BuilderSixesWild builder;
	
	/** Create Game Model Object*/
	SixesWild model;

	public ResetBoardController(BuilderPanel builderPanel, BuilderSixesWild builder, SixesWild model){
		this.builderPanel = builderPanel;
		this.builder = builder;
		this.model = model;
	}
	
	/**
	 * Reset Builder Level Listener
	 * 
	 * When this button is click the board resets to its default state
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.builder.createMemento(this.model.getBoard());
		
		Board defaultBoard = new Board();
		defaultBoard.createDefaultBoard();
		
		this.model.initialize(defaultBoard);
		
		this.builderPanel.updateParameters();
		
	}
}
