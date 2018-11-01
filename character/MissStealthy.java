package character;

import tile.Tile;

public class MissStealthy extends MrJackCharacter{


	public boolean canMove(Tile tile, int dist) {	//Through buildings, four spaces
		return false;
	}

	@Override
	public int requiredValuesForAbility() {
		// TODO Auto-generated method stub
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

	@Override
	public boolean ability(int[] choice) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
