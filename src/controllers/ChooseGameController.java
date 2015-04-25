package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import views.IApplication;
import views.LevelSelectorPanel;

public class ChooseGameController implements ActionListener{
	
	JButton btnPuzzle, btnLightning, btnRelease, btnElimination;
	IApplication view;
	
	
	public ChooseGameController(IApplication view, JButton btnPuzzle, JButton btnLightning,
				JButton btnRelease, JButton btnElimination){
		this.view = view;
		
		this.btnPuzzle = btnPuzzle;
		this.btnLightning = btnLightning;
		this.btnRelease = btnRelease;
		this.btnElimination = btnElimination;
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnPuzzle){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel puzzleLevelSelectorPanel = new LevelSelectorPanel(frame, 
					"Puzzle");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(puzzleLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLightning){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel lightningLevelSelectorPanel = new LevelSelectorPanel(frame, 
					"Lightning");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(lightningLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnRelease){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel releaseLevelSelectorPanel = new LevelSelectorPanel(frame, 
					"Release");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(releaseLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnElimination){
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel eliminationLevelSelectorPanel = new LevelSelectorPanel(frame, 
					"Elimination");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(eliminationLevelSelectorPanel);
			frame.pack();
		}
	}
}

