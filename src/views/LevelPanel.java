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
		super();
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(700, 700));
		
		JLabel lblTitle = new JLabel("gameMode");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel(title);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblTime = new JLabel("time");
		
		JLabel lblScore = new JLabel("score");
		
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
		
		JButton btnSpecial3 = new JButton("S3");
		
		JButton btnSpecial2 = new JButton("S2");
		
		JButton btnSpecial1 = new JButton("S1");
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(263)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(224))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(205)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
							.addGap(164)))
					.addComponent(btnMenu)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblTime)
					.addPreferredGap(ComponentPlacement.RELATED, 512, Short.MAX_VALUE)
					.addComponent(lblScore)
					.addGap(45))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(471, Short.MAX_VALUE)
					.addComponent(btnSpecial1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSpecial2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnSpecial3)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnMenu)
								.addComponent(lblTitle))
							.addGap(38)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTime)
								.addComponent(lblScore))
							.addPreferredGap(ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSpecial3)
								.addComponent(btnSpecial2)
								.addComponent(btnSpecial1)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel)))
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
	public Dimension getThisMinimumSize() {
		return getMinimumSize();
	}
	public void setThisMinimumSize(Dimension minimumSize) {
		setMinimumSize(minimumSize);
	}
}
