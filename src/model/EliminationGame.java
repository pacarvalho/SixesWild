package model;

/**
 * Method overriding for elimination variation of the game goes here.
 * 
 * @author Paulo, Katie, OAkyildiz
 *
 *
 */
public class EliminationGame extends SixesWild {
	
	public EliminationGame(){
		super();
		this.stars = 7;
		this.specQuotas = new int[]{1,0,1};
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
