package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import builder.views.BuilderPanel;
import model.EliminationGame;
import model.LightningGame;
import model.PuzzleGame;
import model.ReleaseGame;
import model.SixesWild;
import views.IApplication;
import views.LevelSelectorPanel;

public class ChooseBuilderGameController implements ActionListener{
	
	IApplication view;
	JButton btnPuzzle, btnLightning, btnRelease, btnElimination;
	
	public ChooseBuilderGameController(IApplication view, JButton btnPuzzle, JButton btnLightning,
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
	 * 
	 * IMPORTANT: In here we instantiate the appropriate variation of the game. Ex:
	 * If the user has pressed the Puzzle button a Puzzle variation of the game will
	 * be created and passed into the level selector.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnPuzzle){
			/* Create the game variation */
			SixesWild model = new PuzzleGame();
			
			JFrame frame = this.view.getFrame();
			BuilderPanel puzzleBuilderPanel = new BuilderPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(puzzleBuilderPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLightning){
			/* Create the game variation */
			SixesWild model = new LightningGame();
			
			JFrame frame = this.view.getFrame();
			BuilderPanel lightningBuilderPanel = new BuilderPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(lightningBuilderPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnRelease){
			/* Create the game variation */
			SixesWild model = new ReleaseGame();
			
			JFrame frame = this.view.getFrame();
			BuilderPanel releaseBuilderPanel = new BuilderPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(releaseBuilderPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnElimination){
			/* Create the game variation */
			SixesWild model = new EliminationGame();
			
			JFrame frame = this.view.getFrame();
			BuilderPanel eliminationBuilderPanel = new BuilderPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(eliminationBuilderPanel);
			frame.pack();
		}
	}

}
