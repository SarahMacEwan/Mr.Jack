package tile;

/**
 * This class builds on the Tile abstract class to specifically model an Exit Tile.
 * 
 * The Mr. Jack Character can escape through the Exit Tiles.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Exit extends Tile{

	boolean blocked;
	
	public Exit(Tile t) {
		identity = 'e';
		shareable = true;
		parent = t;
	}
	
	public void setBlocked(boolean val) {
		blocked = val;
	}
	
	public boolean getBlocked() {
		return blocked;
	}
	
}
