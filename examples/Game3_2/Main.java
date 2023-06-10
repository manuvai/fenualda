package tests.Game3_2;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	BufferedImage sprite;
	
	Animator dragon;
	
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
		
		ArrayList<BufferedImage> sprites = new ArrayList<BufferedImage>();
		
		
		sprites.add(ss.grabSprite(0, 0, 32, 32));
		sprites.add(ss.grabSprite(32, 0, 32, 32));
		sprites.add(ss.grabSprite(64, 0, 32, 32));
		
		dragon = new Animator(sprites);
		dragon.setSpeed(100);
		dragon.play();
	}

	Image dbImage;
	Graphics dbg;
	
	@Override
	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0,  null);
		repaint();
	}
	
	public void paintComponent(Graphics g){
		if (dragon != null){
			dragon.update(System.currentTimeMillis());
			g.drawImage(dragon.sprite, 100, 100, 300, 300, null);
		}
		repaint();
	}
	
	
	public static void main(String[] args){
		Main main = new Main();
	}
	
}