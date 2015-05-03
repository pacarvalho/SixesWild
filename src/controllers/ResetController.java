package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.SixesWild;
import views.BoardView;

/**
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
	
	public ResetController(JButton resetBtn, BoardView boardView, SixesWild model) {
		this.resetBtn = resetBtn;
		this.boardView = boardView;
		this.model = model;
	}


		public void actionPerformed(ActionEvent e) {
				if(model.getSpecQuotas(2) != 0){
					model.changeSpecQuotas(2, -1);
					//model.setSpecQuotas(1, SixesWild.DEFAULT);
					//model.setSpecQuotas(0, SixesWild.DEFAULT);
//					Reset move =new ResetMove();
//					reset.doMove;
//					boardView.update();7
				}
		}
}
