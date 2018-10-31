package tile;

/**
 * This class builds on the Tile abstract class to specifically model a Lantern Tile.
 * 
 * Characters cannot move through Lantern Tiles.
 * 
 * The Clock and some Characters can control the state of the Lantern.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Lantern extends Tile{

	boolean isOn;
	
	public Lantern(Tile t) {
		identity = 'l';
		shareable = false;
		parent = t;
	}
	
	public boolean getLight() {
		return isOn;
	}
	
	public void setLight(boolean val) {
		isOn = val;
	}
	
}
