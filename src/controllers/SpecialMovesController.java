package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.SixesWild;
import views.BoardView;

public class SpecialMovesController implements ActionListener {
	
	/**Buttons*/
	JButton btnSpec1, btnSpec2, btnSpec3;
	 
	/**BoardView*/
	BoardView boardView;
	
	/** Level model*/
	SixesWild model;
	
	public SpecialMovesController(JButton btnSpec1, JButton btnSpec2,
			JButton btnSpec3, BoardView boardView, SixesWild model) {
		super();
		this.btnSpec1 = btnSpec1;
		this.btnSpec2 = btnSpec2;
		this.btnSpec3 = btnSpec3;
		this.boardView = boardView;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== btnSpec1){
			SwapController swapper = new SwapController(boardView, model);
			swapper.register();
			
		}
		else if(e.getSource()== btnSpec2){
			DestroyTileController destroyer = new DestroyTileController(boardView, model);
			destroyer.register();
		}
		else if(e.getSource()== btnSpec3){
				//Reset move =new ResetMove();
				//reset.doMove;
				//voardView.update;
		}

	}

}
