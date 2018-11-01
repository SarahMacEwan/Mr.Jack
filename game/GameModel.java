package game;

import player.*;
import java.io.*;
import tile.Lantern;
import java.util.HashSet;
import character.MrJackCharacter;

/**
 * Central point for running/processing the Mr. Jack Game
 * 
 * @author Mac Clevinger and Sarah MacEwan
 *
 */

public class GameModel {

//---  Constant Values   ----------------------------------------------------------------------
	
	private static final int NUMBER_ACTIVE_CHARACTERS = 4;
	private static final int LANTERN_LIMIT = 4;
	private static final int NUMBER_OF_TURNS = 2;
	private static final String[] PLAYERS = {"Detective", "Mr.Jack"};
	
//---  Instance Variables   -------------------------------------------------------------------
	
	Board board;
	Detective detective;
	MrJack mrJack;
	Clock clock;
	MrJackCharacter[] allMrJackCharacters;
	MrJackCharacter[] usedMrJackCharacters;
	MrJackCharacter[] activeMrJackCharacters;
	int player;		//If 0, Detective turn, if 1, Mr. Jack turn
	boolean gameOver;
	
	MrJackCharacter currentMrJackCharacter;
	HashSet<Integer> selectedMrJackCharacters;
	
//---  Constructors   -------------------------------------------------------------------------
	
	public GameModel(File structure, MrJackCharacter ... potentialMrJackCharacters) {
		board = deriveBoard(structure);
		allMrJackCharacters = potentialMrJackCharacters;
	}
	
//---  Game Behaviors   -----------------------------------------------------------------------
	
	public void startGame() {
		mrJack = new MrJack();
		detective = new Detective();
		player = 0;
		clock = deriveClock(LANTERN_LIMIT);
		usedMrJackCharacters = deriveMrJackCharacters(allMrJackCharacters);
		gameOver = false;
		selectedMrJackCharacters.clear();
		currentMrJackCharacter = null;
	}
	
	public void startTurn() {
		activeMrJackCharacters = characterSetPerTurn(activeMrJackCharacters);
		selectedMrJackCharacters = new HashSet<Integer>();
		currentMrJackCharacter = null;
	}
	
	public boolean chooseMrJackCharacter(int choice) {
		if(selectedMrJackCharacters.contains(choice))
			return false;
		currentMrJackCharacter = activeMrJackCharacters[choice];
		selectedMrJackCharacters.add(choice);
		return true;
	}

	public boolean moveMrJackCharacter(int choice) {			//Controller is told by the player whether moving or action
		//move if legal, return false otherwise
		return false;
	}
	
	public boolean characterAction(int[] choice) {
		//ask active character if can do action provided, respond appropriately
		return false;
	}
		
	public boolean accuseCharacter(int choice) {
		MrJackCharacter accused = null;
		for(MrJackCharacter mjc : usedMrJackCharacters) {
			if(mjc.getLocation() == choice)
				accused = mjc;
		}
		gameOver = true;
		return detective.hasWonAccusation(accused);
	}

	public boolean endTurn() {
		clock.iterateTurn();
		activeMrJackCharacters = clock.getTurn() % 2 == 0 ? null : activeMrJackCharacters;	//and other stuff
		player = clock.getTurn() % 2;
		selectedMrJackCharacters.clear();
		currentMrJackCharacter = null;
		removeSuspects();
		
		if(mrJack.hasWonTimer(clock.getTurn() == NUMBER_OF_TURNS) || mrJack.hasWonEscape(board.getTileIdentity(mrJack.whoIsMrJack().getLocation()) == 'e')) {
			gameOver = true;
			return true;
		}
		else
			return false;
	}
	
//---  Getter Methods   -----------------------------------------------------------------------
	
	public String outputGameState() {
		
		return null;
	}
	
	public String getWhoIsPlayer() {
		if(selectedMrJackCharacters.size() == 0 || selectedMrJackCharacters.size() == NUMBER_ACTIVE_CHARACTERS/2 - 1) {
			return PLAYERS[player];
		}
		else {
			return PLAYERS[(player + 1) % 2];
		}
	}
	
	public int howManyValuesForAction() {
		
		return -1;
	}
	
	public boolean roundOver() {
		return (selectedMrJackCharacters.size() == NUMBER_ACTIVE_CHARACTERS/2);
	}
	
//---  Helper Methods   -----------------------------------------------------------------------

	private Board deriveBoard(File structure) {
		String[] fileBoardInput = null;	//Parse the file to get this value
		Board newBoard = new Board(fileBoardInput);
		return newBoard;
	}
	
	private Clock deriveClock(int lanternLimit) {
		Clock newClock = new Clock((Lantern[])board.getTiles('l'), lanternLimit);
		return newClock;
	}
	
	private MrJackCharacter[] deriveMrJackCharacters(MrJackCharacter[] potential) {
		MrJackCharacter[] newMrJackCharacters = null; 	//derive 
		return newMrJackCharacters;
	}
	
	private void removeSuspects() {
		boolean[] shadows = board.getLitTiles();
		boolean MrJackShadow = shadows[mrJack.whoIsMrJack().getLocation()];
		for(MrJackCharacter c : usedMrJackCharacters) {
			if(shadows[c.getLocation()] != MrJackShadow)
				c.setSuspect(false);
		}
	}
	
	private MrJackCharacter[] characterSetPerTurn(MrJackCharacter[] lastUsed) {
		MrJackCharacter[] theseGuys = new MrJackCharacter[NUMBER_ACTIVE_CHARACTERS/2];
		if(lastUsed == null) {
			//get random 4 characters
		}
		else {
			//use other 4 characters not in lastUsed
		}
		return theseGuys;
	}

}
