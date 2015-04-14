package views;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Application extends JFrame{
	
	public Application(JFrame frame){
		initializeMainScreen(frame);
	}
	
	public void initializeMainScreen(JFrame frame){
		MainPanel p = new MainPanel(frame);
		PuzzleLevelPanel puzzleLevels = new PuzzleLevelPanel();
		frame.getContentPane().add(p);
		frame.setBounds(50, 50, 450, 300);
		frame.setVisible(true);
		
	}
	
}
