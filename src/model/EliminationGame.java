package model;

/**
 * Method overriding for elimination variation of the game goes here.
 * 
 * @author Paulo, Katie
 *
 */
public class EliminationGame extends SixesWild {
	
	public EliminationGame(){
		super();
	}
	
	/**
	 * 
	 */
	@Override
	public String getName(){
		return "Elimination";
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
	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Returns the board
	 */
	@Override
	public Board getBoard(){
		return this.board;
	}


}
