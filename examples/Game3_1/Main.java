package tests.Game3_1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;


import javax.swing.JFrame;

public class Main extends JFrame{
	
	BufferedImage sprite;
	
	
	public Main(){
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		init();
	}

	private void init() {
		BufferedImageLoader loader = new BufferedImageLoader();
		BufferedImage spriteSheet = null;

		try {
			spriteSheet = loader.loadImage("monsters_set.png");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SpriteSheet ss = new SpriteSheet(spriteSheet);
		
		sprite = ss.grabSprite(0, 0, 32, 32);
		
	}
	
	@Override
	public void paint(Graphics g){
		g.drawImage(sprite, 100, 100, 50, 50,  null);
		repaint();
	}
	
	
	
	public static void main(String[] args){
		Main main = new Main();
	}
	
}