package Visuals;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		CaptchaPanel cp = new CaptchaPanel(frame);
		frame.add(cp);
		frame.pack();
//		Graph g = new Graph(frame);
//		try {
//			g.nodes = read("XML-data/OlinMoench.xml");
////			g.nodes = read("XML-data/Moench2.xml");
//		} catch (Exception e) {
//			System.out.println("could not read specified file");
//			return;
//		}
//		frame.setVisible(true);
//		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File("RoomInfo/icon.png"));
//		} catch (IOException e) {
//		}
//		frame.setIconImage(image);
//		frame.setFocusable(true);
//		JPanel buttonPanel = new ButtonPanel(g, frame);
//		JComponent mainComponent = new MainComponent(g, (ButtonPanel) buttonPanel);
//		JPanel stupidPanel = new JPanel();
//		stupidPanel.add(buttonPanel, BorderLayout.NORTH);
//		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
//		frame.add(mainComponent);
//		frame.add(stupidPanel, BorderLayout.EAST);
//		frame.setSize(800, 600);
//		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.repaint();
//		frame.addMouseWheelListener(new ScrollListener(g));
//		PanListener pl = new PanListener(g);
//		mainComponent.addMouseListener(pl);
//		mainComponent.addMouseMotionListener(pl);
	}
//
//	public static Hashtable<String, Node> read(String filename) throws Exception {
//		XMLDecoder decoder =
//				new XMLDecoder(
//						new BufferedInputStream(
//								new FileInputStream(filename)));
//		Hashtable<String, Node> n = (Hashtable<String, Node>) decoder.readObject();
//		decoder.close();
//		return n;
//	}
}
