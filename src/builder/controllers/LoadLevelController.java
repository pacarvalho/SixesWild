package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;

import model.Level;

public class LoadLevelController implements ActionListener {

		Level level;
		JButton loadButton;
		
		public LoadLevelController(Level level, JButton loadButton){
			
			/**
			 * Builder level to load
			 */
			this.level = level;
			this.loadButton = loadButton;
			
			//once the builder is set up loader will de-serialize saved state, 
			//and updtae the model(board, stat settings, builder options etc.)
		}
		// TODO implement loader so it takes in builder options too, and updates the model accordingly.
		// TODO select file to load?
		@Override
		public void actionPerformed(ActionEvent e) {
				
			//this model will be replaced by the instance of builder
			if(e.getSource() == this.loadButton){
		      try
		      {
		         FileInputStream fileIn = new FileInputStream("game.ser");
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         Level newLevel = (Level) in.readObject();
		         in.close();
		         fileIn.close();
		      }catch(IOException i)
		      {
		         i.printStackTrace();
		         return;
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Employee class not found");
		         c.printStackTrace();
		         return;
		      }
		      System.out.println("Model loaded");
		      //repaint
			}
		}
}