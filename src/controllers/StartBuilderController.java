package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Model;
import views.IApplication;
import views.BuilderPanel;

public class StartBuilderController implements ActionListener{
	
	JButton btnLvlBuilder;
	IApplication view;
	Model model;
	
	
	public StartBuilderController(Model m, IApplication view, JButton btnLvlBuilder){
		this.model = m;
		this.view = view;
		this.btnLvlBuilder = btnLvlBuilder;
	
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnLvlBuilder){
			JFrame frame = this.view.getFrame();
			BuilderPanel builderPanel = new BuilderPanel(frame, model);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(builderPanel);
			frame.pack();
		}	
	}
}
