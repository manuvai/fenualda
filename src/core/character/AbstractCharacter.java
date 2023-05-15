package core.character;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractCharacter {

    protected Rectangle position;
    protected double health;
    protected double attack;
    protected double defense;
    protected int xDirection = CharacterDirection.STILL;
    protected int yDirection = CharacterDirection.STILL;

    Image image;

    /*
        Common methods
     */
    public void takeDamage(double damage) {
        double newHealth = Math.max(0, getHealth() - damage);
        setHealth(newHealth);
    }

    public void move() {

        setPosition(
                getPosition().x + getxDirection(),
                getPosition().y + getyDirection()

        );
    }

    public void attack(AbstractCharacter opponent) {
        double attackPoints = getAttack();
        opponent.takeDamage(attackPoints);
    }

    public void draw(Graphics graphics) {
        if (image == null) {
            graphics.setColor(Color.BLUE);
            graphics.fillRect(
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
        Getters and Setters
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

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public int getxDirection() {
        return xDirection;
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getyDirection() {
        return yDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
