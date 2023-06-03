package core.map.tiles;

import core.character.AbstractCharacter;

public class GroundMapTile extends AbstractMapTile {

    @Override
    public boolean canMove(AbstractCharacter character, int x, int y) {
        return true;
    }
}
