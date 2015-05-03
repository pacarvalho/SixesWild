package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;








import javax.swing.JButton;

import views.BoardView;
import views.TileView;
import model.DestroyTileSpecialMove;
import model.SixesWild;
import model.Tile;
/**
 * Handles the mouse events for DestroyTile  which is activated by button click.
 * Creates, validates and realizes the move.
 * 
 * @author OAkyildiz
 *
 */
public class DestroyTileController extends MouseAdapter implements ActionListener{

	/** Stores the BoardView */
	BoardView boardView;
	
	/** Game Model */
	SixesWild model;

	/**Button to control*/
	JButton destroyBtn;
	
	/**Selected Tile */
	Tile tile;
	
	/**
	 * Constructor
	 * @param destroyBtn 
	 * 
	 * @param boardView
	 * @param model
	 */
	public DestroyTileController(JButton destroyBtn, BoardView boardView, SixesWild model ){
		
		this.model = model;
		this.boardView = boardView;
		this.destroyBtn = destroyBtn;
		this.tile = null;
		
	}
	
	/**
	 * Change to this mouseAdapter on button click,
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(model.getSpecQuotas(1) != 0){
			this.register();
			this.destroyBtn.setBackground(Color.GRAY);
			tile = null;
		}
		
	}
	
	/**
	 * Selects a tile on mouse press.
	 * 
	 */
	@Override
	public void mousePressed(MouseEvent me){
		if (me.getModifiers() == MouseEvent.BUTTON3_MASK) { 
			
			tile.setSelectedFlag(false);
			boardView.updateBoardView();
			this.unregister();
			this.destroyBtn.setBackground(Color.LIGHT_GRAY);
			
			return;
			
		}
		else this.selectTile(me.getX(), me.getY());
	}
	
	
	/**
	 * On mouse press performs the move if ready
	 * On right click, Cancels the move and switches to boardView MouseAdatper
	 * 
	 */
	@Override
	public void mouseReleased(MouseEvent me){
		
		// cancel move on right click)
	
		
		if(tile != null){
			System.out.println("Tile selected");
			DestroyTileSpecialMove move = new DestroyTileSpecialMove(tile, this.model);
				
			//Perform and update remaining moves
			if(move.doMove()){
				model.changeSpecQuotas(1, -1);
				this.destroyBtn.setText("" + model.getSpecQuotas(1));
				
				if(model.getSpecQuotas(1) < 1)
					this.destroyBtn.setEnabled(false);
					
					this.destroyBtn.repaint();
			}
			this.destroyBtn.setBackground(Color.WHITE);
				
			// Tell the board to update itself such that changes in tiles are relfected in GUI
			boardView.updateBoardView();
				
			//clear tile
			//Change MosueAdapter
			
			this.unregister();
		}
		
	}
	
	/**
	 * Tries to select a tile on mouseClicked location
	 * 
	 * @param clickX
	 * @param clickY
	 * @return
	 */
	private boolean selectTile(int clickX, int clickY){
		
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				TileView tView = boardView.getTileView(i, j);
				if(tView.isSelected(clickX, clickY)){
					this.tile=tView.getTile();
					tView.getTile().setSelectedFlag(true);
					tView.update();
					return true;
				}
			}
		}
		//no tile selected
		return false;	
	}
	/**
	 * Activates this mouse adapter to create move
	 */
	public void register(){
		boardView.setActiveAdapter(this);
	}
	/**
	 * switches to boardView MouseAdatper
	 */
	 
	public void unregister(){
		boardView.setActiveAdapter(new BoardController(boardView, model));
	}
	
	
}