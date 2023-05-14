package ui.screen;

import core.World;
import ui.panel.GamePanel;

import java.awt.*;

public class GameScreen extends AbstractScreen {

    private World world;

    public GameScreen(GamePanel gamePanel, World world) {
        super(gamePanel);
        setWorld(world);
        gamePanel.addKeyListener(world);
    }

    public void update() {
        world.update();
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.fillRect(0, 0, GWIDTH, GHEIGHT);
        if (world != null) {
            world.draw(graphics);
        }

    }
}
