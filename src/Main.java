import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

	public Main(String title) {
		this(
				title,
				Toolkit.getDefaultToolkit()
						.getScreenSize()
		);
	}

	public Main (String title, Dimension screenSize ) {
		this(
				title,
				(int) screenSize.getWidth(),
				(int) screenSize.getHeight()
		);

	}

	public Main(String title, int width, int height) {

		setTitle(title);
		setSize(width,height);

		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main("Hello");
	}
	
	public static void log(Object o) {
		System.out.println(o);
	}

}
