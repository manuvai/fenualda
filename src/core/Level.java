package core;

import core.character.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private int difficulty;

    private List<Enemy> enemies = new ArrayList<>();

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }
}
