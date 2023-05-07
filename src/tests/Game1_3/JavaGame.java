package tests.Game1_3;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class JavaGame extends JFrame {

 int x,y;
 private Image dbImage;
 private Graphics dbg;
 
 private class Al implements KeyEventDispatcher{   
  private int keyCode;
  @Override
         public boolean dispatchKeyEvent(KeyEvent e) {
             if (e.getID() == KeyEvent.KEY_PRESSED) {
              keyCode = e.getKeyCode();
              
              if(keyCode == KeyEvent.VK_LEFT) x--;
              if(keyCode == KeyEvent.VK_RIGHT) x++;
              if(keyCode == KeyEvent.VK_UP) y--;
              if(keyCode == KeyEvent.VK_DOWN) y++;

             } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                 //System.out.println("2test2");
             } else if (e.getID() == KeyEvent.KEY_TYPED) {
                 //System.out.println("3test3");
             }
             return false;
         }
 }

 
 public JavaGame(){
  
  KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new Al());
  
  setSize(250,250);
  setTitle("Java Game");
  setVisible(true);
  setResizable(false);
  setLocationRelativeTo(null);
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  

  x = 150;
  y = 150;
 }

 public void paint(Graphics g) {
	 dbImage = createImage(getWidth(), getHeight());
	 dbg = dbImage.getGraphics();
	 paintComponent(dbg);
	 g.drawImage(dbImage,0,0,this);
 }
 
 public void paintComponent(Graphics g){
  g.fillOval(x, y, 15, 15);
  repaint();
 }
 
 public static void main(String[] args) {  
  new JavaGame();
 }
 
}