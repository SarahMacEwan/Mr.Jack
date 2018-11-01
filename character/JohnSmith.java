package character;

import java.util.ArrayList;

import game.Board;
import tile.Tile;
import tile.Exit;
import tile.Lantern;

/**
 * 
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class JohnSmith extends MrJackCharacter {

//---  Constant Values   ----------------------------------------------------------------------

	/** Constant String object representing the name of this JohnSmith object*/
	private static final String NAME = "John Smith";
	/** Constant int value representing the total number of moves this JohnSmith object can do in one turn*/
	private static final int NUM_MOVES = 3;

//---  Instance Variables   -------------------------------------------------------------------

	/** ArrayList<<r>Exit> object describing the Tile objects associated to this InspectorLestrade object*/
	private ArrayList<Lantern> relevantTiles;

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the JohnSmith class, assigning the Board object a null
	 * which the JohnSmith class will query Lantern statuses when prompted.
	 */
	
	public JohnSmith() {
		name = NAME;
		numMoves = NUM_MOVES;
		relevantTiles = new ArrayList<Lantern>();
	}

//---  Operations   ---------------------------------------------------------------------------
	
	@Override
	public boolean ability(Tile[] choice) {
		Lantern on = null;
		Lantern off = null;
		for(Lantern t : relevantTiles) {
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
			on.setLight(true);
			off.setLight(false);
			return true;
		}
	}
	
	public void deriveFromBoard(Board board) {
		
	}
	
//---  Ability Queries   ----------------------------------------------------------------------
	
	@Override
	public int requiredValuesForAbility() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasToDoAbility() {
		return true;
	}

	@Override
	public boolean canDoAbilityBefore() {
		return true;
	}

	@Override
	public boolean canDoAbilityDuring() {
		return false;
	}

	@Override
	public boolean canDoAbilityAfter() {
		return true;
	}

}