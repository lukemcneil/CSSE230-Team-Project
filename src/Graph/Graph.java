package Graph;

import java.awt.*;
import java.util.Hashtable;

public class Graph {
	public Hashtable<String, Node> nodes;
	private int m = 6;
	private int x = 370;
	private int y = 370;

	public Graph() {
		nodes = new Hashtable<String, Node>();
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
		m++;
	}

	public void zoomOut() {
		m--;
	}

	public void moveLeft() {
		x += 10;
	}

	public void moveRight() {
		x -= 10;
	}

	public void moveUp() {
		y += 10;
	}

	public void moveDown() {
		y -= 10;
	}
}
