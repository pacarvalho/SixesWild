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
	
	/**Timer for lightnig level, internal Controller*/
//	Timer levelTimer;
	private int remainingTime;
	
	public LightningGame(){
		super();
		this.numMoves = this.board.getTimeLimit();
//		levelTimer = new Timer(1000, updateRemainingTime());
//		levelTimer.start();
	}
	
	public int getRemainingTime() {
		return remainingTime;
	}

	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
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
