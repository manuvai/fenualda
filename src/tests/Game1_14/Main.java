package tests.Game1_14;

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
	
	boolean hardDifficulty = false;
	
	boolean gameStarted = false;
	
	boolean startHover;
	boolean difficultyHover;
	
	//Menu Buttons
	Rectangle startButton = new Rectangle(350, 300, 100, 25);
	Rectangle difficultyButton = new Rectangle(350, 350, 100, 25);
	
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
	    	if (!difficultyHover)
	    		g.setColor(Color.CYAN);
	    	else
	    		g.setColor(Color.PINK);
	    	g.fillRect(difficultyButton.x,  difficultyButton.y, difficultyButton.width, difficultyButton.height);
	    	g.setColor(Color.GRAY);
	    	g.drawString("Difficulty:", difficultyButton.x+10, difficultyButton.y+17);
	    	if (!hardDifficulty){
	    		g.setColor(Color.BLUE);
	    		g.drawString("Easy", difficultyButton.x+70, difficultyButton.y+17);
	    	}
	    	else
	    	{
	    		g.setColor(Color.RED);
	    		g.drawString("Hard", difficultyButton.x+70, difficultyButton.y+17);
	    	}
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
    		if (mx > difficultyButton.x  && mx < difficultyButton.x + difficultyButton.width &&  
       		    my > difficultyButton.y  && my < difficultyButton.y + difficultyButton.height)
    		{
    			difficultyHover = true;
    		}    		
    		else
    		{
    			difficultyHover = false;
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
    		if (mx > difficultyButton.x  && mx < difficultyButton.x + difficultyButton.width &&  
      		    my > difficultyButton.y  && my < difficultyButton.y + difficultyButton.height)
    		{
    			if (!hardDifficulty){
    				b.setDifficulty(4);
    				hardDifficulty = true;
    			}
    			else
    			{
    				b.setDifficulty(15);
    				hardDifficulty = false;
    				
    			}
    				
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