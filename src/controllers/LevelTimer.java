package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.LevelPanel;
import model.LightningGame;

/**
 * Controller for the timer
 * 
 * @author Ozan
 *
 */
public class LevelTimer implements ActionListener{
	
	/** only for Lightning games*/
	LightningGame level;

	/**LevelPanel of the level*/
	LevelPanel levelView;
	
	/**
	 * Constructor 
	 * 
	 * @param level
	 * @param levelView
	 */
	public LevelTimer(LightningGame level, LevelPanel levelView) {

		this.level = level;
		this.levelView = levelView;
	
		
	}

	/**
	 * Updates remaining time and the view
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.level.addToRemainingTime(-1);
		String time = this.level.getRemainingTimeString();
		this.levelView.getCountdownView().setText(time);

	}
	
}
