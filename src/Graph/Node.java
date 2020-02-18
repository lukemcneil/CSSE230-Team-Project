package Graph;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

public class Node {
	public String name;
	public ArrayList<Edge> edges;
	public Hashtable<Node, Node> pathFinder;
	public int x, y, cost, floor;
	public boolean highlighted, showName;
	private String schedulePicture;
	private Rectangle hitbox;
//	private String mode;
//
//	public void setMode(String m) {
//		mode=m;
//	}
//	
//	public String getMode() {
//		return mode;
//	}
	
	public Node() {
		this.edges = new ArrayList<Edge>();
		pathFinder = new Hashtable<Node, Node>();
		highlighted = false;
		showName = true;
	}

	public Node(String name) {
		this.edges = new ArrayList<Edge>();
		pathFinder = new Hashtable<Node, Node>();
		highlighted = false;
		this.name = name;
		showName = true;
		schedulePicture = null;
	}

	public Node(String name, int x, int y) {
		this.edges = new ArrayList<Edge>();
		pathFinder = new Hashtable<Node, Node>();
		highlighted = false;
		this.name = name;
		this.x = x;
		this.y = y;
		showName = true;
		schedulePicture = null;
	}

	public Node(String name, Point p, int floor) {
		this.edges = new ArrayList<Edge>();
		pathFinder = new Hashtable<Node, Node>();
		highlighted = false;
		this.name = name;
		this.x = p.x;
		this.y = p.y;
		showName = true;
		schedulePicture = null;
		this.floor = floor;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void addEdge(Node finish, int cost) {
		edges.add(new Edge(finish, cost));
	}
	
	public void addEdge(Node finish, int cost, String mode) {
		edges.add(new Edge(finish, cost, mode));
	}

	public String getName() {
		return name;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges.addAll(edges);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void drawOn(Graphics g, int xShift, int yShift, double m) {
		hitbox = new Rectangle((int) (x * m - xShift), (int) (y * m - yShift), 10, 10);

		Graphics2D g2 = (Graphics2D) g;
		if (highlighted) {
			g2.setColor(Color.red);
		} else {
			g2.setColor(Color.black);
		}
		g2.fillOval((int) (x * m - xShift), (int) (y * m - yShift), 10, 10);
		if (showName) {
			g2.drawString(name, (int) (x * m - xShift), (int) (y * m - yShift + 25));
		}
		g2.drawRect((int) hitbox.getX(), (int) hitbox.getY(), 10, 10);
	}

	public ArrayList<Node> pathTo(Node destination, Graph g) {
		if (pathFinder.isEmpty()) {
			this.dijkstra(g);
		}
		ArrayList<Node> finalPath = new ArrayList<Node>();
		ArrayList<Edge> edgedPath = new ArrayList<Edge>();
		finalPath.add(destination);
		Node end = destination;
		Node temp = pathFinder.get(destination);
		while (temp != null) {
			for (Edge e : temp.edges) {
				if (e.end == end) {
					edgedPath.add(e);
				}
			}
			finalPath.add(0, temp);
			end = temp;
			temp = pathFinder.get(temp);
		}
		System.out.println(edgedPath);
		return finalPath;

	}

	public ArrayList<Edge> edgePathTo(Node destination, Graph g) {
		cost = 0;
		if (pathFinder.isEmpty()) {
			this.dijkstra(g);
		}
		ArrayList<Edge> edgedPath = new ArrayList<Edge>();
		Node end = destination;
		Node temp = pathFinder.get(destination);
		while (temp != null) {
			for (Edge e : temp.edges) {
				if (e.end == end) {
					edgedPath.add(e);
					cost += e.cost;
				}
			}
			end = temp;
			temp = pathFinder.get(temp);
		}
		return edgedPath;
	}

	public Hashtable<Node, Integer> dijkstra(Graph g) {
		Hashtable<Node, Integer> costTable = new Hashtable<Node, Integer>();
		ArrayList<Node> completed = new ArrayList<Node>();

		this.dijkstraHelper(costTable, completed, pathFinder, g.getMode());
		costTable.put(this, 0);
		return costTable;
	}

	private void dijkstraHelper(Hashtable<Node, Integer> costTable, ArrayList<Node> completed,
	                            Hashtable<Node, Node> path, String mode) {
		completed.add(this);
		for (Edge curr : this.edges) {
			System.out.println("Edge Mode: "+ curr.getMode() +" vs graph: "+ mode);
			if (!completed.contains(curr.end) && !(curr.getMode()=="elevator" && mode=="stairs") || !completed.contains(curr.end)&& !(curr.getMode()=="stairs" && mode=="elevator")) {
				int currCost = costTable.get(this) == null ? 0 : costTable.get(this);
				if (costTable.containsKey(curr.end)) {
					int temp = curr.cost + costTable.get(this);
					if (temp < costTable.get(curr.end)) {
						costTable.replace(curr.end, curr.cost + currCost);
						path.put(curr.end, this);
					}
				} else {
					costTable.put(curr.end, curr.cost + currCost);
					path.put(curr.end, this);
				}

			}

		}
		Node temp = minNodeInMap(costTable, completed);
		if (temp != null) {
			temp.dijkstraHelper(costTable, completed, path, mode);
		}
	}

	private Node minNodeInMap(Hashtable<Node, Integer> costTable, ArrayList<Node> completed) {
		int minCost = 10000000;
		Node minNode = null;
		for (Node n : costTable.keySet()) {
			if (costTable.get(n) < minCost && costTable.get(n) != 0 && !completed.contains(n)) {
				minCost = costTable.get(n);
				minNode = n;
			}
		}
		return minNode;
	}

	public String toString() {
		String result = "name: " + name;
		result += " | edges: ";
		for (Edge e : edges) {
			result += e.toString();
		}
		result += "\n";
		return result;
	}

	public boolean isHighlighted() {
		return highlighted;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public void setImage(String fileName) {
		try {
			this.schedulePicture = fileName;
		} catch (Exception e) {
			System.out.println("File: " + fileName + " not find");
		}
	}

	public String getImage() {
		System.out.println("Picture:  " + this.schedulePicture);
		return this.schedulePicture;
	}

	public Rectangle getHitbox() {
		return hitbox;
	}

	public int getCost() {
		return cost;
	}
}
