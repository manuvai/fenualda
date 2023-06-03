package core.map.tiles.wall;

import core.character.AbstractCharacter;
import core.map.tiles.AbstractMapTile;

public class RightWallMapTile extends AbstractMapTile {

    @Override
    public boolean canMove(AbstractCharacter character, int x, int y) {
        int futureX = character.getPosition().x + x;

        int limitX = (int) (getPosition().x - (getPosition().getWidth() / 2));

        return futureX < limitX || y != 0;
    }
}
