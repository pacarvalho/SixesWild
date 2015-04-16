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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.DefaultComboBoxModel;

/*
 * 
 */

public class BuilderPanel2 extends JPanel implements IApplication{
	public BuilderPanel2() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblFilename = new JLabel("fileName");
		GridBagConstraints gbc_lblFilename = new GridBagConstraints();
		gbc_lblFilename.gridwidth = 2;
		gbc_lblFilename.insets = new Insets(0, 0, 5, 5);
		gbc_lblFilename.gridx = 1;
		gbc_lblFilename.gridy = 0;
		add(lblFilename, gbc_lblFilename);
		
		JLabel lblLevelBuilder = new JLabel("Level Builder");
		lblLevelBuilder.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblLevelBuilder = new GridBagConstraints();
		gbc_lblLevelBuilder.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevelBuilder.gridx = 7;
		gbc_lblLevelBuilder.gridy = 0;
		add(lblLevelBuilder, gbc_lblLevelBuilder);
		
		JButton btnMenu = new JButton("Menu");
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.insets = new Insets(0, 0, 5, 5);
		gbc_btnMenu.gridx = 12;
		gbc_btnMenu.gridy = 0;
		add(btnMenu, gbc_btnMenu);
		
		JButton btnNew = new JButton("N");
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 5, 5);
		gbc_btnNew.gridx = 1;
		gbc_btnNew.gridy = 1;
		add(btnNew, gbc_btnNew);
		
		JButton btnLoad = new JButton("O");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoad.gridx = 2;
		gbc_btnLoad.gridy = 1;
		add(btnLoad, gbc_btnLoad);
		
		JButton btnSave = new JButton("S");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 1;
		add(btnSave, gbc_btnSave);
		
		JButton btnReview = new JButton("R");
		GridBagConstraints gbc_btnReview = new GridBagConstraints();
		gbc_btnReview.insets = new Insets(0, 0, 5, 5);
		gbc_btnReview.gridx = 4;
		gbc_btnReview.gridy = 1;
		add(btnReview, gbc_btnReview);
		
		JButton btnUndo = new JButton("Un");
		GridBagConstraints gbc_btnUndo = new GridBagConstraints();
		gbc_btnUndo.insets = new Insets(0, 0, 5, 5);
		gbc_btnUndo.gridx = 5;
		gbc_btnUndo.gridy = 1;
		add(btnUndo, gbc_btnUndo);
		
		JButton btnRedo = new JButton("Re");
		GridBagConstraints gbc_btnRedo = new GridBagConstraints();
		gbc_btnRedo.insets = new Insets(0, 0, 5, 5);
		gbc_btnRedo.gridx = 6;
		gbc_btnRedo.gridy = 1;
		add(btnRedo, gbc_btnRedo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Mode"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 3;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 3;
		add(comboBox, gbc_comboBox);
		
		JLabel lblX = new JLabel("X:");
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 2;
		gbc_lblX.gridy = 4;
		add(lblX, gbc_lblX);
		
		JLabel lblProbabilityOf = new JLabel("Probability of 1");
		GridBagConstraints gbc_lblProbabilityOf = new GridBagConstraints();
		gbc_lblProbabilityOf.insets = new Insets(0, 0, 5, 5);
		gbc_lblProbabilityOf.gridx = 1;
		gbc_lblProbabilityOf.gridy = 11;
		add(lblProbabilityOf, gbc_lblProbabilityOf);
		
		JLabel lblProbabilityOf_1 = new JLabel("Probability of 2");
		GridBagConstraints gbc_lblProbabilityOf_1 = new GridBagConstraints();
		gbc_lblProbabilityOf_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblProbabilityOf_1.gridx = 2;
		gbc_lblProbabilityOf_1.gridy = 11;
		add(lblProbabilityOf_1, gbc_lblProbabilityOf_1);
		
		JLabel lblProbabilityOf_2 = new JLabel("Probability of 3");
		GridBagConstraints gbc_lblProbabilityOf_2 = new GridBagConstraints();
		gbc_lblProbabilityOf_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblProbabilityOf_2.gridx = 3;
		gbc_lblProbabilityOf_2.gridy = 11;
		add(lblProbabilityOf_2, gbc_lblProbabilityOf_2);
		
		JLabel lblProbabilityOf_3 = new JLabel("Probability of 4");
		GridBagConstraints gbc_lblProbabilityOf_3 = new GridBagConstraints();
		gbc_lblProbabilityOf_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblProbabilityOf_3.gridx = 4;
		gbc_lblProbabilityOf_3.gridy = 11;
		add(lblProbabilityOf_3, gbc_lblProbabilityOf_3);
		
		JLabel lblProbabilityOf_4 = new JLabel("Probability of 5");
		GridBagConstraints gbc_lblProbabilityOf_4 = new GridBagConstraints();
		gbc_lblProbabilityOf_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblProbabilityOf_4.gridx = 5;
		gbc_lblProbabilityOf_4.gridy = 11;
		add(lblProbabilityOf_4, gbc_lblProbabilityOf_4);
		
		JLabel lblProbabilityOf_5 = new JLabel("Probability of 6");
		GridBagConstraints gbc_lblProbabilityOf_5 = new GridBagConstraints();
		gbc_lblProbabilityOf_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblProbabilityOf_5.gridx = 6;
		gbc_lblProbabilityOf_5.gridy = 11;
		add(lblProbabilityOf_5, gbc_lblProbabilityOf_5);
		
		JSlider slider_1 = new JSlider();
		GridBagConstraints gbc_slider_1 = new GridBagConstraints();
		gbc_slider_1.insets = new Insets(0, 0, 0, 5);
		gbc_slider_1.gridx = 1;
		gbc_slider_1.gridy = 12;
		add(slider_1, gbc_slider_1);
		
		JSlider slider_3 = new JSlider();
		GridBagConstraints gbc_slider_3 = new GridBagConstraints();
		gbc_slider_3.insets = new Insets(0, 0, 0, 5);
		gbc_slider_3.gridx = 2;
		gbc_slider_3.gridy = 12;
		add(slider_3, gbc_slider_3);
		
		JSlider slider_4 = new JSlider();
		GridBagConstraints gbc_slider_4 = new GridBagConstraints();
		gbc_slider_4.insets = new Insets(0, 0, 0, 5);
		gbc_slider_4.gridx = 3;
		gbc_slider_4.gridy = 12;
		add(slider_4, gbc_slider_4);
		
		JSlider slider_5 = new JSlider();
		GridBagConstraints gbc_slider_5 = new GridBagConstraints();
		gbc_slider_5.insets = new Insets(0, 0, 0, 5);
		gbc_slider_5.gridx = 4;
		gbc_slider_5.gridy = 12;
		add(slider_5, gbc_slider_5);
		
		JSlider slider_6 = new JSlider();
		GridBagConstraints gbc_slider_6 = new GridBagConstraints();
		gbc_slider_6.insets = new Insets(0, 0, 0, 5);
		gbc_slider_6.gridx = 5;
		gbc_slider_6.gridy = 12;
		add(slider_6, gbc_slider_6);
		
		JSlider slider_7 = new JSlider();
		GridBagConstraints gbc_slider_7 = new GridBagConstraints();
		gbc_slider_7.insets = new Insets(0, 0, 0, 5);
		gbc_slider_7.gridx = 6;
		gbc_slider_7.gridy = 12;
		add(slider_7, gbc_slider_7);
	}

	@Override
	public JFrame getFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
