package core;

import core.character.CharacterDirection;
import core.character.Hero;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static com.sun.glass.events.KeyEvent.*;

public class World implements KeyListener {

    private Hero hero;

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void update() {
        hero.move();
    }

    public void draw(Graphics graphics) {
        hero.draw(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pressed " + e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_Z, VK_UP -> hero
                    .setyDirection(CharacterDirection.UP);
            case VK_D, VK_RIGHT -> hero
                    .setxDirection(CharacterDirection.RIGHT);
            case VK_Q, VK_LEFT -> hero
                    .setxDirection(CharacterDirection.LEFT);
            case VK_S, VK_DOWN -> hero
                    .setyDirection(CharacterDirection.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case VK_Z, VK_UP, VK_S, VK_DOWN -> hero
                    .setyDirection(CharacterDirection.STILL);
            case VK_D, VK_RIGHT, VK_Q, VK_LEFT -> hero
                    .setxDirection(CharacterDirection.STILL);
        }
    }
}
