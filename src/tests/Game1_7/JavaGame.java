package tests.Game1_7;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JavaGame extends JFrame implements Runnable {

 int x,y, xDirection, yDirection;
 private Image dbImage;
 private Graphics dbg;
 Image face;
 
 public void run() {
	 try {
		 while(true) {
			 
			 move();
			 
			 Thread.sleep(5);
			 
		 }
	 }
	 catch (Exception e) {
		 System.out.println("Error");
	 }
 }
 
 public void move(){
	 x += xDirection;
	 y += yDirection;
	 if (x <= 0)
		 x = 0;
	 if (x >= 200)
		 x = 200;
	 if (y <= 50)
		 y = 50;
	 if (y >= 200)
		 y = 200;
	 
	 
 }
 public void setXDirection(int xdir) {
	 xDirection = xdir;
 }
 public void setYDirection(int ydir) {
	 yDirection = ydir;
 }
 
 Font font = new Font("Arial",Font.BOLD | Font.ITALIC, 30);
 
 private class Al implements KeyEventDispatcher{   
  private int keyCode;
  @Override
         public boolean dispatchKeyEvent(KeyEvent e) {
             if (e.getID() == KeyEvent.KEY_PRESSED) {
              keyCode = e.getKeyCode();
              if(keyCode == KeyEvent.VK_LEFT)
              {
            	  setXDirection(-1);
              }
              if(keyCode == KeyEvent.VK_RIGHT) 
              {
            	  setXDirection(+1);
              }
              if(keyCode == KeyEvent.VK_UP) 
              {
            	  setYDirection(-1);
              }
              if(keyCode == KeyEvent.VK_DOWN) 
              {
            	  setYDirection(+1);
              }

             } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            	 keyCode = e.getKeyCode();
                 if(keyCode == KeyEvent.VK_LEFT)
                 {
                	 setXDirection(0);
                 }
                 if(keyCode == KeyEvent.VK_RIGHT) 
                 {
                	 setXDirection(0);
                 }
                 if(keyCode == KeyEvent.VK_UP) 
                 {
                	 setYDirection(0);
                 }
                 if(keyCode == KeyEvent.VK_DOWN) 
                 {
                	 setYDirection(0);
                 }

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
  JavaGame jg = new JavaGame();
  //Threads
  Thread t1 = new Thread(jg);
  t1.start();
 }
 
}