package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import model.Board;
import model.SixesWild;
import views.IApplication;
import views.LevelPanel;

/** 
 * Allows for selection of a custom level to be played
 * 
 * @author Paulo, Katie
 *
 */
public class ChooseCustomLevelController implements ActionListener{
	
	/** Stores Model */
	SixesWild model;
	
	/** Parent View */
	IApplication view;
	
	/**
	 * Constructor 
	 * 
	 * @param m
	 * @param view
	 * @param button
	 */
	public ChooseCustomLevelController(SixesWild m, IApplication view){
		this.model = m;
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Open the file saving dialog
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		int returnVal = fc.showOpenDialog(fc);
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			Board board = null;
			try{
				board = (Board) deserialize(fc.getSelectedFile().getAbsolutePath());
				
			} catch (ClassNotFoundException z) {
				z.printStackTrace();
				
			} catch (IOException z) {
				z.printStackTrace();
				
			} 
			
			if (board != null) {
				// Initialize the level
				this.model.initialize(board); 
				this.model.getBoard().update();
				
				JFrame frame = this.view.getFrame();
				LevelPanel levelPanel = new LevelPanel(frame, this.model, this.model.getName(), 
						"Custom Level"); //title once entity is implemented
				frame.getContentPane().removeAll();
				frame.getContentPane().add(levelPanel);
				frame.pack();
			}
		}
		
	}
	
	/**
	 * Loads a serialized object
	 */
	public Object deserialize(String fileName) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream(fileName);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Object obj = ois.readObject();
		
		ois.close();
		
		return obj;
	}
}
