package views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Model;

public class SpecialButtonsPanel extends JPanel {

	//Model model;
	int height;
	int width;;
	/** GUI widgets used only in this class. */
	JButton btnSpecial1 = null;
	JButton btnSpecial2 = null;
	JButton btnSpecial3 = null;
	
	Model model;
	
	public SpecialButtonsPanel(Model m){
		super();
		
		this.model = m;
		//this.height = H;
		//this.width = W;
		initialize();
		
		
	}
		
		void initialize(){
			setLayout(new FlowLayout(FlowLayout.RIGHT));
			//setSize(width, height);
			
			add(getBtnSpecial3());
			add(getBtnSpecial2());
			add(getBtnSpecial1());
		}
		public JButton getBtnSpecial1(){
			if(btnSpecial1 == null){
				btnSpecial1=new JButton();
				btnSpecial1.setText("S1");
				//btnSpecial1.setSize(width/3,height);
			}
			return btnSpecial1;
		}
		public JButton getBtnSpecial2(){
			if(btnSpecial2 == null){
				btnSpecial2=new JButton();
				btnSpecial2.setText("S2");
				//btnSpecial2.setSize(width/3,height);
			}
			return btnSpecial2;
		}
		public JButton getBtnSpecial3(){
			if(btnSpecial3 == null){
				btnSpecial3=new JButton();
				btnSpecial3.setText("S3");
				//btnSpecial3.setSize(width/3,height);
			}
			return btnSpecial3;
		}
		
}

