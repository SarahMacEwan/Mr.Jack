package tile;

/**
 * This class builds on the Tile abstract class to specifically model a Character Tile.
 * 
 * Characters have special abilities.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Character extends Tile{

	public Character(Tile t) {
		identity = 'c';
		shareable = true;
		parent = t;
	}
	
}
