package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import builder.views.BuilderPanel;
import views.IApplication;

/**
 * Starts the Level Builder
 * 
 * @author Ozan
 *
 */
public class StartBuilderController implements ActionListener{
	
	/** Button for going to level builder */
	JButton btnLvlBuilder;
	
	/** Parent JPanel */
	IApplication view;
	
	/**
	 * Constructor 
	 * 
	 * @param view
	 * @param btnLvlBuilder
	 */
	public StartBuilderController(IApplication view, JButton btnLvlBuilder){
		this.view = view;
		this.btnLvlBuilder = btnLvlBuilder;
	
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnLvlBuilder){
			JFrame frame = this.view.getFrame();
			BuilderPanel builderPanel = new BuilderPanel(frame);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(builderPanel);
			frame.pack();
		}	
	}
}
