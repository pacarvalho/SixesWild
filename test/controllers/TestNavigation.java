package controllers;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import model.LevelTracker;
import builder.views.BuilderGameSelectorPanel;
import views.GameSelectorPanel;
import views.LevelSelectorPanel;
import junit.framework.TestCase;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Test Cases for the board navigation
 * 
 * 
 * @author Sean
 *
 */

public class TestNavigation extends TestCase {
	
	/** Parent Frame */
	JFrame frame;
	
	/** Game Selector Panel */
	GameSelectorPanel gameSelectorPanel;
	
	@Override
	protected void setUp(){
		
		// Serialize a new level tracker to ensure all levels are unlocked at the beginning of this test
		LevelTracker lt = new LevelTracker();
		for (int i=0;i<4;i++){
			lt.eliminationLocked[i] = false;
			lt.puzzleLocked[i] = false;
			lt.releaseLocked[i] = false;
			lt.lightningLocked[i] = false;
		}
		
		try{
			this.serialize(lt, "resources/levels/level_tracker.txt");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		this.frame = new JFrame();
		this.gameSelectorPanel = new GameSelectorPanel(this.frame);

		/* Set Frame Attributes */
		this.frame.setTitle("SixesWild");
		
		/* After splash vanishes, show the game selector menu */
		this.frame.getContentPane().add(this.gameSelectorPanel);
		this.frame.setBounds(100, 100, 1200, 1200);
		this.frame.pack();
		this.frame.setVisible(true);
		
		
		/* Close everything when done */
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** Tear down the model when done testing */
	@Override
	protected void tearDown(){
		
		try{
			this.serialize(new LevelTracker(), "resources/levels/level_tracker.txt");
		} catch (IOException e){
			e.printStackTrace();
		}
		
		this.frame.dispose();
	}
	
	public void testSelectLightning(){
		
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Lightning");
		assertEquals(selectButton.getText(),"Lightning");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 1");
		assertEquals(lvlButton.getText(),"Level 1");
		lvlButton.doClick();
		
	}
	
	public void testSelectPuzzle(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Puzzle");
		assertEquals(selectButton.getText(),"Puzzle");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 1");
		assertEquals(lvlButton.getText(),"Level 1");
		lvlButton.doClick();
	}
	
	public void testSelectElimination(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Elimination");
		assertEquals(selectButton.getText(),"Elimination");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 1");
		assertEquals(lvlButton.getText(),"Level 1");
		lvlButton.doClick();
	}
	
	public void testSelectRelease(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Release");
		assertEquals(selectButton.getText(),"Release");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 1");
		assertEquals(lvlButton.getText(),"Level 1");
		lvlButton.doClick();
	}
	
	public void testSelectSecond(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Puzzle");
		assertEquals(selectButton.getText(),"Puzzle");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 2");
		assertEquals(lvlButton.getText(),"Level 2");
		lvlButton.doClick();
	}
	
	public void testSelectThird(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Puzzle");
		assertEquals(selectButton.getText(),"Puzzle");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 3");
		assertEquals(lvlButton.getText(),"Level 3");
		lvlButton.doClick();
	}
	
	public void testSelectFourth(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Puzzle");
		assertEquals(selectButton.getText(),"Puzzle");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 4");
		assertEquals(lvlButton.getText(),"Level 4");
		lvlButton.doClick();
	}
	
	public void testSelectBuilder(){
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Level Builder");
		assertEquals(selectButton.getText(),"Level Builder");
		selectButton.doClick();
		
		BuilderGameSelectorPanel gamePanel = (BuilderGameSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(gamePanel);
		JButton lvlButton = (JButton) gamePanel.getComponentByName("Puzzle");
		assertEquals(lvlButton.getText(),"Puzzle");
		lvlButton.doClick();
		
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
	
}
