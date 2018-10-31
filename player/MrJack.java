package player;

import character.MrJackCharacter;

/**
 * This class models the Mr. Jack type of Player for the Mr. Jack game.
 * 
 * The key feature for Mr. Jack is knowing the Mr. Jack character and being able to have them escape.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class MrJack implements Player{

	MrJackCharacter[] alibis;
	
	public MrJackCharacter whoIsMrJack() {
		return alibis[0];
	}

	@Override
	public boolean hasWon(boolean isOver, Boolean accusation) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
