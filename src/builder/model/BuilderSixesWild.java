package builder.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

import views.TileView;
import model.Board;
import model.Tile;

/**
 * 
 * @author Katie, Paulo
 *
 */
public class BuilderSixesWild {
	
	/** 
	 * Tile to be added
	 * 
	 * Stores the prototype tile that will be added to the board in the builder.
	 */
	Tile toBeAddedTile;
	
	/** 
	 * Stack of Board classes
	 * 
	 * A memento of all previous game states
	 */
	Stack<Board> undoStack;
	
	/**
	 * Stack of Board Classes
	 * 
	 * A memento of all undone states of the game
	 */
	Stack<Board> redoStack;
	
	public BuilderSixesWild(){
		this.undoStack = new Stack<Board>();
		this.redoStack = new Stack<Board>();
	}

	/**
	 * Sets the tile
	 * 
	 * @param t
	 */
	public void setTile(Tile t) {
		this.toBeAddedTile = t;
		
	}
	
	/**
	 * Gets the tile
	 */
	public Tile getTile() {
		return this.toBeAddedTile;
	}
	
	/** 
	 * Create Memento
	 * 
	 * After any undoable action is performed, we add it to the undo stack
	 * 
	 * @param board
	 */
	public boolean createMemento(Board board){
		Board boardClone = (Board)BuilderSixesWild.deepClone(board);
		return this.undoStack.add(boardClone);

	}
	
	/**
	 * Undo Memento
	 * 
	 * Returns the previous state of the game for undoing and adds the current
	 * state of the game to the redo stack.
	 */
	public Board undoMemento(Board board){
		Board boardClone = (Board)BuilderSixesWild.deepClone(board);
		this.redoStack.add(boardClone);
		return this.undoStack.pop();
	}
	
	/**
	 * Performs deep copy of a serializable object
	 */
	public static Object deepClone(Object object) {
	    try {
	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	      ObjectOutputStream oos = new ObjectOutputStream(baos);
	      oos.writeObject(object);
	      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
	      ObjectInputStream ois = new ObjectInputStream(bais);
	      return ois.readObject();
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	      return null;
	    }
	  }
	
}






