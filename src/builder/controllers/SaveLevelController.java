package builder.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import model.SixesWild;
import builder.views.BuilderPanel;

/**
 * 
 * 
 * @author Paulo, Katie
 *
 */
public class SaveLevelController implements ActionListener{

	/** Stores the boundary */
	BuilderPanel builderPanel;
	
	/** Stores the model */
	SixesWild model;
	
	/** 
	 * Constructor
	 * 
	 * @param builderPanel
	 */
	public SaveLevelController(BuilderPanel builderPanel, SixesWild model){
		this.builderPanel = builderPanel;
		this.model = model;
	}
	
	/**
	 * Listener for button click. 
	 * 
	 * Saves the board upon clicking
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Open the file saving dialog
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("."));
		int returnVal = fc.showSaveDialog(fc);
		
		if (returnVal == JFileChooser.APPROVE_OPTION){
			try{
				this.serialize(this.model.getBoard(), fc.getSelectedFile().getAbsolutePath());
			} catch (IOException z){
				z.printStackTrace();
				return;
			}
		}
				
		
	}
	
	/**
	 * Serializes a given serializable object
	 */
	public void serialize(Object obj, String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		
		fos.close();
	}
	
	
}
