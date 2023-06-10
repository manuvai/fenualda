package tests.Game1_12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Main extends JFrame {
 
	//Double Buffering
	Image dbImage;
	Graphics dbg;
	
	//Ball objects
	static Ball b = new Ball(393,293);
	
	//Variables for screen size
	int
	GWIDTH = 800,
	GHEIGHT = 600;
	
	//Dimension of GWIDTH*GHEIGHT
    Dimension screenSize = new Dimension(GWIDTH,GHEIGHT);
 
    public Main() {
        this.setTitle("Pong Game");
    	this.setSize(screenSize);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        this.addKeyListener(new AL());
    }
 
    public void paint(Graphics g){
    	dbImage = createImage(getWidth(), getWidth());
    	dbg = dbImage.getGraphics();
    	draw(dbg);
    	g.drawImage(dbImage,  0,  0,  this);
    	
    }
    
    public void draw(Graphics g){
    	b.draw(g);
    	b.p1.draw(g);
    	b.p2.draw(g);
    	
    	g.setColor(Color.WHITE);
    	g.drawString(""+b.p1Score, 15, 50);
    	g.drawString(""+b.p2Score, 770, 50);
    	
    	repaint();
    }
    
    public class AL extends KeyAdapter {
 
    	@Override
        public void keyPressed(KeyEvent e) {
    		b.p1.keyPressed(e);
    		b.p2.keyPressed(e);
        }
 
    	@Override
        public void keyReleased(KeyEvent e) {
    		b.p1.keyReleased(e);
    		b.p2.keyReleased(e);
        }
    }
 
    public static void main(String[] args) {
        Main m = new Main();
        //Create and start threads
        Thread ball = new Thread(b);
        ball.start();
        Thread p1 = new Thread(b.p1);
        Thread p2 = new Thread(b.p2);
        p1.start();
        p2.start();
        
        
    }
}