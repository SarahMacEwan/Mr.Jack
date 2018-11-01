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

//---  Instance Variables   -------------------------------------------------------------------
	
	/** boolean value describing the status of this Lantern object's being lit or not.*/
	boolean isOn;
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the Lantern type that assigns values to the instance variables
	 * described in the extended abstract class Tile to denote the identity and that a Character
	 * cannot stand on it; it also defaults the nature of this object's being lit as false.
	 * 
	 */
	
	public Lantern(int loc) {
		identity = 'l';
		shareable = false;
		isOn = false;
		location = loc;
	}

//---  Getter Methods   -----------------------------------------------------------------------
	
	/**
	 * Getter method that requests the status of this Lantern object's being lit or not.
	 * 
	 * @return - returns a boolean value representing the status of this Lantern object's being lit.
	 */
	
	public boolean getLight() {
		return isOn;
	}
	
//---  Setter Methods   -----------------------------------------------------------------------
	
	/**
	 * Setter method that assigns a provided value as the status of this Lantern object's being lit or not.
	 * 
	 * @param val - boolean value representing the new status of this Lantern object's being lit.
	 */
	
	public void setLight(boolean val) {
		isOn = val;
	}
	
}
