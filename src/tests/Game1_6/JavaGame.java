package tests.Game1_6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGame extends JFrame {

 int x,y;
 private Image dbImage;
 private Graphics dbg;
 Image face;
 
 Font font = new Font("Arial",Font.BOLD | Font.ITALIC, 30);
 
 private class Al implements KeyEventDispatcher{   
  private int keyCode;
  @Override
         public boolean dispatchKeyEvent(KeyEvent e) {
             if (e.getID() == KeyEvent.KEY_PRESSED) {
              keyCode = e.getKeyCode();
              
              if(keyCode == KeyEvent.VK_LEFT)
              {
            	  if (x <= 5)
            		  x = 5;
            	  else
            		  x += -5;
              }
              if(keyCode == KeyEvent.VK_RIGHT) 
              {
            	  if (x >= 230)
            		  x = 230;
            	  else
            		  x += +5;
              }
              if(keyCode == KeyEvent.VK_UP) 
              {
            	  if (y <= 35)
            		  y = 35;
            	  else
            		  y += -5;
              }
              if(keyCode == KeyEvent.VK_DOWN) 
              {
            	  if (y >= 230)
            		  y = 230;
            	  else
            		  y += +5;
              }

             } else if (e.getID() == KeyEvent.KEY_RELEASED) {
                 //System.out.println("2test2");
             } else if (e.getID() == KeyEvent.KEY_TYPED) {
                 //System.out.println("3test3");
             }
             return false;
         }
 }

 
 public JavaGame(){
  // Load images
  ImageIcon i = new ImageIcon("smiley.png"); 
  face = i.getImage();
  
  // Game properties
  KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new Al());
  
  setSize(250,250);
  setTitle("Java Game");
  setVisible(true);
  setResizable(false);
  setLocationRelativeTo(null);
  setBackground(Color.CYAN);  
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
  g.setFont(font);
  g.setColor(Color.MAGENTA);
  g.drawString("Hello World!", 50, 80);
  g.setColor(Color.RED);
  g.drawImage(face,x,y,this);
  repaint();
 }
 
 public static void main(String[] args) {  
  new JavaGame();
 }
 
}