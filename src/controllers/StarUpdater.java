package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import views.StarPanel;
import model.SixesWild;



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

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		this.starViews.updateStars(model.assessScore());
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// do nothing
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// do nothing
		
	}
	
	

}
