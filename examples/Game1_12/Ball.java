package tests.Game1_12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {

	//global variables
	int x, y, xDirection, yDirection;

	//Score
	int p1Score, p2Score;
	
	Paddle p1 = new Paddle(15, 140, 1);
	Paddle p2 = new Paddle(770, 140, 2);
	
	Rectangle ball;

	public Ball(int x, int y) { 
		p1Score = 0;
		p2Score = 0;
		this.x = x;
		this.y = y;
		//Set ball moving randomly
		Random r = new Random();
		//int rDir = r.nextInt(1);
		if(r.nextBoolean()) {
			setXDirection(-1);
		} else {
			setXDirection(1);
		}
		if(r.nextBoolean()) {
			setYDirection(-1);
		} else {
			setYDirection(1);
		}
		//Create ball
		ball = new Rectangle(this.x, this.y, 15, 15);

	}
	
	public void setXDirection(int xdir){
		xDirection=xdir;
	}
	
	public void setYDirection(int ydir){
		yDirection=ydir;
	}
	
	public void draw(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(ball.x, ball.y, ball.width, ball.height);		
	}
	
	public void move(){
		collision();
		ball.x += xDirection;
		ball.y += yDirection;
		// Bounce the ball when the edge is detected
		if (ball.x <= 0){
			setXDirection(+1);
			p2Score++;
		}
		if (ball.x >= 785)
		{
			setXDirection(-1);
			p1Score++;
		}
		if (ball.y <= 30){
			setYDirection(+1);
			//add to score
		}
		if (ball.y >= 585)
		{
			setYDirection(-1);
			//add to score
		}
	}
	
	public void collision(){
		if (ball.intersects(p1.paddle))
			setXDirection(+1);
		if (ball.intersects(p2.paddle))
			setXDirection(-1);
		
	}
	
	@Override
	public void run() {
		try {
			while (true){
				move();
				Thread.sleep(6);
			}
		}catch(Exception e){System.err.println(e.getMessage());}
		
		
	}
	
	
}