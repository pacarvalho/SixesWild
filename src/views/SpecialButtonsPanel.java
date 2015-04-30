package views;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controllers.DestroyTileController;
import controllers.ResetController;
import controllers.SpecialMovesController;
import controllers.SwapController;
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
	
	int height;
	int width;;
	/** GUI widgets used only in this class. */
	JButton btnSpecial1 = null;
	JButton btnSpecial2 = null;
	JButton btnSpecial3 = null;
	
	/** BoardView for setting MouseAdapter*/
	BoardView boardView;
	/** game model*/
	SixesWild model;
	
	
	public SpecialButtonsPanel(BoardView boardView, SixesWild m){
		super();
		
		this.boardView = boardView;
		this.model = m;
		//this.height = H;
		//this.width = W;
		initialize();
		
		
	}
		
		void initialize(){
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			//setSize(width, height);
			
			add(getBtnSpecial1());
			add(getBtnSpecial2());
			add(getBtnSpecial3());
			
			SpecialMovesController specBtnsCtrl = new SpecialMovesController(getBtnSpecial1(),
					getBtnSpecial2(), getBtnSpecial3(), boardView, model);
			getBtnSpecial1().addActionListener(specBtnsCtrl);
			getBtnSpecial2().addActionListener(specBtnsCtrl);
			getBtnSpecial3().addActionListener(specBtnsCtrl);
		}
		public JButton getBtnSpecial1(){
			if(this.btnSpecial1 == null){
				this.btnSpecial1=new JButton();
				this.btnSpecial1.setText("S1");
				//btnSpecial1.setSize(width/3,height);
			}
			return this.btnSpecial1;
		}
		public JButton getBtnSpecial2(){
			if(this.btnSpecial2 == null){
				this.btnSpecial2=new JButton();
				this.btnSpecial2.setText("S2");
				//btnSpecial2.setSize(width/3,height);
			}
			return this.btnSpecial2;
		}
		public JButton getBtnSpecial3(){
			if(this.btnSpecial3 == null){
				this.btnSpecial3=new JButton();
				this.btnSpecial3.setText("S3");
				//btnSpecial3.setSize(width/3,height);
			}
			return this.btnSpecial3;
		}
		
}

