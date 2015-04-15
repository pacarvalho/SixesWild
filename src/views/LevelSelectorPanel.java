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
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import controllers.ChooseLevelController;

import java.awt.Component;

public class LevelSelectorPanel extends JPanel implements IApplication{
	JFrame frame;
	Image background;
	public LevelSelectorPanel(JFrame frame, String title) {
		
		this.frame = frame;
		
		JLabel lblSelectLevel = new JLabel(title);
		lblSelectLevel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 45));
		
		JLabel lblPuzzleLevels = new JLabel("Select Level ");
		
		/*
		 * Create the buttons and bind them to their controllers
		 */
		
		JButton btnLevel1 = new JButton("Level 1");
		JButton btnLevel2 = new JButton("Level 2");
		JButton btnLevel3 = new JButton("Level 3");
		JButton btnLevel4 = new JButton("Level 4");
		
		ChooseLevelController chooseLevelController = new ChooseLevelController(this, btnLevel1, btnLevel2,
				btnLevel3, btnLevel4, title);
		
		btnLevel1.addActionListener(chooseLevelController);
		btnLevel2.addActionListener(chooseLevelController);
		btnLevel3.addActionListener(chooseLevelController);
		btnLevel4.addActionListener(chooseLevelController);
		
		
		
		/*
		 * Automatically generated code
		 */
		
		JButton btnNewButton = new JButton("Choose Your Own !");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnLevel1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnLevel2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(btnLevel3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(btnLevel4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(140)
							.addComponent(btnNewButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(181)
							.addComponent(lblPuzzleLevels))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(lblSelectLevel, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(17)
					.addComponent(lblSelectLevel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPuzzleLevels)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLevel1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLevel4, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton)
					.addContainerGap(55, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
	
	@Override
	public JFrame getFrame() {
		return this.frame;
	}

}
