package player;

import character.MrJackCharacter;

/**
 * This class models the Detective type of Player for Mr. Jack.
 * 
 * The key feature for Detective is being able to accuse a Character.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Detective implements Player{

	MrJackCharacter mrJack;
	MrJackCharacter[] alibis;
	
	public boolean hasWonAccusation(MrJackCharacter accused) {
		if(accused.equals(mrJack))
			return true;
		return false;
	}
	
	public MrJackCharacter[] getAlibis() {
		return alibis;
	}
	
}
