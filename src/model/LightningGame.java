package model;

import java.util.Timer;


/**
 * 
 * Method overriding for Lightning variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class LightningGame extends SixesWild {
	
	//Timer levelTimer;
	public LightningGame(){
		super();
		//this.countDown = 120;
		//levelTimer = new Timer(1000, updateRemainingTime);
		//levelTimer.start();
	}
	
	/**
	 * 
	 */
	@Override
	public String getName(){
		return "Lightning";
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasWon(){
		return false;
	}
	
	/**
	 * 
	 */
	@Override
	public boolean hasLost(){
		return false;
	}
	
	/**
	 * 
	 */
	//no need to override
	@Override
	public void updateScore() {
	}
	

	
	
	/**
	 * Returns the board
	 */
	@Override
	public Board getBoard(){
		return this.board;
	}
}
