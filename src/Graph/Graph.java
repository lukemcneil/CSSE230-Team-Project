package Graph;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;

public class Graph {
	public Hashtable<String, Node> nodes;
	private int m = 6;
	private int x = 370;
	private int y = 550;
	JFrame frame;

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

	public int getM() {
		return this.m;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void zoomIn() {
		double xtemp = (MouseInfo.getPointerInfo().getLocation().getX() + x) / m;
		double ytemp = (MouseInfo.getPointerInfo().getLocation().getY() + y) / m;
		double oldY = ytemp * m - y;
		double oldX = xtemp * m - x;
		m++;
		y = (int) (ytemp * m - oldY);
		x = (int) (xtemp * m - oldX);
	}

	public void zoomOut() {
		if (m == 1) {
			return;
		}
		double xtemp = (MouseInfo.getPointerInfo().getLocation().getX() + x) / m;
		double ytemp = (MouseInfo.getPointerInfo().getLocation().getY() + y) / m;
		double oldY = ytemp * m - y;
		double oldX = xtemp * m - x;
		m--;
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
