package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.ResetMove;
import model.SixesWild;
import views.BoardView;

/**
 * Controller for special move: Shuffle
 * 
 * @author OAkyildiz
 *
 */
public class ResetController implements ActionListener {

	/**BoardView*/
	BoardView boardView;

	/** Level model*/
	SixesWild model;

	/**Button to control*/
	JButton resetBtn;

	/**
	 * Constructor
	 * 
	 * @param resetBtn
	 * @param boardView
	 * @param model
	 */
	public ResetController(JButton resetBtn, BoardView boardView, SixesWild model) {
		this.resetBtn = resetBtn;
		this.boardView = boardView;
		this.model = model;
	}

	/** 
	 * Button listener
	 * 
	 * Performs move when clicked.
	 */
	public void actionPerformed(ActionEvent e) {
		ResetMove reset = new ResetMove(model);	
		
		if(model.getSpecQuotas(2) != 0){
			if(reset.doMove()){
				model.changeSpecQuotas(2, -1);

				if(model.getSpecQuotas(2) < 1)
					this.resetBtn.setEnabled(false);

				boardView.updateBoardView();

			}
		}
	}
}
