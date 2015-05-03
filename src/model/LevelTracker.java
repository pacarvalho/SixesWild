package model;

import java.io.Serializable;

/**
 * Keeps persistant state of the game.
 * 
 * Highest score, locked and unlocked levels.
 * 
 * @author Paulo, Katie
 *
 */
public class LevelTracker implements Serializable{
	/**
	 * ID
	 */
	private static final long serialVersionUID = 2046881357827001490L;
	
	/** Highest score ever achieved in the game */
	public int puzzleScore[] = {0,0,0,0};
	public int lightningScore[] = {0,0,0,0};
	public int releaseScore[] = {0,0,0,0};
	public int eliminationScore[] = {0,0,0,0};
	
	/** Booleans of unlocked levels */
	public boolean puzzleLocked[] = {false,true,true,true};
	public boolean lightningLocked[] = {false,true,true,true};
	public boolean releaseLocked[] = {false,true,true,true};
	public boolean eliminationLocked[] = {false,true,true,true};
}
