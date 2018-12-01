package character;


import java.util.ArrayList;
import game.Board;
import tile.Exit;
import game.GameModel;
import tile.Tile;

/**
 * If a character is on a tile adjacent to Inspector Abberline, their movement from that point forward
 * is restricted to only one tile
 */
public class InspectorAbberline extends MrJackCharacter{

    //---  Constant Values   ----------------------------------------------------------------------

    /** Constant String object representing the name of this InspectorLestrade object*/
    private static final String NAME = "InspectorAbberline";
    /** Constant int value representing the total number of moves this InspectorLestrade object can do in one turn*/
    private static final int NUM_MOVES = 3;
    /** Constant String object representing the shorthand name for this MrJackCharacter object*/
    private static final String SHORT_NAME = "I.A.";

    //---  Instance Variables   -------------------------------------------------------------------

    /** ArrayList<<r>MrJackCharacter> object describing the Tile objects associated to this InspectorAbberline object*/
    private MrJackCharacter[] characters;


    @Override
    public boolean ability(Tile[] choice) {
        /*
        he needs to:
        get the characters on the neighbouring tiles
        update those character's move limit to = 1
         */
        int numMovesChanged = 0;
        for(Tile t: choice) {
            for (MrJackCharacter ch : characters) {
                int charLoc = ch.getLocation();
                for(int loc: t.getNeighbors()){
                    if (loc == charLoc) {
                        ch.setNumMoves(1);
                        numMovesChanged++;
                    }
                }
            }
        }
        if(numMovesChanged > 0){
            return true;
        } else return false;
    }

    @Override
    public void deriveFromModel(GameModel model) {

    }

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
        return true;
    }

    @Override
    public boolean canDoAbilityDuring() {
        return true;
    }

    @Override
    public boolean canDoAbilityAfter() {
        return true;
    }

    @Override
    public int getNUMMOVES(){
        return NUM_MOVES;
    }
}
