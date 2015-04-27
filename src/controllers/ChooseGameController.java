package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import model.EliminationGame;
import model.LightningGame;
import model.PuzzleGame;
import model.ReleaseGame;
import model.SixesWild;
import views.IApplication;
import views.LevelSelectorPanel;

/**
 * Panel for choosing game type
 * 
 * @author Paulo, Katie, Sean
 *
 */
public class ChooseGameController implements ActionListener{
	
	IApplication view;
	JButton btnPuzzle, btnLightning, btnRelease, btnElimination;
	
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
			LevelSelectorPanel puzzleLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(puzzleLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLightning){
			/* Create the game variation */
			SixesWild model = new LightningGame();
			
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel lightningLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(lightningLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnRelease){
			/* Create the game variation */
			SixesWild model = new ReleaseGame();
			
			
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel releaseLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(releaseLevelSelectorPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnElimination){
			/* Create the game variation */
			SixesWild model = new EliminationGame();
			
			JFrame frame = this.view.getFrame();
			LevelSelectorPanel eliminationLevelSelectorPanel = new LevelSelectorPanel(frame, 
					model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(eliminationLevelSelectorPanel);
			frame.pack();
		}
	}
}

