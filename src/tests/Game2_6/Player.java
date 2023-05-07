package tests.Game2_6;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Player {
	private World world;
	
	private Rectangle playerRect;
	private Image playerImg;
	
	protected int xDirection, yDirection;
	
	public Player(World world){
		this.world = world;
		playerImg = new ImageIcon("src/tests/Game2_6/player.png").getImage();
		playerRect = new Rectangle(50,0,16,16);
	}
	
	private void setXDirection(int d){
		xDirection = d;
	}
	private void setYDirection(int d){
		yDirection = d;
	}
	public void update(){
		move();
		checkForCollision();
	}
	
	private void move(){
		playerRect.x += xDirection;
		playerRect.y +=yDirection;
		gravity();
	}
	
	private void gravity(){
		for (int i=0; i < world.arrayNum; i++){
			if (!world.isSolid[i]){
				setYDirection(1);				
			}
			else if (world.isSolid[i] && playerRect.intersects(world.blocks[i])){
				setYDirection(0);
			}
		}
		
	}
	
	private void checkForCollision(){
		
		
	}
	
	public void draw(Graphics g){
		g.drawImage(playerImg, playerRect.x, playerRect.y, null);
	}
	
}
