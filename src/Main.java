import ui.ComponentUI;
import ui.panel.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements ComponentUI {

	public Main(String title) {
		this(
				title,
				GWIDTH,
				GHEIGHT
		);
	}

	public Main(String title, int width, int height) {

		setTitle(title);
		setSize(width, height);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new GamePanel());
		setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Main("Hello");
	}
	
	public static void log(Object o) {
		System.out.println(o);
	}

}
