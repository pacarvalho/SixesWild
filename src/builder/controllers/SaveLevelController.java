package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import model.Level;

import javax.swing.JButton;

public class SaveLevelController implements ActionListener {

	Level builderLevel;
	JButton saveButton;

	public SaveLevelController(Level builderLevel, JButton saveButton){

		this.builderLevel = builderLevel;
		this.saveButton = saveButton;
	}
	
	/**
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * 
	 * This method if called by event listeners upon button click. Once it is called,
	 * it will serialize the state of the builder.
	 */
	
	// TODO implement saver so it takes in builder options too.
	// TODO name for saved file?
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO implement proper serialization of the game state.
		//right now it serializes the model.
		if(e.getSource() == this.saveButton){
			try
			{
				FileOutputStream fileOut = new FileOutputStream("level.ser");
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
				out.writeObject(this.builderLevel);
				out.close();
				fileOut.close();
				System.out.printf("Serialized data is saved in /bin/employee.ser");
			}catch(IOException i)
			{
				i.printStackTrace();
			}
		}
	}



}
