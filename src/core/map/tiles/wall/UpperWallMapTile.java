package core.map.tiles.wall;

import core.character.AbstractCharacter;
import core.map.tiles.AbstractMapTile;

public class UpperWallMapTile extends AbstractMapTile {

    @Override
    public boolean canMove(AbstractCharacter character, int x, int y) {
        int futureY = character.getPosition().y + y;

        int limitY = (int) (getPosition().y + (getPosition().getHeight() / 2));

        return futureY > limitY || x != 0;
    }
}
