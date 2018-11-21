package character;

import java.util.ArrayList;
import game.Board;
import tile.Exit;
import game.GameModel;
import tile.Tile;

/**
 * John Pizer is scary, so if another character is on a tile next to him, they have to move three tiles away from him
 * without going through any manholes/special tiles
 *
 *
 *I'm adding in another specification that they can't move way off the board if not possible.
 *
 */
public class JohnPizer extends MrJackCharacter {
    @Override
    public boolean ability(Tile[] choice) {
        return false;
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
        return false;
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
        return false;
    }
}
