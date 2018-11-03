package character;

import tile.Tile;
import game.Board;
import game.GameModel;

public class MissStealthy extends MrJackCharacter{

//---  Constant Values   ----------------------------------------------------------------------

	/** Constant String object representing the name of this InspectorLestrade object*/
	private static final String NAME = "Miss Stealthy";
	/** Constant int value representing the total number of moves this InspectorLestrade object can do in one turn*/
	private static final int NUM_MOVES = 4;
	
//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the MissStealthy class, assigning the constant values for the
	 * object's name and number of moves. 
	 */
	
	public MissStealthy() {
		name = NAME;
		numMoves = NUM_MOVES;
	}

//---  Operations   ---------------------------------------------------------------------------
	
	public boolean canMove(Tile tile, int dist) {
		return dist <= numMoves;
	}

	@Override
	public boolean ability(Tile[] choice) {
		return true;
	}

	@Override
	public void deriveFromModel(GameModel model) {
		return;
	}
	
//---  Ability Queries   ----------------------------------------------------------------------

	@Override
	public int requiredValuesForAbility() {
		return 0;
	}

	@Override
	public boolean hasToDoAbility() {
		return false;
	}

	@Override
	public boolean canDoAbilityBefore() {
		return false;
	}

	@Override
	public boolean canDoAbilityDuring() {
		return true;
	}

	@Override
	public boolean canDoAbilityAfter() {
		return false;
	}

}
