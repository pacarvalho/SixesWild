package controllers;

import views.LevelPanel;
import model.LightningGame;
import model.SixesWild;

/**
 * Listens to the changes in Boundary object for score.
 * 
 * 
 * Updates the stars if the player has lost or earned a star.
 * (there are many and more direct ways to implement this, 
 * but this is a controller based on toggle bits 
 * (with more bits available) that updates when the score shown
 * is updated.
 * 
 * @author OAkyildiz
 *
 */
public class ScoreStarUpdater {
	/** Game Model */
	SixesWild model;
	
	/**Star Panel to update*/
	private LevelPanel levelView;
	
	/**ScoreLimits*/
	double[] starScores =new double[3];
	
	
	/**
	 * Constructor
	 * @param model
	 */
	public ScoreStarUpdater(SixesWild model) {
		super();
		this.model = model;
		this.levelView = null;
		
		int scoreLimit = model.getBoard().getScoreLimit();
		this.starScores =new double[]{scoreLimit * SixesWild.WIN1,
			scoreLimit*SixesWild.WIN2,
			scoreLimit*SixesWild.WIN3};
			
		
	}
	
	/**
	 * Returns the level view
	 * 
	 * @return
	 */
	public LevelPanel getLevelView() {
		return levelView;
	}

	/**
	 * Setter for the level view
	 * 
	 * @param levelView
	 */
	public void setLevelView(LevelPanel levelView) {
		this.levelView = levelView;
	}


	/**
	 * If score is changed, assess for changes in stars, update Stars and Score.
	 */
	public void scoreUpdated() {
		if(levelView != null){
			//update score and moves
			int score = this.model.getCurrentScore();
			this.levelView.getScoreView().setText("" + score);
			
			if(!(this.model instanceof LightningGame))
				this.levelView.getCountdownView().setText("" + this.model.getNumMoves());
			
			//update stars if needed
			int change = assessScore(score);
			if (change != 0) // if no change don't call the method		 
				this.levelView.getStarView().updateStars(change);
		}
	}


	/** evaluates if a star is earned or lost 
	 * @param sixesWild */
	// TODO might be moved to Board
	public int assessScore(int score){
		int EVAL = 0;
		
		if(score >= starScores[2]){
			EVAL= 7;
		
		} else if(score >= starScores[1]) {
			EVAL = 3;
		
		} else if(score >= starScores[0]) {
			EVAL = 1;
			
		}
		
		int change = model.stars^EVAL;
		
		model.stars=EVAL;
		
		return change;
	}
	
	

}
