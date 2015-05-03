package model;

import javax.swing.Timer;


/**
 * 
 * Method overriding for Lightning variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class LightningGame extends SixesWild {
	
	/**Timer for lightning level, internal Controller*/
	private Timer evryTim;
	/** remaining Time*/
	private int remainingTime;
	
	
	public LightningGame(){
		super();
		this.remainingTime = 0;
		this.evryTim = new Timer(1000,null);
//		
	}
	
	public String getRemainingTime() {
		int mins = remainingTime/60;
		int secs = remainingTime%60;
		if (secs >= 10)
			return (mins + ":"+ secs);
		else
			return (mins + ":0"+ secs);
	}
	public int addToRemainingTime(int change) {
		this.remainingTime += change;
		return remainingTime;
	}
	
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	
	public Timer getTimer() {
		 return this.evryTim;
	}
	public boolean setTimer(Timer tim) {
		 this.evryTim = tim;
		 return true;
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
	
	@Override
	public boolean updateMoves(int change) {
		this.numMoves += change;
		return true;
	}
	
	
	
	/**
	 * Returns the board
	 */
	@Override
	public Board getBoard(){
		return this.board;
	}

}
