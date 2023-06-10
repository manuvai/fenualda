package core.map.tiles.corner;

import core.character.AbstractCharacter;
import core.map.tiles.AbstractMapTile;

public class LowerLeftCornerMapTile extends AbstractMapTile {

    @Override
    public boolean canMove(AbstractCharacter character, int x, int y) {

        int futureX = character.getPosition().x + x;
        int futureY = character.getPosition().y + y;

        int limitX = (int) (getPosition().x + (getPosition().getWidth() / 4));
        int limitY = (int) (getPosition().y - (getPosition().getHeight() / 2));

        return futureX < limitX && futureY < limitY;
    }
}
