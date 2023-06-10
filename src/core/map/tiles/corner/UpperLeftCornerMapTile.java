package core.map.tiles.corner;

import core.character.AbstractCharacter;
import core.map.tiles.AbstractMapTile;

public class UpperLeftCornerMapTile extends AbstractMapTile {

    @Override
    public boolean canMove(AbstractCharacter character, int x, int y) {
        int futureX = character.getPosition().x + x;
        int futureY = character.getPosition().y + y;

        int limitX = (int) (getPosition().x + (getPosition().getWidth() / 3));
        int limitY = (int) (getPosition().y + (getPosition().getHeight() / 4));

        return futureX > limitX && futureY > limitY;
    }
}
