package views;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javax.swing.JButton;
import model.EliminationGame;
import model.LevelTracker;
import model.LightningGame;
import model.PuzzleGame;
import model.ReleaseGame;
import model.SixesWild;
import controllers.ChooseCustomLevelController;
import controllers.ChooseLevelController;

/**
 * Allows user to select which level he intends to play
 * 
 * @author Katie, Paulo, Sean
 *
 */
public class LevelSelectorPanel extends JPanel implements IApplication{
	
	/**
	 * ID For Multithreaded runs
	 */
	private static final long serialVersionUID = -5640806150838492981L;
	
	/** Parent frame */
	JFrame frame;
	
	/** Game Model */
	SixesWild model;
	
	/**
	 * Hashmap of all components
	 */
	private HashMap<String, Component> componentMap;
	
	/**
	 * Constructor
	 * 
	 * @param frame
	 * @param m
	 */
	public LevelSelectorPanel(JFrame frame, SixesWild m) {
		
		this.frame = frame;
		this.model = m;
		
		// De-serialize data regarding level unlocking
		LevelTracker lt = null;
		try {
			lt = (LevelTracker)this.deserialize("resources/levels/level_tracker.txt");
			
		} catch (IOException e){ // If file does not exist create a new one and save it to disk
			System.out.println("Level tracker could not be found. New tracker created.");
			
			lt = new LevelTracker();
			
			try{
				serialize(lt,"resources/levels/level_tracker.txt"); // Save to disk
			} catch (IOException z) {
				z.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		JLabel lblSelectLevel = new JLabel(m.getName());
		lblSelectLevel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 45));
		
		JLabel lblPuzzleLevels = new JLabel("Select Level");
		
		/*
		 * Create level buttons and bind them to their controllers
		 */
		
		JButton btnLevel1 = new JButton("Level 1");
		btnLevel1.setName("Level 1");
		JButton btnLevel2 = new JButton("Level 2");
		btnLevel2.setName("Level 2");
		JButton btnLevel3 = new JButton("Level 3");
		btnLevel3.setName("Level 3");
		JButton btnLevel4 = new JButton("Level 4");
		btnLevel4.setName("Level 4");
		
		ChooseLevelController chooseLevelController = new ChooseLevelController(model, this, btnLevel1, btnLevel2,
				btnLevel3, btnLevel4);
		
		// Determine which game we are playing
		boolean lockedLevels[] = new boolean[4];
		if (this.model instanceof PuzzleGame){
			lockedLevels = lt.puzzleLocked;
		} else if (this.model instanceof EliminationGame) {
			lockedLevels = lt.eliminationLocked;
		} else if (this.model instanceof LightningGame) {
			lockedLevels = lt.lightningLocked;
		} else if (this.model instanceof ReleaseGame) {
			lockedLevels = lt.releaseLocked;
		}
		
				
		// Only bind to controllers the levels that have been UNLOCKED!
		btnLevel1.addActionListener(chooseLevelController);
		btnLevel2.addActionListener(chooseLevelController);
		btnLevel3.addActionListener(chooseLevelController);
		btnLevel4.addActionListener(chooseLevelController);
		
		// Enable or Disable buttons based on available levels
		btnLevel1.setEnabled(!lockedLevels[0]);
		btnLevel2.setEnabled(!lockedLevels[1]);
		btnLevel3.setEnabled(!lockedLevels[2]);
		btnLevel4.setEnabled(!lockedLevels[3]);
		
		/*
		 * Create the choose custom level button and bind it to its controller
		 */
		ChooseCustomLevelController customController = new ChooseCustomLevelController(this.model, this);
		JButton btnCustomLevel = new JButton("Choose Your Own!");
		btnCustomLevel.setName("Choose Your Own!");
		btnCustomLevel.addActionListener(customController);
		
		// Place buttons on correct locations
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		// Place Title
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(lblSelectLevel, c);
		
		// Place Subtitle
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		c.ipady = 25; // Height in px
		this.add(lblPuzzleLevels, c);
		
		// Place level buttons
		// Level 1
		c.gridx = 0; // Column 
		c.gridy = 2; // Row
		c.gridwidth = 1; // Number of columns it spans
		c.ipady = 40; // Height in px
		this.add(btnLevel1, c);
		
		// Level 2
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLevel2, c);
		
		// Level 3
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLevel3, c);
		
		// Level 4
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLevel4, c);
		
		// Place custom level button
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.ipady = 20;
		this.add(btnCustomLevel, c);
		
		// Add the buttons to the hashmap. This is to make testing easier
		createComponentMap();
	}
	
	/**
	 * Return parent JFrame
	 */
	@Override
	public JFrame getFrame() {
		return this.frame;
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
	
	/**
	 * Serializes a given serializable object
	 */
	public void serialize(Object obj, String fileName) throws IOException{
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		
		fos.close();
	}
	
	/**
	 * Create background image
	 */
	 @Override
	 protected void paintComponent(Graphics g) {
	     super.paintComponent(g); // paint the background image and scale it to fill the entire space
	     Image image = null;
		try {
			image = ImageIO.read(new File("Resources/gradient.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(image != null){
			g.drawImage(image, 0, 0, 1000, 800, this);	
		}
	 }
	 
	 /**
	  * Create hashmap of components (buttons) on the panel
	  */
	 private void createComponentMap() {
	        componentMap = new HashMap<String,Component>();
	        Component[] components = this.getComponents();
	        for (int i=0; i < components.length; i++) {
	                componentMap.put(components[i].getName(), components[i]);
	        }
	}
	 
	 /**
	  * Get a component by its name
	  */

	public Component getComponentByName(String name) {
	        if (componentMap.containsKey(name)) {
	                return (Component) componentMap.get(name);
	        }
	        else return null;
	}

}
