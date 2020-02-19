package Visuals;

import Graph.Graph;
import Graph.Node;
import Listeners.ClickListener;
import Listeners.EnterListener;
import Listeners.PanListener;
import Listeners.ScrollListener;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

public class CaptchaPanel extends JPanel {

	private JButton clickToContinue, enter;
	private TextField bestTeam, password;
	private JLabel whatsBest, whatPassword;
	private boolean clicked;

	private JFrame frame;

	public CaptchaPanel(JFrame frame) {
		this.frame = frame;
		setLayout(new GridLayout(8, 3, 10, 10));
		clickToContinue = new JButton("Click here");
		enter = new JButton("Enter");
		bestTeam = new TextField("");
		password = new TextField("");
		whatsBest = new JLabel("What team is the best?");
		whatPassword = new JLabel("10-digit password:");

		this.add(clickToContinue);
		this.add(whatsBest);
		this.add(bestTeam);
		this.add(whatPassword);
		this.add(password);
		this.add(enter);
		clickToContinue.addActionListener(new ClickListener(this));
		enter.addActionListener(new EnterListener(password, bestTeam, this));
	}

	public void setClickedTrue() {
		clicked = true;
	}

	public boolean getClicked() {
		return clicked;
	}

	public void startProgram() {
		frame.remove(this);
		Graph g = new Graph(frame);
		try {
			g.nodes = read("XML-data/OlinMoench.xml");
		} catch (Exception e) {
			System.out.println("could not read specified file");
			return;
		}
		frame.setVisible(true);
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("RoomInfo/icon.png"));
		} catch (IOException e) {
		}
		frame.setIconImage(image);
		frame.setFocusable(true);
		JPanel buttonPanel = new ButtonPanel(g, frame);
		JComponent mainComponent = new MainComponent(g, (ButtonPanel) buttonPanel);
		JPanel stupidPanel = new JPanel();
		stupidPanel.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		frame.add(mainComponent);
		frame.add(stupidPanel, BorderLayout.EAST);
		frame.setSize(800, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
		frame.addMouseWheelListener(new ScrollListener(g));
		PanListener pl = new PanListener(g);
		mainComponent.addMouseListener(pl);
		mainComponent.addMouseMotionListener(pl);
	}

	public static Hashtable<String, Node> read(String filename) throws Exception {
		XMLDecoder decoder =
				new XMLDecoder(
						new BufferedInputStream(
								new FileInputStream(filename)));
		Hashtable<String, Node> n = (Hashtable<String, Node>) decoder.readObject();
		decoder.close();
		return n;
	}
}
