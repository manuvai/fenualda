package ui.map;

import core.map.tiles.GroundMapTile;
import core.map.tiles.IMapTile;
import core.map.tiles.AbstractMapTile;
import core.map.tiles.corner.LowerLeftCornerMapTile;
import core.map.tiles.corner.LowerRightCornerMapTile;
import core.map.tiles.corner.UpperLeftCornerMapTile;
import core.map.tiles.corner.UpperRightCornerMapTile;
import core.map.tiles.wall.LeftWallMapTile;
import core.map.tiles.wall.LowerWallMapTile;
import core.map.tiles.wall.RightWallMapTile;
import core.map.tiles.wall.UpperWallMapTile;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MapAdapter {

    private static final Map<String, Class<? extends AbstractMapTile>> correspondingMapTile =
            new HashMap<String, Class<? extends AbstractMapTile>>() {{
                    put(MapTileType.GROUND, GroundMapTile.class);
                    put(MapTileType.LEFT_WALL, LeftWallMapTile.class);
                    put(MapTileType.RIGHT_WALL, RightWallMapTile.class);
                    put(MapTileType.UPPER_WALL, UpperWallMapTile.class);
                    put(MapTileType.LOWER_WALL, LowerWallMapTile.class);
                    put(MapTileType.UPPER_LEFT_CORNER, UpperLeftCornerMapTile.class);
                    put(MapTileType.UPPER_RIGHT_CORNER, UpperRightCornerMapTile.class);
                    put(MapTileType.LOWER_LEFT_CORNER, LowerLeftCornerMapTile.class);
                    put(MapTileType.LOWER_RIGHT_CORNER, LowerRightCornerMapTile.class);
    }};

    private static final Map<String, String> correspondingMapImage =
            new HashMap<String, String>() {{
                    put(MapTileType.GROUND, "ground");
                    put(MapTileType.LEFT_WALL, "left_wall");
                    put(MapTileType.RIGHT_WALL, "right_wall");
                    put(MapTileType.UPPER_WALL, "upper_wall");
                    put(MapTileType.LOWER_WALL, "lower_wall");
                    put(MapTileType.UPPER_LEFT_CORNER, "upper_left_corner");
                    put(MapTileType.UPPER_RIGHT_CORNER, "upper_right_corner");
                    put(MapTileType.LOWER_LEFT_CORNER, "lower_left_corner");
                    put(MapTileType.LOWER_RIGHT_CORNER, "lower_right_corner");
    }};

    public static AbstractMapTile toMapTile(String tileString) {

        String tilePath = "src/res/map1/";

        return getMapTileType(tilePath, tileString);
    }

    private static AbstractMapTile getMapTileType(String _tilePath, String tileString) {

        String tilePath = _tilePath;

        AbstractMapTile mapTile;

        tilePath = tilePath.concat(
                correspondingMapImage.getOrDefault(tileString, "ground")
        );

        try {
            mapTile = correspondingMapTile.getOrDefault(tileString, GroundMapTile.class)
                    .newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        tilePath = tilePath.concat(".png");
        Image image = new ImageIcon(tilePath).getImage();

        mapTile.setImage(image);
        mapTile.setPosition(
                new Rectangle(
                        0,
                        0,
                        IMapTile.TILE_WIDTH,
                        IMapTile.TILE_HEIGHT
                )
        );

        return mapTile;
    }
}
