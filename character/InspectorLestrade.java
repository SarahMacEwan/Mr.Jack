package character;

import java.util.ArrayList;
import game.Board;
import tile.Tile;
import tile.Exit;

/**
 * 
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class InspectorLestrade extends MrJackCharacter {

//---  Constant Values   ----------------------------------------------------------------------
	
	/** Constant String object representing the name of this InspectorLestrade object*/
	private static final String NAME = "Inspector Lestrade";
	/** Constant int value representing the total number of moves this InspectorLestrade object can do in one turn*/
	private static final int NUM_MOVES = 3;
	
//---  Instance Variables   -------------------------------------------------------------------
	
	/** ArrayList<<r>Exit> object describing the Tile objects associated to this InspectorLestrade object*/
	private ArrayList<Exit> relevantTiles;

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the InspectorLestrade class, assigning constant values
	 * for the object's name and number of moves, and also initializing the array of relevant
	 * tiles (containing Exit tiles.)
	 */
	
	public InspectorLestrade(){
		name = NAME;
		numMoves = NUM_MOVES;
		relevantTiles = new ArrayList<Exit>();
	}

//---  Operations   ---------------------------------------------------------------------------

	@Override
	public boolean ability(Tile[] choice) {
		Exit on = null;
		Exit off = null;
		for(Exit t : relevantTiles) {
			if(t.getLocation() == choice[0].getLocation()) {
				on = t;
			}
			if(t.getLocation() == choice[1].getLocation()) {
				off = t;
			}
		}
		if(on == null || off == null)
			return false;
		else {
			on.setBlocked(true);
			off.setBlocked(false);
			return true;
		}
	}

	public void deriveFromBoard(Board board) {
		//Find all exit tiles
	}
	
//---  Ability Queries   ----------------------------------------------------------------------
	
	@Override
	public int requiredValuesForAbility() {
		return 2;
	}

	@Override
	public boolean hasToDoAbility() {
		//he must do ability at some point
		return true;
	}

	@Override
	public boolean canDoAbilityBefore() {
		//he can do ability now
		return true;
	}

	@Override
	public boolean canDoAbilityDuring() {
		//he can not do ability now
		return false;
	}

	@Override
	public boolean canDoAbilityAfter() {
		//he can do ability now
		return true;
	}
}