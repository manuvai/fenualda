package tests.Game2_7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class Player {
	private World world;
	
	private Rectangle playerRect;
	private Image playerImg;
	
	protected int xDirection, yDirection;
	
	//Block variables
	private int hoverX, hoverY;
	private boolean hovering = false;
	
	public Player(World world){
		this.world = world;
		playerImg = new ImageIcon("src/tests/Game2_7/player.png").getImage();
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
	
	
	//Drawing methods
	public void draw(Graphics g){
		g.drawImage(playerImg, playerRect.x, playerRect.y, null);
		if (hovering){
			drawBlockOutline(g);
		}
	}
	
	public void drawBlockOutline(Graphics g){
		g.setColor(Color.BLACK);
		g.drawRect(hoverX, hoverY, world.blocks[0].width, world.blocks[0].height);
	}
	
	
	
	//Mouse events
	public void mousePressed(MouseEvent e){
		
	}
	public void mouseReleased(MouseEvent e){
		
	}
	public void mouseMoved(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		int px = playerRect.x;
		int py = playerRect.y;
		
		for (int i = 0; i < world.arrayNum; i++){
			if(x > world.blocks[i].x && x < world.blocks[i].x + world.blocks[i].width &&
			   y > world.blocks[i].y && y < world.blocks[i].y + world.blocks[i].height &&
			   world.isSolid[i]){
				hovering = true;
				hoverX = world.blocks[i].x;
				hoverY = world.blocks[i].y;
				break; // avoid time consuming
			}
			else {
				hovering = false;
			}
		}
	}
	public void mouseDragged(MouseEvent e){
		
	}
	
	private class Weapon {
		public static final int UNARMED = 0;
		public static final int PICKAXE = 1;
		public static final int GUN =2;
		
		public int CURRENT_WEAPON;
		
		public Weapon(int w){
			switch(w){
			default: 
				System.out.println("No weapon selected!");
				break;
			case UNARMED:
				CURRENT_WEAPON = UNARMED;
				break;
			case PICKAXE:
				CURRENT_WEAPON = PICKAXE;
				break;
			case GUN:
				CURRENT_WEAPON = GUN;
				break;
			}
			
		}
	
		public void selectWeapon(int w){
			switch(w){
			default: 
				System.out.println("No weapon selected!");
				break;
			case UNARMED:
				CURRENT_WEAPON = UNARMED;
				break;
			case PICKAXE:
				CURRENT_WEAPON = PICKAXE;
				break;
			case GUN:
				CURRENT_WEAPON = GUN;
				break;
			}
		}
		
		public boolean isEquipped(int w){
			if (w == CURRENT_WEAPON){
				return true;				
			}
			else
			{
				return false;
			}
		}
	}

}
