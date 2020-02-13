package Visuals;

import Graph.Graph;
import Graph.Node;

import javax.swing.*;
import java.awt.*;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Hashtable;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Graph g = new Graph(frame);
		try {
			g.nodes = read("XML-data/olin2.xml");
		} catch (Exception e) {
			System.out.println("could not read specified file");
			return;
		}
		frame.setVisible(true);
		frame.setFocusable(true);
		JComponent mainComponent = new MainComponent(g);
		JPanel buttonPanel = new ButtonPanel(g);
		JPanel stupidPanel = new JPanel();
		stupidPanel.add(buttonPanel, BorderLayout.NORTH);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
		frame.add(mainComponent);
		frame.add(stupidPanel, BorderLayout.EAST);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.repaint();
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

