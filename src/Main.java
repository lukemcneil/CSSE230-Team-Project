import javax.swing.JComponent;
import javax.swing.JFrame;

public class Main {
	public Main() {
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setFocusable(true);
		JComponent mainComponent = new MainComponent();
		frame.add(mainComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Main();
	}
}
