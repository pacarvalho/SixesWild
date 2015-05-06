package views;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.JButton;
import controllers.ChooseGameController;
import controllers.StartBuilderController;



public class GameSelectorPanel extends JPanel implements IApplication{
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 3090894756601902283L;
	
	/**
	 * Parent container
	 */
	JFrame frame;
	
	/**
	 * Hashmap of all components
	 * @param hashmap
	 */
	private HashMap<String, Component> componentMap;
	
	/** 
	 * Constructor
	 * 
	 * @param frame
	 */
	public GameSelectorPanel(JFrame frame){
		this.frame = frame;
		this.frame.setPreferredSize(new Dimension(1000, 600));
		
		setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		
		JLabel lblTitle = new JLabel("Sixes Wild !");
		lblTitle.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 45));
		
		JLabel lblSelectAGame = new JLabel("Select a Game Mode");
		
		/*
		 * Create the buttons and set name
		 */
		JButton btnPuzzle = new JButton("Puzzle");
		btnPuzzle.setName("Puzzle");
		JButton btnLightning = new JButton("Lightning");
		btnLightning.setName("Lightning");
		JButton btnRelease = new JButton("Release");
		btnRelease.setName("Release");
		JButton btnElimination = new JButton("Elimination");
		btnElimination.setName("Elimination");
		
		/*
		 * Create the choose game controller
		 */
		ChooseGameController gameController = new ChooseGameController(this, btnPuzzle, 
				btnLightning, btnRelease, btnElimination);
		
		/*
		 * Bind the buttons to their controllers
		 */
		btnPuzzle.addActionListener(gameController);
		btnLightning.addActionListener(gameController);
		btnRelease.addActionListener(gameController);
		btnElimination.addActionListener(gameController);
		
		/*
		 * Builder button. 
		 */
		JButton btnLevelBuilder = new JButton("Level Builder");
		btnLevelBuilder.setName("Level Builder");
		StartBuilderController builderStartController  = new StartBuilderController(this,btnLevelBuilder);
		btnLevelBuilder.addActionListener(builderStartController);
		
		
		// Place buttons on correct locations
		// Set layout to grid bag
		this.setLayout(new GridBagLayout());
		
		// Create gridBagContraints for setting location of widgets
		GridBagConstraints c = new GridBagConstraints();
		
		// Place Title
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		this.add(lblTitle, c);
		
		// Place Subtitle
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		c.ipady = 40; // Height in px
		this.add(lblSelectAGame, c);
		
		// Place level buttons
		// Puzzle
		c.gridx = 0; // Column 
		c.gridy = 2; // Row
		c.gridwidth = 1; // Number of columns it spans
		c.ipady = 40; // Height in px
		this.add(btnPuzzle, c);
		
		// Lightning
		c.gridx = 1;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnLightning, c);
		
		// Release
		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnRelease, c);
		
		// Elimination
		c.gridx = 3;
		c.gridy = 2;
		c.gridwidth = 1;
		c.ipady = 40;
		this.add(btnElimination, c);
		
		// Place custom level button
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		c.ipady = 20;
		this.add(btnLevelBuilder, c);
		
		// Add the buttons to the hashmap. This is to make testing easier
		createComponentMap();
	}

	/** 
	 * Returns the parent JFrame
	 */
	@Override
	public JFrame getFrame() {
		return this.frame;
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
	  * Returns a map to the components
	  * 
	  */
	 private void createComponentMap() {
	        componentMap = new HashMap<String,Component>();
	        Component[] components = this.getComponents();
	        for (int i=0; i < components.length; i++) {
	                componentMap.put(components[i].getName(), components[i]);
	        }
	}

	 /**
	  * Returns a given component by name from the hashMap
	  * 
	  * @param name
	  * @return
	  */
	public Component getComponentByName(String name) {
	        if (componentMap.containsKey(name)) {
	                return (Component) componentMap.get(name);
	        }
	        else return null;
	}

}
