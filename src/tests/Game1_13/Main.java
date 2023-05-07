package tests.Game1_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Main extends JFrame {
 
	//Double Buffering
	Image dbImage;
	Graphics dbg;
	
	//Ball objects
	static Ball b = new Ball(393,293);
	
	Thread ball = new Thread(b);
	Thread p1 = new Thread(b.p1);
	Thread p2 = new Thread(b.p2);
	
	boolean gameStarted = false;
	
	boolean startHover;
	boolean quitHover;
	
	//Menu Buttons
	Rectangle startButton = new Rectangle(350, 300, 100, 25);
	Rectangle quitButton = new Rectangle(350, 350, 100, 25);
	
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
        this.addMouseListener(new MouseHandler());
        this.addMouseMotionListener(new MouseHandler());
        
    }
 
    public void paint(Graphics g){
    	dbImage = createImage(getWidth(), getWidth());
    	dbg = dbImage.getGraphics();
    	draw(dbg);
    	g.drawImage(dbImage,  0,  0,  this);
    	
    }
    
    public void draw(Graphics g){
    	//Menu
    	
    	if (!gameStarted)
    	{
    		g.setFont(new Font("Arial", Font.BOLD, 26));
	    	g.setColor(Color.WHITE);
	    	g.drawString("Pong Game!", 325, 75);
	    	if (!startHover)
	    		g.setColor(Color.CYAN);
	    	else
	    		g.setColor(Color.PINK);
	    	g.fillRect(startButton.x,  startButton.y, startButton.width, startButton.height);
	    	g.setFont(new Font("Arial", Font.BOLD, 12));
	    	g.setColor(Color.GRAY);
	    	g.drawString("Start Game", startButton.x+20, startButton.y+17);
	    	if (!quitHover)
	    		g.setColor(Color.CYAN);
	    	else
	    		g.setColor(Color.PINK);
	    	g.fillRect(quitButton.x,  quitButton.y, quitButton.width, quitButton.height);
	    	g.setColor(Color.GRAY);
	    	g.drawString("Quit Game", quitButton.x+20, quitButton.y+17);
    	}
    	else
    	{
	    	//Game drawings
	    	b.draw(g);
	    	b.p1.draw(g);
	    	b.p2.draw(g);
	    	
	    	//Scores   	
	    	g.setColor(Color.WHITE);
	    	g.drawString(""+b.p1Score, 15, 50);
	    	g.drawString(""+b.p2Score, 770, 50);
    	}
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
    
    public class MouseHandler extends MouseAdapter {
    	@Override
    	public void mouseMoved(MouseEvent e){
    		int mx = e.getX();
    		int my = e.getY();
    		
    		if (mx > startButton.x  && mx < startButton.x + startButton.width &&  
    		    my > startButton.y  && my < startButton.y + startButton.height)
    		{
    			startHover = true;
    		}    		
    		else
    		{
    			startHover = false;
    		}
    		if (mx > quitButton.x  && mx < quitButton.x + quitButton.width &&  
       		    my > quitButton.y  && my < quitButton.y + quitButton.height)
    		{
    			quitHover = true;
    		}    		
    		else
    		{
    			quitHover = false;
    		}
    	}
    	@Override
    	public void mousePressed(MouseEvent e){
    		int mx = e.getX();
    		int my = e.getY();
    		if (mx > startButton.x  && mx < startButton.x + startButton.width &&  
    		    my > startButton.y  && my < startButton.y + startButton.height)
    		{
    			startGame();
    		}
    	}
    }    
 
    public void startGame(){
    	gameStarted = true;
    	ball.start();
    	p1.start();
    	p2.start();
    }
    public static void main(String[] args) {
        Main m = new Main();
    }

}