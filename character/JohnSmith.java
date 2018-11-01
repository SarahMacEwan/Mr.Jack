package character;

import game.Board;

public class JohnSmith extends MrJackCharacter {

	private Board gameBoard;

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


