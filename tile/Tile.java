package tile;

/**
 * This class generically models a Tile object, of which the Board is composed.
 * 
 * There are many sub-types of Tiles
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public abstract class Tile {
	
	int[] neighbors;			//Six neighbors maximum, index denotes location relationally, null is no Tile.
	Tile parent;
	char identity;
	boolean shareable;
	
	public int[] getNeighbors() {
		return neighbors;
	}
	
	public void assignNeighbors(int[] in) {
		neighbors = in;
	}
	
	public char getIdentity() {
		return identity;
	}
	
	public boolean canShare() {
		return shareable;
	}
}
