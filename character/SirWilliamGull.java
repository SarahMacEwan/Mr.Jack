package character;

import game.Board;
import tile.Exit;
import tile.Tile;
import game.GameModel;

import java.util.ArrayList;

public class SirWilliamGull extends MrJackCharacter{
//---  Constant Values   ----------------------------------------------------------------------\

	/** Constant String object representing the name of this InspectorLestrade object*/
	private static final String NAME = "Sir William Gull";
	/** Constant int value representing the total number of moves this InspectorLestrade object can do in one turn*/
	private static final int NUM_MOVES = 3;

//---  Instance Variables   -------------------------------------------------------------------

	/** ArrayList<<r>MrJackCharacter> object describing the Tile objects associated to this InspectorLestrade object*/
	private MrJackCharacter[] characters;

//---  Constructors   -------------------------------------------------------------------------

	/**
	 * Constructor for objects of the InspectorLestrade class, assigning the Board object a null
	 * which the InspectorLestrade class will query Exit statuses when prompted.
	 */

	public SirWilliamGull(){
		name = NAME;
		numMoves = NUM_MOVES;
		characters = new MrJackCharacter[4];
	}
	@Override
	public boolean ability(Tile[] choice) {
		for(int x = 0; x < characters.length; x++){
			//if the character on the tile is in the list of characters in play
			//then return true, else return false
			MrJackCharacter character = characters[x];
			Tile tile = choice[x];
			if(character.getLocation() == tileIndex) {
				return true;
			}
		}
		return false;
	}

	public void deriveFromModel(GameModel game) {
		//find all the locations of the characters in play
		characters = game.getCharacters();
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



}
