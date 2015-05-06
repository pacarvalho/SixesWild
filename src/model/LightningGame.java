package model;

import javax.swing.Timer;


/**
 * 
 * Method overriding for Lightning variation of the game goes here.
 * 
 * @author Paulo, Katie, OAkyildiz
 *
 */
public class LightningGame extends SixesWild {

	/**Timer for lightning level, internal Controller*/
	private Timer evryTim; //also called best attribute name after doge.
	
	/** remaining Time*/
	private int remainingTime;

	/**
	 * Constructor
	 */
	public LightningGame(){
		super();
		this.remainingTime = 0;
		this.evryTim = new Timer(1000,null);

	}
	
	/**
	 * Initializes the board and then sets the board dependent attributes. 
	 */
	public void initialize(Board board){

		super.initialize(board);
		int time = this.getBoard().getTimeLimit();
		this.addToRemainingTime(time);
		System.out.println(time);

	}

	/**
	 *  Returns the remaining time
	 * @return
	 */
	public int getRemainingTime(){
		return this.remainingTime;
	}
	
	/**
	 * Returns to remaining time as a string in "mm:ss" format.
	 * @return
	 */
	public String getRemainingTimeString() {
		int mins = remainingTime/60;
		int secs = remainingTime%60;
		if (secs >= 10)
			return (mins + ":"+ secs);
		else
			return (mins + ":0"+ secs);
	}
	
	/**
	 * Increments the remainingTime by given amount if the result is not smaller than zero, and returns it.
	 * @param change
	 * @return
	 */
	public int addToRemainingTime(int change) {
		if(change + remainingTime >= 0)
			this.remainingTime += change;
		return remainingTime;
	}
	
	/**
	 * Sets the remaining time.
	 * @param remainingTime
	 */
	public void setRemainingTime(int remainingTime) {
		this.remainingTime = remainingTime;
	}
	
	/**
	 * Returns the timer of the model.
	 * 
	 * @return
	 */
	public Timer getTimer() {
		return this.evryTim;
	}
	
	/**
	 * Sets the timer
	 * 
	 * @param tim
	 * @return
	 */
	public boolean setTimer(Timer tim) {
		this.evryTim = tim;
		return true;
	}

	/**
	 * Returns the name of the variation
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
	 * Increments the numMoves (remaining moves) by given number.
	 */
	@Override
	public boolean updateMoves(int change) {
		this.numMoves += change;
		return true;
	}

}
