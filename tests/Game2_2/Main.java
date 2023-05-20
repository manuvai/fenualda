package tests.Game2_2;

import javax.swing.JFrame;

public class Main extends JFrame{
	
	GamePanel gp;

	public Main(){
		gp = new GamePanel();
		setSize(1090,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		add(gp);
	}

	public static void main(String[] args){
		Main m = new Main();
	}
	
}