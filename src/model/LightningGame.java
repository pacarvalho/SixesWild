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
		
		}
	
		public void initialize(Board board){
			
			super.initialize(board);
			int time = this.getBoard().getTimeLimit();
			this.addToRemainingTime(time);
			System.out.println(time);
			
		}
		
	
	public int getRemainingTime(){
		return this.remainingTime;
	}
	public String getRemainingTimeString() {
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
	 *  hasWon Lightning Game
	 *  
	 *  checks if a certain score has been reached to be consider a win 
	 *  for lightning
	 */
	@Override
	public boolean hasWon(){
		// Check for max score.
		if (this.board.getScoreLimit() <= this.getCurrentScore()){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Checks if a lightning game has been lost
	 * 
	 * checks to see if the timer is up
	 */
	@Override
	public boolean hasLost(){
		if(this.remainingTime <= 0){
			return true;
		}
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
