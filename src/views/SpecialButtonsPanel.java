package views;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import controllers.SpecialMovesController;
import model.SixesWild;

/**
 * 
 * @author Ozan
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
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		add(getBtnSpecial1());
		add(getBtnSpecial2());
		add(getBtnSpecial3());
		
		SpecialMovesController specBtnsCtrl = new SpecialMovesController(getBtnSpecial1(),
				getBtnSpecial2(), getBtnSpecial3(), boardView, model);
		getBtnSpecial1().addActionListener(specBtnsCtrl);
		getBtnSpecial2().addActionListener(specBtnsCtrl);
		getBtnSpecial3().addActionListener(specBtnsCtrl);
	}
	
	/**
	 * Creates the button for swapping tiles
	 * 
	 * @return
	 */
	public JButton getBtnSpecial1(){
		if(this.btnSpecial1 == null){
			this.btnSpecial1 = new JButton();
			this.btnSpecial1.setText("SW");
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
			this.btnSpecial2.setText("EL");
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
			this.btnSpecial3.setText("RE");
		}
		return this.btnSpecial3;
	}
		
}

