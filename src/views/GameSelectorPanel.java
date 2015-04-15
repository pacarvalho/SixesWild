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

import controllers.ChooseGameController;


public class GameSelectorPanel extends JPanel implements IApplication{
	JFrame frame;
	
	public GameSelectorPanel(JFrame frame){
		this.frame = frame;
		setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		
		JLabel lblNewLabel = new JLabel("Sixes Wild ! ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 45));
		
		JLabel lblSelectAGame = new JLabel("Select a Game Mode : ");
		
		/*
		 * Create the buttons
		 */
		JButton btnPuzzle = new JButton("Puzzle");
		JButton btnLightning = new JButton("Lightning");
		JButton btnRelease = new JButton("Release");
		JButton btnElimination = new JButton("Elimination");
		
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
		 * Auto generated code
		 */
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(103)
					.addComponent(lblNewLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(161)
					.addComponent(lblSelectAGame))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(12)
					.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(36)
					.addComponent(lblNewLabel)
					.addGap(6)
					.addComponent(lblSelectAGame)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPuzzle, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLightning, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnRelease, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnElimination, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblSelectAGame, btnPuzzle, btnLightning, btnRelease, btnElimination}));
	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
	
	
	
}
