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

	public Building(Tile t) {
		identity = 'b';
		parent = t;
		shareable = false;
	}
	
}
