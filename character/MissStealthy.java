package character;

import tile.Tile;
import game.Board;

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
	
	public boolean canMove(Tile tile, int dist) {	//Through buildings, four spaces
		return false;
	}

	@Override
	public boolean ability(Tile[] choice) {
		// TODO Auto-generated method stub
		return false;
	}

	public void deriveFromBoard(Board board) {
		
	}
	
//---  Ability Queries   ----------------------------------------------------------------------

	@Override
	public int requiredValuesForAbility() {
		return 0;
	}

	@Override
	public boolean hasToDoAbility() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDoAbilityBefore() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDoAbilityDuring() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDoAbilityAfter() {
		// TODO Auto-generated method stub
		return false;
	}

}
