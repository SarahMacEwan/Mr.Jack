package character;

import tile.Tile;

public class MissStealthy extends MrJackCharacter{

	
	
	@Override
	public boolean canMove(char type, int dist, int[] startLocation) {
		//Through buildings, four spaces
		//Tile[] startTile =;

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
