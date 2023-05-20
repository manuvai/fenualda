package core.map;

import core.character.AbstractCharacter;

public class MapTile extends AbstractMapComponent {
    private MapTile mapTile;

    public MapTile getMapTile() {
        return mapTile;
    }

    public void setMapTile(MapTile mapTile) {
        this.mapTile = mapTile;
    }

    public boolean canMove(AbstractCharacter character, int x, int y) {
        return true;
    }
}
