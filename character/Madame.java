package character;

import game.GameModel;
import tile.Tile;

/**
 * Madame can move up to 6 tiles and cannot go through the manholes
 */
public class Madame extends MrJackCharacter{
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
