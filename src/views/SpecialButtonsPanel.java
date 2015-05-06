package views;

import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;

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
	 * Serial ID
	 */
	private static final long serialVersionUID = -4492642561373155028L;

	/** GUI widgets used only in this class. */
	JButton btnSpecial1 = null;
	JButton btnSpecial2 = null;
	JButton btnSpecial3 = null;
	
	/**
	 * Hashmap of all components
	 */
	private HashMap<String, Component> componentMap;
	
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
		
		// Add the buttons to the hashmap. This is to make testing easier
		createComponentMap();
		
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
			this.btnSpecial1.setName("Swap");
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
			this.btnSpecial2.setName("Destroy");
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
			this.btnSpecial3.setName("Shuffle");
		}
		return this.btnSpecial3;
	}
	
	
	 /**
	  * Create hashmap of components (buttons) on the panel
	  */
	 private void createComponentMap() {
	        componentMap = new HashMap<String,Component>();
	        Component[] components = this.getComponents();
	        for (int i=0; i < components.length; i++) {
	                componentMap.put(components[i].getName(), components[i]);
	        }
	}
	 
	 /**
	  * Get a component by its name
	  */
	public Component getComponentByName(String name) {
	        if (componentMap.containsKey(name)) {
	                return (Component) componentMap.get(name);
	        }
	        else return null;
	}
		
}

