package game;

import tile.Tile;

/**
 * This class models the Board that the Players manipulate for the Mr. Jack game.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Board {

	Tile[] start;
	
	public Board(String[] boardDesign) {
		interpretInput(boardDesign[0]);
	}
	
	private Tile interpretInput(String in) {
		return null;
	}
	
	public Tile[] getTiles(char key) {
		
		return null;
	}
	
	public char getTileIdentity(int index) {
		return start[index].getIdentity();
	}
	
	public boolean[] getLitTiles() {
		boolean[] whoIsLit = new boolean[start.length];
		
		
		return whoIsLit;
	}
	
}
