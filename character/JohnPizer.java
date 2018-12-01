package character;

import game.GameModel;
import tile.Tile;

/**
 * Created by Sarah on 2018-12-01.
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

    @Override
    public int getNUMMOVES() {
        return 0;
    }
}
