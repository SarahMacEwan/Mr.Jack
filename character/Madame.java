package character;

import java.util.ArrayList;
import game.Board;
import tile.Exit;
import game.GameModel;
import tile.Tile;

/**
 * When moving, Madame can never use the sewers
 *
 */
public class Madame extends MrJackCharacter {

//---  Constant Values   ----------------------------------------------------------------------

    /** Constant String object representing the name of this InspectorLestrade object*/
    private static final String NAME = "Madame";
    /** Constant int value representing the total number of moves this InspectorLestrade object can do in one turn*/
    private static final int NUM_MOVES = 6;
    /** Constant String object representing the shorthand name for this MrJackCharacter object*/
    private static final String SHORT_NAME = "Mad.";

// --- Instance Variables ---------------------------------------------------------------------
//---  Constructors   -------------------------------------------------------------------------

    /**
     * Constructor for objects of the MissStealthy class, assigning the constant values for the
     * object's name and number of moves.
     */

    public Madame() {
        name = NAME;
        numMoves = NUM_MOVES;
        shortName = SHORT_NAME;
    }

//---  Operations   ---------------------------------------------------------------------------

    public boolean canMove(Tile tile, int dist) {
        Tile[] tempChoice = new Tile[1];
        tempChoice[0] = tile;
        if((this.ability(tempChoice))&& dist <= numMoves){
            return true;
        } else return false;
    }

    /* The way we played/interpreted the game was that you could not stand on a manhole without
     * using it this means that Madame is not allowed to stand on any manholes.
    */
    @Override
    public boolean ability(Tile[] choice) {
        for(Tile tile: choice) {
            if (tile.getIdentity() == 'm') {
                return false;
            }
        }
        return true;
    }

    @Override
    public void deriveFromModel(GameModel model) {

    }

//---  Ability Queries   ----------------------------------------------------------------------

    @Override
    public int requiredValuesForAbility() {
        return 0;
    }

    @Override
    public boolean hasToDoAbility() {
        return true;
    }

    @Override
    public boolean canDoAbilityBefore() {
        return false;
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
    public int getNUMMOVES() {
        return NUM_MOVES;
    }
}
