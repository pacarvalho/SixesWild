package model;

import java.util.ArrayList;

public class EliminationMove implements IMove {
	
	ArrayList<Tile> tiles;
	SixesWild model;
	
	public EliminationMove(ArrayList<Tile> tiles, SixesWild model){
		this.tiles = tiles;
		this.model = model;
	}

	@Override
	public boolean doMove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean valid() {
		// TODO Auto-generated method stub
		return false;
	}

}
