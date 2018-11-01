package character;

import tile.Tile;

/**
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public abstract class MrJackCharacter {

//---  Instance Variables   -------------------------------------------------------------------
	
	/** int value representing which Tile in the Board's Tile[] this MrJackCharacter is on, by index reference*/
	int tileIndex;
	/** String object representing the name associated to this MrJackCharacter object*/
	String name;
	/** int value representing the number of moves this MrJackCharacter can make in one turn (how many spaces)*/
	int numMoves;
	/** boolean value representing whether or not this MrJackCharacter is still a suspect to the Players*/
	boolean isSuspect;
	/** boolean value representing whether or not this MrJackCharacter is currently 'lit'*/
	boolean isLit;
	
//---  Operations   ---------------------------------------------------------------------------
	
	/**
	 * This method determines whether, given the 
	 * 
	 * @param tile - Tile object representing the space on the Board this MrJackCharacter object is potentially entering
	 * @param distance - int value representing how far this MrJackCharacter has already traveled. 
	 * @return - Returns a boolean value representing whether or not we can enter the provided Tile space.
	 */
	

	public boolean canMove(Tile tile, int distance) {
		//is the given a Tile a legal tile to move to
		return false;
	}

	/**
	 * This method determines whether this MrJackCharacter object can interact with
	 * 
	 * 
	 * @param type
	 * @return
	 */
	
	public boolean canInteract(char type) {
		
		return false;
	}
	
	public abstract boolean ability(int[] choice);
	
//---  Getter Methods   -----------------------------------------------------------------------

	public boolean getLit() {
		return isLit;
	}
	
	public boolean getSuspect() {
		return isSuspect;
	}
	
	public int getLocation() {
		return tileIndex;
	}
	
//---  Setter Methods   -----------------------------------------------------------------------
	
	public void setLit(boolean in) {
		isLit = in;
	}
	
	public void setSuspect(boolean in) {
		isSuspect = in;
	}

	public void setLocation(int index) {
		tileIndex = index;
	}
	
//---  Ability Queries   ----------------------------------------------------------------------
	
	public abstract int requiredValuesForAbility();
	
	public abstract boolean hasToDoAbility();
	
	public abstract boolean canDoAbilityBefore();
	
	public abstract boolean canDoAbilityDuring();
	
	public abstract boolean canDoAbilityAfter();

}
