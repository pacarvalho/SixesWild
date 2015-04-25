package model;

import java.awt.Point;

public class MutableTile extends Tile {
	
	protected Point location;
	protected int value; //static?
	protected int bonus;
	
	public MutableTile(int val, int bonus){
		/*
		 * 
		 * 
		 * 
		 */
		this.value=val;
		this.bonus=bonus;
	}
	
}
