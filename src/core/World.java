package core;

import core.character.Enemy;
import core.character.Hero;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class World implements KeyListener {

    private Hero hero;

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

    public Level getCurrentLevel() {
        if (currentLevelIndex < 0) {
            return null;
        }
        return levels.get(currentLevelIndex);
    }

    public void draw(Graphics graphics) {
        hero.draw(graphics);
        boolean isLevelValid = currentLevelIndex >= 0 &&
                levels.size() >= currentLevelIndex;

        if (isLevelValid) {
            getCurrentLevel()
                    .getEnemies()
                    .forEach(enemy -> enemy.draw(graphics));

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        hero.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.keyReleased(e);
    }
}
