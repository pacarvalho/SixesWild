package views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class PuzzleLevelPanel extends JPanel{
	JFrame frame;
	public PuzzleLevelPanel() {
		JLabel lblPuzzleLevels = new JLabel("Puzzle Levels !");
		lblPuzzleLevels.setFont(new Font("Chalkboard", Font.PLAIN, 50));
		add(lblPuzzleLevels);
	}
	
}
