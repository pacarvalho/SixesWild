package views;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import controllers.ExitController;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JInternalFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;

/*
 * 
 */

public class BuilderPanel extends JPanel implements IApplication {

	JFrame frame;
	int h=400,w=150;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public BuilderPanel(JFrame frame){
		super();
		this.frame = frame;
		this.frame.setMinimumSize(new Dimension(7*w, 5*w));
		

		/*
		 * Create the board and make it appear
		 */
		
		/* 
		 * Create button to return to main menu and bind it to its controller
		 */
		ExitController exitController = new ExitController(this);
		JButton btnMenu = new JButton("Menu");
		btnMenu.setHorizontalAlignment(SwingConstants.RIGHT);
		btnMenu.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnMenu.setAlignmentY(Component.TOP_ALIGNMENT);
		btnMenu.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnMenu.addActionListener(exitController);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLevelBuilder.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLevelBuilder.setAlignmentY(Component.TOP_ALIGNMENT);
		
		JPanel filePanel = new JPanel();
		filePanel.setAlignmentY(Component.TOP_ALIGNMENT);
		filePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		filePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JLabel lblfilename = new JLabel("fileName");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Mode"}));
		
		JPanel statsPanel = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
									.addGap(215)
									.addComponent(lblfilename, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(297)
									.addComponent(lblLevelBuilder, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
								.addComponent(filePanel, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnMenu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addComponent(statsPanel, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnMenu))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLevelBuilder)
									.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
									.addComponent(lblfilename)))
							.addGap(18)
							.addComponent(filePanel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 196, Short.MAX_VALUE)
							.addComponent(statsPanel, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
							.addGap(72))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 576, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		JLabel lblX = new JLabel("X:");
		panel_2.add(lblX);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblY = new JLabel("Y:");
		panel_2.add(lblY);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		BoardView boardView = new BoardView(this.frame);
		boardView.setToolTipText("");
		boardView.setAlignmentX(Component.RIGHT_ALIGNMENT);
		boardView.setBounds(100, 100, 504, 504);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(boardView, GroupLayout.PREFERRED_SIZE, 513, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(boardView, GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
//		this.add(boardView);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblTimeLimit = new JLabel("Time Limit");
		lblTimeLimit.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblScoreLimit = new JLabel("Score Limit");
		lblScoreLimit.setHorizontalAlignment(SwingConstants.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel.add(textField_2);
		panel.add(textField_3);
		panel.add(lblTimeLimit);
		panel.add(lblScoreLimit);
		statsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblProbabilityOf = new JLabel("Probability of 1");
		statsPanel.add(lblProbabilityOf);
		
		JSlider slider = new JSlider();
		slider.setForeground(Color.CYAN);
		statsPanel.add(slider);
		
		JLabel lblProbabilityOf_1 = new JLabel("Probability of 2");
		statsPanel.add(lblProbabilityOf_1);
		
		JSlider slider_1 = new JSlider();
		statsPanel.add(slider_1);
		
		JLabel lblProbabilityOf_2 = new JLabel("Probability of 3");
		statsPanel.add(lblProbabilityOf_2);
		
		JSlider slider_2 = new JSlider();
		statsPanel.add(slider_2);
		
		JLabel lblProbabilityOf_3 = new JLabel("Probability of 4");
		statsPanel.add(lblProbabilityOf_3);
		
		JSlider slider_3 = new JSlider();
		statsPanel.add(slider_3);
		
		JLabel lblProbabilityOf_4 = new JLabel("Probability of 5");
		statsPanel.add(lblProbabilityOf_4);
		
		JSlider slider_4 = new JSlider();
		statsPanel.add(slider_4);
		
		JLabel lblProbabilityOf_5 = new JLabel("Probability of 6");
		statsPanel.add(lblProbabilityOf_5);
		
		JSlider slider_5 = new JSlider();
		statsPanel.add(slider_5);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filePanel.add(btnNew);
		
		JButton btnOpen = new JButton("Load");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filePanel.add(btnOpen);
		
		JButton btnSave = new JButton("Save");
		filePanel.add(btnSave);
		
		JButton btnReview = new JButton("Review");
		filePanel.add(btnReview);
		
		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		filePanel.add(btnUndo);
		
		JButton btnRedo = new JButton("Redo");
		filePanel.add(btnRedo);
		setLayout(groupLayout);
	

	}

	@Override
	public JFrame getFrame() {
		return this.frame;
	}
}
