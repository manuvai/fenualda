package tests.Game2_8;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	GamePanel gp;

	public Main(){
		gp = new GamePanel();
		setSize(512,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		add(gp);
	}

	public static void main(String[] args){
		Main m = new Main();
	}
	
}