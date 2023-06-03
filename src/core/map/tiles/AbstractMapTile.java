package core.map.tiles;

import core.character.AbstractCharacter;
import core.map.AbstractMapComponent;

import java.awt.*;

public abstract class AbstractMapTile extends AbstractMapComponent implements IMapTile {

    protected Color color = Color.RED;

    public AbstractMapTile() {

    }
    public AbstractMapTile(int x, int y) {

        this(null, x, y);
    }

    public AbstractMapTile(Image image) {
        this(image, 0, 0);
    }

    public AbstractMapTile(Image image, int x, int y) {

        this.image = image;

        Rectangle position = new Rectangle();

        position.setSize(
                new Dimension(
                        TILE_WIDTH,
                        TILE_HEIGHT
                )
        );
        position.x = x;
        position.y = y;

        setPosition(position);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        graphics.drawImage(
                image,
                position.x,
                position.y,
                null
        );
        graphics.setColor(color);
        graphics.drawRect(
                position.x,
                position.y,
                position.width,
                position.height
        );
    }

    public boolean canMove(AbstractCharacter character, int x, int y) {
        return true;
    }
}
