package game;

import tile.Lantern;

/**
 * This class models the Clock keeping track of the game's state as the turn order progresses.
 * 
 * Controls the state of Lanterns, the order of play between Players.
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class Clock {

	Lantern[] lanterns;
	int turnValue;
	int maxLanternsOff;
	
	public Clock(Lantern[] givenLanterns, int lanternLimit) {
		lanterns = givenLanterns;
		turnValue = 0;
		maxLanternsOff = lanternLimit;
	}
	
	public void iterateTurn() {
		turnValue++;
		manageLanterns(turnValue);
	}
	
	private void manageLanterns(int turn) {
		if(turn <= maxLanternsOff) {
			lanterns[turn].setLight(false);
		}
	}

	public int getTurn() {
		return turnValue;
	}
	
}
