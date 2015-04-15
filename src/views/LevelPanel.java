package views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import controllers.ExitController;
import javax.swing.SwingConstants;

/*
 * 
 */
public class LevelPanel extends JPanel implements IApplication{
	
	JFrame frame;
	
	public LevelPanel(JFrame frame, String title){
		
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(700, 700));
		JLabel lblTitle = new JLabel("gameMode");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("time");
		
		JLabel lblNewLabel_2 = new JLabel("score");
		
		/* 
		 * Create button to return to main menu and bind it to its controller
		 */
		JButton btnMenu = new JButton("Menu");
		ExitController exitController = new ExitController(this);
		btnMenu.addActionListener(exitController);
		
		/*
		 * Create the board and make it appear
		 */
		BoardView boardView = new BoardView(this.frame);
		boardView.setBounds(100, 100, 504, 504);
		this.add(boardView);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(54)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(lblTitle)
							.addPreferredGap(ComponentPlacement.RELATED, 178, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel)
							.addGap(93)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMenu)
					.addGap(17))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, 318, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addGap(45))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTitle)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMenu)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_2))
					.addContainerGap(235, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
