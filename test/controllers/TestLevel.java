package controllers;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.LevelTracker;
import junit.framework.TestCase;
import views.GameSelectorPanel;
import views.LevelPanel;
import views.LevelSelectorPanel;
import views.TileView;

public class TestLevel extends TestCase {
	
	/** Parent Frame */
	JFrame frame;
	
	/** Game Selector Panel */
	GameSelectorPanel gameSelectorPanel;
	
	/** Level Panel */
	LevelPanel levelPanel;
	
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
		
		// Navigate to the first puzzle level
		JButton selectButton = (JButton) this.gameSelectorPanel.getComponentByName("Puzzle");
		assertEquals(selectButton.getText(),"Puzzle");
		selectButton.doClick();
		// Select the first available level
		LevelSelectorPanel lvlPanel = (LevelSelectorPanel) this.frame.getContentPane().getComponent(0);
		assertNotNull(lvlPanel);
		JButton lvlButton = (JButton) lvlPanel.getComponentByName("Level 1");
		assertEquals(lvlButton.getText(),"Level 1");
		lvlButton.doClick();
		
		this.levelPanel = (LevelPanel) this.frame.getContentPane().getComponent(0);
		
		/* Close everything when done */
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/** Tear down the model when done testing */
	protected void tearDown(){
	
		this.frame.dispose();
		
		// Wait 500ms
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
	}
	
	public void testShuffle(){
		JButton shflButton = (JButton) this.levelPanel.getSpecialButtonsPanel().getComponentByName("Shuffle");
		assertNotNull(shflButton);
		shflButton.doClick();
		assertEquals(shflButton.isEnabled(),false);
		this.levelPanel.getModel().updateScore(1000);
		this.levelPanel.getModel().updateMoves(-10);
		this.levelPanel.getModel().checkGameState();
		assertEquals(levelPanel.getModel().getCurrentScore(),1000);
		assertEquals(levelPanel.getModel().getNumMoves(),20);
		
	}
	
	public void testDestroy(){
		
		// Wait 500ms
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		JButton destButton = (JButton) this.levelPanel.getSpecialButtonsPanel().getComponentByName("Destroy");
		assertNotNull(destButton);
		
		DestroyTileController destControl = new DestroyTileController(destButton,
				this.levelPanel.getBoardView(),this.levelPanel.getModel());
		
		destButton.doClick();
		
		TileView destTileView = (TileView) this.levelPanel.getBoardView().getComponentByName("Tile55");
		MouseEvent meMove = new MouseEvent(destTileView, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 
				0,100,100, 0, false);
		
		destControl.mousePressed(meMove);
		
		MouseEvent meEnd = new MouseEvent(destTileView, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 
				0, 100, 100, 0, false);
		
		
		destControl.mouseReleased(meEnd);
		
		

	}
	
	public void testSwap(){
		// Wait 500ms
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		JButton swapButton = (JButton) this.levelPanel.getSpecialButtonsPanel().getComponentByName("Swap");
		assertNotNull(swapButton);
		
		SwapController swapControl = new SwapController(swapButton,
				this.levelPanel.getBoardView(),this.levelPanel.getModel());
		
		swapButton.doClick();
		
		//  Select First Tile
		TileView swap1TileView = (TileView) this.levelPanel.getBoardView().getComponentByName("Tile24");
		MouseEvent meMove = new MouseEvent(swap1TileView, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 
				0, 100, 100, 0, false);
		
		swapControl.mousePressed(meMove);
		
		MouseEvent meEnd = new MouseEvent(swap1TileView, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 
				0, 100, 100, 0, false);
		
		swapControl.mouseReleased(meEnd);
		
		// Wait 500ms
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		// Select Second Tile
		TileView swap2TileView = (TileView) this.levelPanel.getBoardView().getComponentByName("Tile12");
		MouseEvent meMove2 = new MouseEvent(swap2TileView, MouseEvent.MOUSE_PRESSED, System.currentTimeMillis(), 
				0, 200, 300, 0, false);
		
		swapControl.mousePressed(meMove2);
		
		MouseEvent meEnd2 = new MouseEvent(swap2TileView, MouseEvent.MOUSE_RELEASED, System.currentTimeMillis(), 
				0, 200, 300, 0, false);
		
		swapControl.mouseReleased(meEnd2);
		
	}
	
	// Test the menu button
	public void testMenu(){
		// Wait 500ms
		try {
		    Thread.sleep(500);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		
		JButton menuButton = (JButton) this.levelPanel.getMenuButton();
		assertNotNull(menuButton);
		
		menuButton.doClick();
			
	}

	
}
