package core.map;

import java.awt.*;

public abstract class AbstractMapComponent {

    protected Color color = Color.BLUE;

    protected Image image;
    protected Rectangle position;

    public void draw(Graphics graphics) {
        if (image == null) {
            graphics.setColor(color);
            graphics.drawRect(
                    position.x,
                    position.y,
                    position.width,
                    position.height
            );

        } else {
            graphics.drawImage(
                    image,
                    position.x,
                    position.y,
                    null
            );

        }
    }
    /*
     *  Getters & Setters
     */

    public Rectangle getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public void setPosition(Rectangle position) {
        this.position = position;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
