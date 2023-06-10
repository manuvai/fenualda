package tests.Game2_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	//Double buffering
	private Image dbImage;
	private Graphics dbg;
	//JPanel variables
	static final int GWIDTH = 512, GHEIGHT = 400;
	static final Dimension gameDim = new Dimension(GWIDTH, GHEIGHT);
	//Game variables
	private Thread game;
	private volatile boolean running = false;
	
	//Game Objects
	World world;
	
	public GamePanel(){
		world = new World();
		
		setPreferredSize(gameDim);
		setBackground(Color.WHITE);
		setFocusable(true);
		requestFocus();
		//Handle all key inputs from user
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				
			}
			public void keyReleased(KeyEvent e){
				
			}
			public void keyTyped(KeyEvent e){
				
			}
		});
	}
	
	public void addNotify(){
		super.addNotify();
		startGame();
	}
	
	public void startGame(){
		if(game == null || !running){
			game = new Thread(this);
			game.start();
			running = true;
		}
	}
	
	public void stopGame() {
		if (running){
			running = false;
		}
	}
	
	private void log(String s){
		System.out.println(s);
	}

	@Override
	public void run() {
		while (running){
			
			gameUpdate();
			gameRender();
			paintScreen();
			
		}
		
	}
	
	private void gameUpdate(){
		if (running && game != null){
			//update game state
		}
	}

	private void gameRender(){
		if (dbImage == null) {// create the buffer
			dbImage = createImage(GWIDTH, GHEIGHT);
			if (dbImage == null) {
				System.err.println("dbImage is still null!");
				return;
			}
			else{
				dbg = dbImage.getGraphics();
			}
		}
		//Clear the screen
		dbg.setColor(Color.WHITE);
		dbg.fillRect(0, 0, GWIDTH, GHEIGHT);
		//Draw Game elements
		draw(dbg);
		
	}

	/* Draw all game content in this method */
	private void draw(Graphics g) {
		world.draw(g);
		
	}
	
	private void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if (dbImage != null && g != null){
				g.drawImage(dbImage, 0, 0, null);
			}
			Toolkit.getDefaultToolkit().sync(); // for some os such as linux
			g.dispose();
		}catch(Exception e){
			System.err.println(e);
		}
		
	}
	
	
}
