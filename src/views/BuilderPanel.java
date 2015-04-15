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
		this.frame.setMinimumSize(new Dimension(6*w, 5*w));
		

		/*
		 * Create the board and make it appear
		 */
		BoardView boardView = new BoardView(this.frame);
		boardView.setToolTipText("");
		boardView.setAlignmentX(Component.RIGHT_ALIGNMENT);
		boardView.setBounds(100, 100, 504, 504);
		this.add(boardView);
		
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
		
		JLabel lblX = new JLabel("X:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblY = new JLabel("Y:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JPanel statsPanel = new JPanel();
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(273)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblLevelBuilder, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(180))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(24)
									.addComponent(lblfilename, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(202)))
							.addComponent(btnMenu))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(statsPanel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 112, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblX)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblY)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))))
						.addComponent(filePanel, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(17)
							.addComponent(btnMenu))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblLevelBuilder)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblfilename)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(filePanel, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
					.addComponent(statsPanel, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
		);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		JSlider slider = new JSlider();
		statsPanel.add(slider);
		
		JSlider slider_1 = new JSlider();
		statsPanel.add(slider_1);
		
		JSlider slider_2 = new JSlider();
		statsPanel.add(slider_2);
		
		JSlider slider_3 = new JSlider();
		statsPanel.add(slider_3);
		
		JSlider slider_4 = new JSlider();
		statsPanel.add(slider_4);
		
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
