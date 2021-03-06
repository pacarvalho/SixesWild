package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Board;
import model.SixesWild;
import views.IApplication;
import views.LevelPanel;

/**
 * 
 * Panel where a level is chosen. 
 * 
 * Loads the board from file and instantiates controllers responsible for starting the actual game.
 * 
 * @author Paulo, Katie, Sean
 *
 */
public class ChooseLevelController implements ActionListener{
	
	/** Buttons */
	JButton btnLevel1, btnLevel2, btnLevel3, btnLevel4;
	
	/** Game Model */
	SixesWild model;
	
	/** Parent JPanel */
	IApplication view;
	
	/** Title of the JPanel */
	String title;
	
	/**
	 * Constructor
	 * 
	 * @param m
	 * @param view
	 * @param btnLevel1
	 * @param btnLevel2
	 * @param btnLevel3
	 * @param btnLevel4
	 */
	public ChooseLevelController(SixesWild m, IApplication view, JButton btnLevel1, JButton btnLevel2,
				JButton btnLevel3, JButton btnLevel4){
		this.model = m;
		this.view = view;
		this.title = m.getName(); // Get the variation name
		
		this.btnLevel1 = btnLevel1;
		this.btnLevel2 = btnLevel2;
		this.btnLevel3 = btnLevel3;
		this.btnLevel4 = btnLevel4;
		
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it checks which button called it and opens the corresponding level selector panel.
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.btnLevel1){
			// Desirialize Appropriate level
			Board level = null;
			try{
				level = (Board)deserialize("resources/levels/" + this.model.getName() + "/test_level1.txt");
			} catch (IOException z) {
				z.printStackTrace();
				
			} catch (ClassNotFoundException z) {
				z.printStackTrace();
				
			} 
			
			if (level == null) { // Protect against level being null
				level = new Board();
			}
			
			level.update();
			
			// Initialize the level
			this.model.initialize(level); 
			
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title, 
					"Level 1", 1); //title once entity is implemented
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel2){
			// Desirialize Appropriate level
			Board level = null;
			try{
				level = (Board)deserialize("resources/levels/" + this.model.getName() + "/test_level2.txt");
			} catch (IOException z) {
				z.printStackTrace();
				
			} catch (ClassNotFoundException z) {
				z.printStackTrace();
				
			} 
			
			if (level == null) { // Protect against level being null
				level = new Board();
			}
			
			level.update();

			// Initialize the level
			this.model.initialize(level); 
						
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title, 
					"Level 2", 2);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel3){
			// Desirialize Appropriate level
			Board level = null;
			try{
				level = (Board)deserialize("resources/levels/" + this.model.getName() + "/test_level3.txt");
			} catch (IOException z) {
				z.printStackTrace();
				
			} catch (ClassNotFoundException z) {
				z.printStackTrace();
				
			} 
			
			if (level == null) { // Protect against level being null
				level = new Board();
			}
			
			level.update();
			
			// Initialize the level
			this.model.initialize(level); 
			
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title, 
					"Level 3", 3);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
		}
		
		if(e.getSource() == this.btnLevel4){
			// Desirialize Appropriate level
			Board level = null;
			try{
				level = (Board)deserialize("resources/levels/" + this.model.getName() + "/test_level4.txt");
			} catch (IOException z) {
				z.printStackTrace();
				
			} catch (ClassNotFoundException z) {
				z.printStackTrace();
				
			} 
			
			if (level == null) { // Protect against level being null
				level = new Board();
			}
			
			level.update();
			
			// Initialize the level
			this.model.initialize(level); 
			
			JFrame frame = this.view.getFrame();
			LevelPanel levelPanel = new LevelPanel(frame, model, title,
					"Level 4", 4);
			frame.getContentPane().removeAll();
			frame.getContentPane().add(levelPanel);
			frame.pack();
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