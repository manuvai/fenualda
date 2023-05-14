package ui.screen;

import ui.ComponentUI;
import ui.panel.GamePanel;

import java.awt.*;

public abstract class AbstractScreen implements ComponentUI {

    private GamePanel gamePanel;

    public AbstractScreen(GamePanel gamePanel) {
        setGamePanel(gamePanel);
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public abstract void draw(Graphics graphics);

    public void update() {

    }
}
