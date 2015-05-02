package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;

import builder.views.BuilderPanel;
import model.Board;
import model.SixesWild;

/**
 * 
 * @author Katie, Paulo
 *
 */
public class LoadLevelController implements ActionListener{
	
	/** Stores the boudnary */
	BuilderPanel builderPanel;
	
	/** Stores the Model */
	SixesWild model;
	
	/**
	 * Constructor
	 */
	public LoadLevelController(BuilderPanel builderPanel, SixesWild model){
		this.builderPanel = builderPanel;
		this.model = model;
	}
	
	/**
	 * Listener for button click. 
	 * 
	 * Loads the board upon clicking
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Open the file saving dialog
		final JFileChooser fc = new JFileChooser();
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
				this.model.initialize(board);
				this.builderPanel.updateParameters();
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
