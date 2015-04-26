package model;

/**
 * Interface for the move class
 * 
 * @author katiegandomi, pacarvalho
 *
 */
public interface IMove {
	
	/**
	 * Performs the move 
	 * 
	 * @return boolean 
	 */
	public boolean doMove();
	
	/**
	 * Checks if the move is valid
	 * 
	 * @return boolean
	 */
	public boolean valid();
}
