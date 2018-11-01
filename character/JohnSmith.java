package character;

import game.Board;

/**
 * 
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class JohnSmith extends MrJackCharacter {

//---  Constant Values   ----------------------------------------------------------------------\

	/** Constant String object representing the name of this JohnSmith object*/
	private static final String NAME = "John Smith";
	/** Constant int value representing the total number of moves this JohnSmith object can do in one turn*/
	private static final int NUM_MOVES = 3;

	private Board gameBoard;
	
//---  Constructors   -------------------------------------------------------------------------
		
	public JohnSmith() {
		
	}
	
	public JohnSmith(Board board) {
		gameBoard = board;
	}

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


	@Override
	public boolean ability(int[] choice) {
		//checks the selected tile is one that John Smith can deal with
		for (int x = 0; x < choice.length; x++) {
			char tileId = gameBoard.getTileIdentity(x);
			if (tileId == 'l') {
				return true;
			}
		}
		return false;
	}
}


