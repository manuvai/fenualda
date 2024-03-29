package core;

import core.character.Enemy;
import core.map.tiles.AbstractMapTile;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Level {

    private int difficulty;

    private List<Enemy> enemies = new ArrayList<>();

    private List<List<AbstractMapTile>> tiles = new ArrayList<>();

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void draw(Graphics graphics) {
        getTiles()
                .forEach(line -> line
                        .forEach(tile -> tile.draw(graphics)));
        getEnemies()
                .forEach(enemy -> enemy.draw(graphics));
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<List<AbstractMapTile>> getTiles() {
        return tiles;
    }

    public void setTiles(List<List<AbstractMapTile>> tiles) {
        this.tiles = tiles;
    }
}
