package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Model;
import views.IApplication;
import views.LevelSelectorPanel;

public class ChooseGameController implements ActionListener{
	
	Model model;
	IApplication view;
	JButton btnPuzzle, btnLightning, btnRelease, btnElimination;
	
	public ChooseGameController(IApplication view, Model m, JButton btnPuzzle, JButton btnLightning,
				JButton btnRelease, JButton btnElimination){
		
		this.model=m;
		this.view = view;
		
		this.btnPuzzle = btnPuzzle;
		this.btnLightning = btnLightning;
		this.btnRelease = btnRelease;
		this.btnElimination = btnElimination;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnPuzzle){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel puzzleLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model, "Puzzle");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(puzzleLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLightning){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel lightningLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model, "Lightning");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(lightningLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnRelease){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel releaseLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model, "Release");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(releaseLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnElimination){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel eliminationLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model, "Elimination");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(eliminationLevelSelectorPanel);
			frame.pack();
		}
	}
}

