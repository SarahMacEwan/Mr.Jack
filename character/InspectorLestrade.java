package character;
import game.Board;
import tile.Tile;

/**
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class InspectorLestrade extends MrJackCharacter {

	private Board gameBoard;

	public InspectorLestrade(Board board){
		gameBoard = board;
	}

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

}
