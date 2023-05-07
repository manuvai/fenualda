package tests.Game2_4;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class World {
		
	private Rectangle[] blocks;
	private Image[] blockImg;
	//32*25 tiles de 25*25 px
	private final int arrayNum= 800;
	
	//Block Images
	private Image BLOCK_DIRT_TOP, BLOCK_DIRT, BLOCK_STONE, BLOCK_SKY;
	
	private int x, y;
	
	// Map navihation
	static final int PAN_UP = 0, PAN_DOWN = 1, PAN_LEFT = 2, PAN_RIGHT = 3;
	
	public World(){
		BLOCK_DIRT_TOP= new ImageIcon("tile_topDirt1.png").getImage();
		BLOCK_DIRT= new ImageIcon("tile_dirt1.png").getImage();
		BLOCK_STONE= new ImageIcon("tile_stone.png").getImage();
		BLOCK_SKY= new ImageIcon("tile_sky.png").getImage();
		blocks = new Rectangle[800];
		blockImg = new Image[800]; 
		
		loadArrays();
	}
	
	public void loadArrays(){
		for (int i = 0; i < arrayNum; i++){
			if (x >= 512){
				x = 0;
				y += 16;
			}
			if (i >= 0 && i <256){
				blockImg[i]=BLOCK_SKY;
				blocks[i] = new Rectangle(x, y, 16, 16);
			}
			
			if (i >= 256 && i < 288) {
				blockImg[i]=BLOCK_DIRT_TOP;
				blocks[i] = new Rectangle(x, y, 16, 16);
			}
			if (i >= 288 && i < 544) {
				blockImg[i]=BLOCK_DIRT;
				blocks[i] = new Rectangle(x, y, 16, 16);
			}
			if (i >=544 && i < 800) {
				blockImg[i]=BLOCK_STONE;
				blocks[i] = new Rectangle(x, y, 16, 16);
			}
			
			x += 16;
		}
	}
	public void draw(Graphics g){
		for (int i=0; i<arrayNum; i++){			
			g.drawImage(blockImg[i],blocks[i].x, blocks[i].y,null);
		}
			
	}
	
	public void navigateMap(int nav){
		
		switch(nav){
			default:
				System.out.println("default case entered... Doing nothing.");
				break;
			case PAN_UP:
				for (Rectangle r : blocks){
					r.y--;
				}
				break;
			case PAN_DOWN:
				for (Rectangle r : blocks){
					r.y++;
				}
				
				break;
			case PAN_LEFT:
				for (Rectangle r : blocks){
					r.x--;
				}
				
				break;
			case PAN_RIGHT:
				for (Rectangle r : blocks){
					r.x++;
				}
				
				break;
				
				
				
		}
		
		
	}
}
