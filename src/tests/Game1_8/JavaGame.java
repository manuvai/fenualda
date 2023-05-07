package tests.Game1_8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;


public class JavaGame extends JFrame {

	int GWIDTH = 400;
	int GHEIGHT = 300;
	
	private Image dbImage;
	private Graphics dbg;

	int x, y;
	
	boolean mouseOnScreen;
	
	public JavaGame(){
		setSize(GWIDTH, GHEIGHT);
		setTitle("Game");
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(new Mouse());
		
		
		x = 15;
		y = 15;
	}
	
	public class Mouse extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e){
			int xCoord = e.getX();
			int yCoord = e.getY();	
			x = xCoord-7;
			y = yCoord-7;
		}
		@Override
		public void mouseReleased(MouseEvent e){
			
		}
		@Override
		public void mouseEntered(MouseEvent e){
			mouseOnScreen = true;
		}
		@Override
		public void mouseExited(MouseEvent e){
			mouseOnScreen = false;
		}
	}
	
	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage,0,0,this);
	}
	
	 public void paintComponent(Graphics g){
		  g.fillOval(x, y, 15, 15);
		  g.setColor(Color.RED);
		  if (mouseOnScreen)
			  g.drawString("Coord: ("+x+", "+y+")", 150, 150);
		  repaint();

	 }
	
	public static void main(String[] args) {
		JavaGame main = new JavaGame();
		
	}
}