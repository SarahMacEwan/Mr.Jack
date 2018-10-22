package tile;

/**
 * This class builds on the Tile abstract class to specifically model a Manhole Tile.
 * 
 * Characters can move through and end on Manhole Tiles.
 * 
 * Characters can travel through the Manhole to teleport to other Manhole Tiles.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Manhole extends Tile{

	public Manhole(Tile t) {
		identity = 'm';
		shareable = true;
		parent = t;
	}
	
}
