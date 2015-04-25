package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import views.GameSelectorPanel;
import views.IApplication;

import model.Model;

public class ExitController implements ActionListener{
	Model model;
	IApplication view;
	
	public ExitController(Model m, IApplication view){
		this.model = m;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = this.view.getFrame();
		GameSelectorPanel gameSelectorPanel = new GameSelectorPanel(frame, model);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameSelectorPanel);
		frame.pack();
		
	}

}
