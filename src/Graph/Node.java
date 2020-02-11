package Graph;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;

public class Node{
    public String name;
    public ArrayList<Edge> edges;
    public Hashtable<Node, Node> pathFinder;
    public int x;
    public int y;
    public boolean highlighted;

	public Node() {
        this.edges = new ArrayList<Edge>();
        pathFinder = new Hashtable<Node, Node>();
        highlighted=false;
    }

    public Node(String name) {
    	this.edges = new ArrayList<Edge>();
        pathFinder = new Hashtable<Node, Node>();
        highlighted=false;
        this.name = name;
       
    }
    
    public Node(String name, int x, int y) {
    	this.edges = new ArrayList<Edge>();
        pathFinder = new Hashtable<Node, Node>();
        highlighted=false;
    	this.name=name;
    	this.x=x;
    	this.y=y;

    }
    
    public Node(String name, Point p) {
    	this.edges = new ArrayList<Edge>();
        pathFinder = new Hashtable<Node, Node>();
        highlighted=false;
    	this.name = name;
    	this.x = p.x;
    	this.y = p.y;
    	
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Node finish, int cost) {
        edges.add(new Edge(finish, cost));
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

    public void drawOn(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if(highlighted) {
        	g2.setColor(Color.red);
        }else {
        	g2.setColor(Color.black);
        }
        g2.fillOval(x, y, 10, 10);
        g2.drawString(name, x, y + 25);
    }
    
    public ArrayList<Node> pathTo(Node destination) {
        if (pathFinder.isEmpty()) {
            this.dijkstra();
        }
        ArrayList<Node> finalPath = new ArrayList<Node>();
        finalPath.add(destination);
        Node temp = pathFinder.get(destination);
        while (temp != null) {
            finalPath.add(0, temp);
            temp = pathFinder.get(temp);
        }
        return finalPath;

    }

    public Hashtable<Node, Integer> dijkstra() {
        Hashtable<Node, Integer> costTable = new Hashtable<Node, Integer>();
        ArrayList<Node> completed = new ArrayList<Node>();

        this.dijkstraHelper(costTable, completed, pathFinder);
        costTable.put(this, 0);
        return costTable;
    }

    private void dijkstraHelper(Hashtable<Node, Integer> costTable, ArrayList<Node> completed, Hashtable<Node, Node> path) {
        completed.add(this);
        for (Edge curr : this.edges) {
            if (!completed.contains(curr.end)) {
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
            temp.dijkstraHelper(costTable, completed, path);
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
}
