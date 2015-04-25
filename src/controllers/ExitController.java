package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import views.GameSelectorPanel;
import views.IApplication;

import model.SixesWild;

public class ExitController implements ActionListener{
	IApplication view;
	
	public ExitController(IApplication view){
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFrame frame = this.view.getFrame();
		GameSelectorPanel gameSelectorPanel = new GameSelectorPanel(frame);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(gameSelectorPanel);
		frame.pack();
		
	}

}
