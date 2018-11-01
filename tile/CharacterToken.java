package tile;

/**
 * This class builds on the Tile abstract class to specifically model a Character Tile.
 * 
 * Characters have special abilities.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class CharacterToken extends Tile{

	int maxMoves;
	boolean isSuspect;
	String name;
	String ability;
	
	public CharacterToken(Tile t) {
		identity = 'c';
		shareable = true;
		parent = t;
	}
	
}
