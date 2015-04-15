package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import views.IApplication;
import views.LevelPanel;
import views.LevelSelectorPanel;

public class ChooseLevelController implements ActionListener{
	
	JButton btnLevel1, btnLevel2, btnLevel3, btnLevel4;
	IApplication view;
	
	
	public ChooseLevelController(IApplication view, JButton btnLevel1, JButton btnLevel2,
				JButton btnLevel3, JButton btnLevel4, String title){
		this.view = view;
		
		this.btnLevel1 = btnLevel1;
		this.btnLevel2 = btnLevel2;
		this.btnLevel3 = btnLevel3;
		this.btnLevel4 = btnLevel4;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnLevel1){
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, 
					"Level 1"); //title once entity is implemented
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel2){
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, 
					"Level 2");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel3){
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, 
					"Level 3");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel4){
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, 
					"Level 4");
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
	}
}