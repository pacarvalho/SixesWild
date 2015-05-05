package controllers;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

import builder.views.BuilderGameSelectorPanel;
import views.GameSelectorPanel;
import views.LevelSelectorPanel;
import junit.framework.TestCase;

import java.awt.event.MouseEvent;

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
	
	protected void setUp(){
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
	protected void tearDown(){
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
	
}
