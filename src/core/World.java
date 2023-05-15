package core;

import core.character.CharacterDirection;
import core.character.Enemy;
import core.character.Hero;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;

import static com.sun.glass.events.KeyEvent.*;

public class World implements KeyListener {

    private Hero hero;

    private List<Integer> pressedKeys = new ArrayList<>();

    private int currentLevelIndex = -1;

    private List<Level> levels = new ArrayList<>();

    public World() {
        this(null);
    }

    public World(Hero hero) {
        setHero(hero);
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void update() {
        hero.move();
        boolean isLevelValid = currentLevelIndex >= 0 &&
                levels.size() >= currentLevelIndex;

        if (isLevelValid) {
            levels.get(currentLevelIndex)
                    .getEnemies()
                    .forEach(Enemy::move);

        }
    }

    public void draw(Graphics graphics) {
        hero.draw(graphics);
        boolean isLevelValid = currentLevelIndex >= 0 &&
                levels.size() >= currentLevelIndex;

        if (isLevelValid) {
            levels.get(currentLevelIndex)
                    .getEnemies()
                    .forEach(enemy -> enemy.draw(graphics));

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("Pressed " + e.getKeyCode());
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (!pressedKeys.contains(e.getKeyCode())) {
            pressedKeys.add(e.getKeyCode());

        }

        switch (e.getKeyCode()) {
            case VK_Z:
            case VK_UP:
                hero.setyDirection(CharacterDirection.UP);
                break;
            case VK_D:
            case VK_RIGHT:
                hero.setxDirection(CharacterDirection.RIGHT);
                break;
            case VK_Q:
            case VK_LEFT:
                hero.setxDirection(CharacterDirection.LEFT);
                break;
            case VK_S:
            case VK_DOWN:
                hero.setyDirection(CharacterDirection.DOWN);
                break;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedKeys.remove((Object) e.getKeyCode());
        switch (e.getKeyCode()) {
            case VK_Z:
            case VK_UP:
                if (
                        !pressedKeys.contains(VK_Z) &&
                        !pressedKeys.contains(VK_UP) &&
                        !pressedKeys.contains(VK_S) &&
                        !pressedKeys.contains(VK_DOWN)
                ) {
                    hero.setyDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_S) ||
                        pressedKeys.contains(VK_DOWN)
                ) {
                    hero.setyDirection(CharacterDirection.DOWN);
                }
                break;

            case VK_S:
            case VK_DOWN:
                if (
                    !pressedKeys.contains(VK_Z) &&
                    !pressedKeys.contains(VK_UP) &&
                    !pressedKeys.contains(VK_S) &&
                    !pressedKeys.contains(VK_DOWN)
                ) {
                    hero.setyDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_Z) ||
                        pressedKeys.contains(VK_UP)
                ) {
                    hero.setyDirection(CharacterDirection.UP);
                }
                break;

            case VK_D:
            case VK_RIGHT:
                if (
                        !pressedKeys.contains(VK_D) &&
                        !pressedKeys.contains(VK_RIGHT) &&
                        !pressedKeys.contains(VK_Q) &&
                        !pressedKeys.contains(VK_LEFT)
                ) {
                    hero.setxDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_Q) ||
                        pressedKeys.contains(VK_LEFT)
                ) {
                    hero.setxDirection(CharacterDirection.LEFT);
                }
                break;

            case VK_Q:
            case VK_LEFT:
                if (
                    !pressedKeys.contains(VK_D) &&
                    !pressedKeys.contains(VK_RIGHT) &&
                    !pressedKeys.contains(VK_Q) &&
                    !pressedKeys.contains(VK_LEFT)
                ) {
                    hero.setxDirection(CharacterDirection.STILL);

                } else if (
                        pressedKeys.contains(VK_D) ||
                        pressedKeys.contains(VK_RIGHT)
                ) {
                    hero.setxDirection(CharacterDirection.RIGHT);
                }
                break;
        }
    }
}
