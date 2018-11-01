package tile;

/**
 * This class builds on the Tile abstract class to specifically model a Building Tile.
 * 
 * Characters cannot move through Building Tiles.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Building extends Tile{

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Building type that assigns values to the instance variables
	 * described in the extended abstract class Tile to denote the identity and that a Character
	 * cannot stand on it.
	 * 
	 */
	
	public Building(int loc) {
		identity = 'b';
		shareable = false;
		location = loc;
	}
	
}
