package controllers;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import views.StarPanel;
import model.SixesWild;

/**
 * Listens to the changes in Boundary object for score.
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
public class StarUpdater implements DocumentListener {
	/** Game Model */
	SixesWild model;

	// /** TextView to listen*/
	// JTextField scoreView;
	
	/**Star Panel to update*/
	StarPanel starViews;
	
	public StarUpdater(SixesWild model, StarPanel stars) {
		super();
		this.model = model;
		this.starViews = stars;
	}
	/**
	 * If score text field is changed, assess for changes in stars, update View.
	 */
	@Override
	public void changedUpdate(DocumentEvent e) {
		
		
		int change = model.assessScore();
		if (change != 0) // if no change don't call the method		 
			this.starViews.updateStars(change);
	}
	
	/**
	 * nothing to see here
	 */
	@Override
	public void insertUpdate(DocumentEvent e) {
		// do nothing
		
	}
	
	/**
	 * nothing to see here
	 */
	@Override
	public void removeUpdate(DocumentEvent e) {
		// do nothing
		
	}
	
	

}
