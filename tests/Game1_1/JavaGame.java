package tests.Game1_1;

import java.awt.*;
import javax.swing.*;

public class JavaGame extends JFrame {

    public JavaGame() {
        setTitle("Game");
        setSize(500,500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        g.drawString("Hello World!",75,75);
    }

    public static void main(String[] args) {
        new JavaGame();

    }


}