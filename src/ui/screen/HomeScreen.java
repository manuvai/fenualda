package ui.screen;

import core.World;
import ui.panel.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HomeScreen extends AbstractScreen {

    public HomeScreen(GamePanel gamePanel) {
        super(gamePanel);
    }

    @Override
    public void draw(Graphics graphics) {

        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, GWIDTH, GHEIGHT);
    }
}
