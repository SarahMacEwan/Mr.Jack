package character;

import game.Board;
import game.GameModel;
import tile.Tile;

/**
 * If a character is on a tile adjacent to John Pizer, they will be so intimidated that they will move
 * three hexes away from him
 */
public class JohnPizer extends MrJackCharacter {

    //---  Constant Values   ----------------------------------------------------------------------

    /** Constant String object representing the name of this InspectorLestrade object*/
    private static final String NAME = "JohnPizer";
    /** Constant int value representing the total number of moves this JohnPizer object can do in one turn*/
    private static final int NUM_MOVES = 3;
    /** Constant String object representing the shorthand name for this MrJackCharacter object*/
    private static final String SHORT_NAME = "J.P";

    //---  Instance Variables   -------------------------------------------------------------------

    /** ArrayList<MrJackCharacter> object describing the Tile objects associated to this JohnPizer object*/
    private MrJackCharacter[] characters;
    private Board board;


    //--- Constructor -------------
    public JohnPizer(){
        name = NAME;
        numMoves = NUM_MOVES;
        characters = new MrJackCharacter[4];
        shortName = SHORT_NAME;
    }

    //--- Operations --------------

    @Override
    public boolean ability(Tile[] choice) {
        int numCharsMoved = 0;
        for(Tile t: choice) {
            for (MrJackCharacter ch : characters) {
                int charLoc = ch.getLocation();
                for(int loc: t.getNeighbors()){
                    if (loc == charLoc) {
                        for(int i = 0; i < 3; i++){
                            this.deriveFromBoard(board, ch, t);
                        }
                        numCharsMoved++;
                    }
                }
            }
        }
        if(numCharsMoved > 0){
            return true;
        } else return false;
    }

    @Override
    public void deriveFromModel(GameModel model){
        board = model.getBoard();
        characters = model.getCharacters();
    }

    public void deriveFromBoard(Board board, MrJackCharacter character, Tile tile) {
        int charLoc = character.getLocation();
        for(int loc: tile.getNeighbors()){
            boolean[] reachable = board.getLegalMovement(character);
            if(reachable[loc]) {
                character.setLocation(loc);
            }
        }

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
