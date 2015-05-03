package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;







import javax.swing.JButton;

import views.BoardView;
import views.TileView;
import model.SixesWild;
import model.SwapSpecialMove;
import model.Tile;
/**
 * 
 * @author OAkyildiz
 *
 */
public class SwapController extends MouseAdapter implements ActionListener{

	/** Stores the BoardView */
	BoardView boardView;
	
	/** Game Model */
	SixesWild model;
	
	/**Button of the controller*/
	JButton swapBtn;
	
	/** First selected Tile */
	Tile tile1;
	
	/** Second selected Tile */
	Tile tile2;
	 
	/**
	 * 
	 * @param jButton 
	 * @param boardView
	 * @param model
	 */
	public SwapController(JButton swapBtn, BoardView boardView, SixesWild model ){
		
		this.swapBtn = swapBtn;
		this.model = model;
		this.boardView = boardView;
		
		tile1 = null;
		tile2 = null;
		
	}
	
	/**
	 * Change to this mouseAdapter on button click,
	 */
	public void actionPerformed(ActionEvent e) {
		if(model.getSpecQuotas(0) != 0){
			this.register();
			this.swapBtn.setBackground(Color.GRAY);
			tile1 = null;
			tile2 = null;
			
		}
	}
	
	/**
	 *  Selects tiles on mouse press,
	 *  
	 *  On right click de-selects tiles and switches 
	 *  to default MouseAdapter.
	 * 
	 */
	public void mousePressed(MouseEvent me){
		// cancel move on right click)
				if (me.getModifiers() == MouseEvent.BUTTON3_MASK) { 
					
					this.unregister();
					System.out.println("right click");
					
					this.swapBtn.setBackground(Color.LIGHT_GRAY);
					boardView.updateBoardView();

			}
				this.selectTile(me.getX(), me.getY());
	}
	/**
	 * a performs the move if ready
	 * 
	 */
	@Override
	public void mouseReleased(MouseEvent me){
		
		
		
		if(tile2!=null){
				
				SwapSpecialMove move = new SwapSpecialMove(tile1,tile2,  model);
				
				//Perform and update if valid
				if(move.doMove()){
					model.changeSpecQuotas(0, -1);
					System.out.println("SwapQuoata:" + model.getSpecQuotas(0));
					this.swapBtn.setText("" + model.getSpecQuotas(0));
					
					if(model.getSpecQuotas(0) < 1);
						this.swapBtn.setEnabled(false);
						
						this.swapBtn.repaint();
				}
				this.swapBtn.setBackground(Color.WHITE);
				
				// Tell the board to update itself such that changes in tiles are reflected in GUI
				boardView.updateBoardView();
				
				//clear tile
				tile1.setSelectedFlag(false);
				tile2.setSelectedFlag(false);
				//Change MosueAdapter
				this.unregister();

		}
		
	}
	//TODO rightClick to cancel change controller

	
	private boolean selectTile(int clickX, int clickY){
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TileView tView = boardView.getTileView(i, j);
				if(tView.isSelected(clickX, clickY)){
					if(tile1 == null && tView.getTile().getValue() > 0){
						
						tile1 = tView.getTile();
						System.out.println(tile1.getValue());
						tile1.setSelectedFlag(true);
						tView.update();
						return false;
						
						}
					else if(tile1 !=  tView.getTile()){
						
						tile2 =  tView.getTile();
						System.out.println(tile2.getValue());
						tile2.setSelectedFlag(true);
						tView.update();
						
						return true;
					}
				}
			}
		}
		//no tile selected
				return false;
	}
	/**
	 * Change to this mouseAdapter on button click,
	 */
	
	
	public void register(){
		boardView.setActiveAdapter(this);
	}

	
	public void unregister(){
		boardView.setActiveAdapter(new BoardController(boardView, model));
	}
	
}