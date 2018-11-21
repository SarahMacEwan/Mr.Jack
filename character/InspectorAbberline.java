package character;


import java.util.ArrayList;
import game.Board;
import tile.Exit;
import game.GameModel;
import tile.Tile;

/**
 * If a character is on a tile adjacent to Inspector Abberline, their movement from that point forward
 * is restricted to only one tile
 *
 *
 *
 */
public class InspectorAbberline extends MrJackCharacter{
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
