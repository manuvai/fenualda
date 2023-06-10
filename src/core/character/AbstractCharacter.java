package core.character;

import core.World;
import core.map.AbstractMapComponent;
import ui.ComponentUI;

import java.awt.*;

public abstract class AbstractCharacter
        extends AbstractMapComponent
        implements ComponentUI {

    protected double health;
    protected double attack;
    protected double defense;
    protected int xDirection = CharacterDirection.STILL;
    protected int yDirection = CharacterDirection.STILL;

    protected World world;

    /*
        Common methods
     */
    public void takeDamage(double damage) {
        double newHealth = Math.max(0, getHealth() - damage);
        setHealth(newHealth);
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.drawImage(
                image,
                position.x + (position.width - image.getWidth(null)) / 2,
                position.y + (position.height - image.getHeight(null)) / 2,
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

    public void move() {

        int x = getPosition().x + getxDirection();
        int y = getPosition().y + getyDirection();

        x = (int) Math.max(0, Math.min(GWIDTH - position.getWidth(), x));
        y = (int) Math.max(0, Math.min(GHEIGHT - position.getHeight(), y));

        setPosition(
                x,
                y

        );

        updateIcon();
    }

    private void updateIcon() {

    }

    public void attack(AbstractCharacter opponent) {
        double attackPoints = getAttack();
        opponent.takeDamage(attackPoints);
    }

    /*
        Getters and Setters
     */
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

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

}
