package tests.Game1_16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class AI implements Runnable {

	Rectangle AI, target;
	
	int xDirection, yDirection;
	
	boolean resting = false;
		
	Image monster;
	
	public AI(Rectangle r, Rectangle t){
		AI = r;
		target = t;
		monster = new ImageIcon("src/tests/Game1_16/Monster_Down.png").getImage();
	}

	public void draw(Graphics g){
		g.drawImage(monster, AI.x, AI.y, null);
	}
	

	
	//Find a path to the target
	public void findPathToTarget(){
		if (AI.x < target.x)
			setXDirection(1);
		if (AI.x > target.x)
			setXDirection(-1);
		if (AI.y < target.y)
			setYDirection(1);
		if (AI.y > target.y)
			setYDirection(-1);
		
	}
	
	
	//Move in that direction
	public void detectEdges(){
		if (AI.x <=0){
			setXDirection(1);
		}
		if (AI.x >= 600 - AI.width){
			setXDirection(-1);
		}
		if (AI.y <= 25){
			setYDirection(1);
		}
		if (AI.y > 400 - AI.height){
			setYDirection(-1);
		}
			
	}
	public void setXDirection(int dir){
		xDirection = dir;
	}
	public void setYDirection(int dir){
		yDirection = dir;
	}
	public void move(){
		AI.x += xDirection;
		AI.y += yDirection;
/*
 		if (xDirection ==1)
			monster = new ImageIcon("Monster_Right.png").getImage();
		if (xDirection ==-1)
			monster = new ImageIcon("Monster_Left.png").getImage();
*/	
		if (yDirection ==1)
			monster = new ImageIcon("src/tests/Game1_16/Monster_Down.png").getImage();
		if (yDirection ==-1)
			monster = new ImageIcon("src/tests/Game1_16/Monster_Up.png").getImage();
	}
	
	
	//Move in that direction and the wait
	@Override
	public void run() {
		try{
			while(true){
				if (!resting){
					long start = System.currentTimeMillis();
					long end = start + 3 * 500;
					while (System.currentTimeMillis() < end ){
						findPathToTarget();
						move();
						detectEdges();
						Thread.sleep(10);
					}
					resting = true;
				}
				else{
					Thread.sleep(2000);
					resting = false;
				}
			}
		}catch(Exception ex){
			System.err.println(ex.getMessage());
		}
		
	}
}
