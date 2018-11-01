package character;
import game.Board;
import tile.Tile;

/**
 * 
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class InspectorLestrade extends MrJackCharacter {

//---  Constant Values   ----------------------------------------------------------------------\
	
	/** Constant String object representing the name of this InspectorLestrade object*/
	private static final String NAME = "Inspector Lestrade";
	/** Constant int value representing the total number of moves this InspectorLestrade object can do in one turn*/
	private static final int NUM_MOVES = 3;
	
//---  Instance Variables   -------------------------------------------------------------------
	
	/** Board object describing the Tile layout of this instance of the Mr. Jack game*/
	private Board gameBoard;

//---  Constructors   -------------------------------------------------------------------------
	
	/**
	 * Constructor for objects of the InspectorLestrade class, requesting a Board object from
	 * which the InspectorLestrade class will query Tile statuses when prompted.
	 * 
	 * @param board - Board object provided for this InspectorLestrade object to interact with.
	 */
	
	public InspectorLestrade(Board board){
		name = NAME;
		numMoves = NUM_MOVES;
		gameBoard = board;
	}

//---  Operations   ---------------------------------------------------------------------------

	@Override
	public boolean ability(int[] choice) {
		//this is a test
		for(int x = 0; x < choice.length; x++){
			char tileId = gameBoard.getTileIdentity(x);
			if(tileId == 'e'){
				return true;
			}
		}
		return false;
	}

//---  Ability Queries   ----------------------------------------------------------------------
	
	@Override
	public int requiredValuesForAbility() {
		// TODO Auto-generated method stub
		return 0;
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