package core.character;

import core.map.AbstractMapComponent;

import java.awt.*;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractCharacter extends AbstractMapComponent {

    protected double health;
    protected double attack;
    protected double defense;
    protected int xDirection = CharacterDirection.STILL;
    protected int yDirection = CharacterDirection.STILL;

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



}
