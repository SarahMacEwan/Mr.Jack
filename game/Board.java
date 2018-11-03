package game;

import tile.Tile;

/**
 * This class models the Board that the Players manipulate for the Mr. Jack game.
 * 
 * TODO: Should really be an interface between this and GameModel
 * TODO: Cause then new kinds of tiles and interpreting them would be a new Board, cause that is a significant enough change 
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Board {
	
//---  Instance Variables   -------------------------------------------------------------------

	/** Tile[] object containing a list of Tile objects representing the Mr. Jack game's board*/
	Tile[] start;
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for Board objects that derives the contents of its Tile[] from the provided
	 * information in the format of individual String objects.
	 * 
	 * @param boardDesign - String[] object describing 
	 */
	
	public Board(String[] boardDesign) {
		interpretInput(boardDesign[0]);
	}
	
//---  Getter Methods   -----------------------------------------------------------------------

	/**
	 * 
	 * @param key
	 * @return
	 */
	
	public Tile[] getTiles(char key) {
		
		return null;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	
	public char getTileIdentity(int index) {
		return start[index].getIdentity();
	}

	/**
	 * 
	 * 
	 * @return
	 */
	
	public boolean[] getLitTiles() {
		boolean[] whoIsLit = new boolean[start.length];
		
		
		return whoIsLit;
	}

//---  Helper Methods   ---------------------------------------------------------------------------
	
	/**
	 * 
	 * 
	 * @param in
	 * @return
	 */
	
	private Tile interpretInput(String in) {
		return null;
	}
	
}