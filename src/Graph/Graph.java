package Graph;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class Graph {
	public Hashtable<String, Node> nodes;
	private final double zoomSensitivity = 0.2;
	private final double minimumZoom = 1;

	private double m = 6;
	private int x = -200;
	private int y = 200;
	private String mode="";
	JFrame frame;
	
	public String getMode() {
		return mode;
	}
	
	public void setMode(String s) {
		mode=s;
	}
	
	public Graph() {
		nodes = new Hashtable<String, Node>();
	}

	public Graph(JFrame frame) {
		nodes = new Hashtable<String, Node>();
		this.frame = frame;
	}

	public String toString() {
		return nodes.values().toString();
	}

	public Hashtable<String, Node> getNodes() {
		return nodes;
	}

	public void addNode(String name) {
		nodes.put(name, new Node(name));
	}

	public void addNode(String name, Point p) {
		nodes.put(name, new Node(name, p));
	}

	public void addEdge(String node1, String node2, int cost) {
		nodes.get(node1).addEdge(nodes.get(node2), cost);
		nodes.get(node2).addEdge(nodes.get(node1), cost);
	}

	public double getM() {
		return this.m;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void zoomIn(Point center) {
		if (center == null) {
			center = new Point(frame.getWidth() / 2, frame.getHeight() / 2);
		}
		double xtemp = (center.x + x) / m;
		double ytemp = (center.y + y) / m;
		double oldY = ytemp * m - y;
		double oldX = xtemp * m - x;
		m += zoomSensitivity;
		y = (int) (ytemp * m - oldY);
		x = (int) (xtemp * m - oldX);
	}

	public void zoomOut(Point center) {
		if (m <= minimumZoom) {
			return;
		}
		if (center == null) {
			center = new Point(frame.getWidth() / 2, frame.getHeight() / 2);
		}
		double xtemp = (center.x + x) / m;
		double ytemp = (center.y + y) / m;
		double oldY = ytemp * m - y;
		double oldX = xtemp * m - x;
		m -= zoomSensitivity;
		y = (int) (ytemp * m - oldY);
		x = (int) (xtemp * m - oldX);
	}

	public void moveLeft(int amount) {
		x += amount;
	}

	public void moveRight(int amount) {
		x -= amount;
	}

	public void moveUp(int amount) {
		y += amount;
	}

	public void moveDown(int amount) {
		y -= amount;
	}
}
