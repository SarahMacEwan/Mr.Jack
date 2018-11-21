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
 *
 */
public class JohnPizer extends MrJackCharacter {
    @Override
    public boolean ability(Tile[] choice) {
        /*he needs to:
        get the tile he is on (choice)
        get the neighbouring tiles and the characters that may be on those tiles
        move each character nearby (if any) 3 hexes away
        */
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
}
