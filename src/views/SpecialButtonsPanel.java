package views;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


import controllers.DestroyTileController;
import controllers.ResetController;
import controllers.SwapController;
import model.SixesWild;

/**
 * 
 * @author OAkyildiz
 *
 */
public class SpecialButtonsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4492642561373155028L;

	/** GUI widgets used only in this class. */
	JButton btnSpecial1 = null;
	JButton btnSpecial2 = null;
	JButton btnSpecial3 = null;
	
	/** BoardView for setting MouseAdapter*/
	BoardView boardView;
	
	/** game model*/
	SixesWild model;
	
	/**
	 * Constructor
	 * 
	 * @param boardView
	 * @param m
	 */
	public SpecialButtonsPanel(BoardView boardView, SixesWild m){
		super();
		
		this.boardView = boardView;
		this.model = m;
		initialize();
		
	}
	
	/**
	 * Creates and organizes the panel
	 */
	void initialize(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//add buttons to the panel
		add(getBtnSpecial1());
		add(getBtnSpecial2());
		add(getBtnSpecial3());
		
		//Instantiate controllers
		SwapController swapper = new SwapController(getBtnSpecial1(),boardView, model);
		DestroyTileController destroyer = new DestroyTileController(getBtnSpecial2(), boardView, model);
		ResetController shuffler = new ResetController(btnSpecial3, boardView, model);
		
		// Assign controllers to buttons
		getBtnSpecial1().addActionListener(swapper);
		getBtnSpecial2().addActionListener(destroyer);
		getBtnSpecial3().addActionListener(shuffler);
	}
	
	/**
	 * Creates the button for swapping tiles
	 * 
	 * @return
	 */
	public JButton getBtnSpecial1(){
		if(this.btnSpecial1 == null){
			this.btnSpecial1 = new JButton();
			this.btnSpecial1.setBackground(Color.WHITE);
			this.btnSpecial1.setIcon(new ImageIcon("resources/Swap.gif"));
			this.btnSpecial1.setText("" + model.getSpecQuotas(0));
		}
		return this.btnSpecial1;
	}
	
	/**
	 * Creates the button for eliminating tiles
	 * 
	 * @return
	 */
	public JButton getBtnSpecial2(){
		if(this.btnSpecial2 == null){
			this.btnSpecial2 = new JButton();
			this.btnSpecial2.setBackground(Color.WHITE);
			this.btnSpecial2.setIcon(new ImageIcon("resources/Destroy.gif"));
			this.btnSpecial2.setText("" + model.getSpecQuotas(1));
		}
		return this.btnSpecial2;
	}
	
	/**
	 * Creates the button for reseting board
	 * 
	 * @return
	 */
	public JButton getBtnSpecial3(){
		if(this.btnSpecial3 == null){
			this.btnSpecial3 = new JButton();
			this.btnSpecial3.setBackground(Color.WHITE);
			this.btnSpecial3.setIcon(new ImageIcon("resources/Shuffle.gif"));
			this.btnSpecial3.setText("" + model.getSpecQuotas(2));
		}
		return this.btnSpecial3;
	}
		
}

