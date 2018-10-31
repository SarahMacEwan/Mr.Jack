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

	MrJackCharacter[] alibis;
	
	@Override
	public boolean hasWon(boolean isOver, Boolean accusation) {
		// TODO Auto-generated method stub
		return false;
	}

}
