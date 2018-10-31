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

	MrJackCharacter mrJack;
	MrJackCharacter[] alibis;
	
	public MrJackCharacter whoIsMrJack() {
		return mrJack;
	}

	public boolean hasWonTimer(boolean isOver) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean hasWonEscape(boolean onExit) {
		//Check if the character is lit or not if is on exit
		return false;
	}
	
	public MrJackCharacter[] getAlibis() {
		return alibis;
	}
	
}
