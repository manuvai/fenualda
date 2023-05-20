package ui.panel;

import core.World;
import core.character.Hero;
import ui.ComponentUI;
import ui.screen.AbstractScreen;
import ui.screen.GameScreen;
import ui.screen.HomeScreen;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GamePanel extends JPanel implements Runnable, ComponentUI {

    private Image image;
    private Graphics graphics;
    private AbstractScreen currentScreen;

    private Thread game;
    private volatile boolean running = false;
    private final long PERIOD = 6 * 1_000_000;
    private static final int DELAYS_BEFORE_YIELD = 10;


    public GamePanel() {

        setPreferredSize(new Dimension(GWIDTH, GHEIGHT));
        setFocusable(true);
        requestFocus();

        World world = new World();

        GameScreen gameScreen = new GameScreen(this, world);
        setCurrentScreen(gameScreen);
    }

    public AbstractScreen getCurrentScreen() {
        return currentScreen;
    }

    public void setCurrentScreen(AbstractScreen currentScreen) {
        this.currentScreen = currentScreen;
    }

    public void gameRender() {

        if (image == null) {
            image = createImage(GWIDTH, GHEIGHT);
            if (image == null) {
                System.err.println("dbImage is still null!");
                return;

            }

            graphics = image.getGraphics();

        }

        //Clear the screen
        //Draw Game elements
        draw(graphics);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        startGame();
    }

    private void startGame() {
        if(game != null && running){
            return;
        }

        game = new Thread(this);
        game.start();
        running = true;

    }

    public void gameUpdate() {
        currentScreen.update();
    }

    public void paintScreen() {

        Graphics g = getGraphics();
        if (image == null || g == null){
            return;
        }

        try{
            g.drawImage(image, 0, 0, null);
            Toolkit.getDefaultToolkit()
                    .sync();

            g.dispose();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void draw(Graphics graphics) {
        currentScreen.draw(graphics);
    }

    @Override
    public void run() {
        long beforeTime;
        long afterTime;
        long diff;
        long sleepTime;
        long overSleepTime = 0;

        int delays = 0;

        while (running){
            beforeTime =  System.nanoTime();

            gameUpdate();
            gameRender();
            paintScreen();

            afterTime = System.nanoTime();
            diff = afterTime - beforeTime;
            sleepTime = (PERIOD - diff) - overSleepTime;

            if ( sleepTime < PERIOD && sleepTime > 0){
                try {
                    Thread.sleep(sleepTime / 1000000L);
                    overSleepTime = 0;

                } catch (InterruptedException ignored) {

                }
            } else if (diff > PERIOD){
                overSleepTime = diff - PERIOD;

            } else if(++ delays >= DELAYS_BEFORE_YIELD){
                Thread.yield();
                delays = 0;
                overSleepTime = 0;

            } else{
                overSleepTime = 0;
            }

        }
    }
}
