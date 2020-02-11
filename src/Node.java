import java.util.ArrayList;
import java.util.Hashtable;

public class Node {
	public String name;
	public ArrayList<Edge> edges;

	public Node() {
	}

	public Node(String name) {
		this.name = name;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public String getName() {
		return name;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hashtable<Node, Integer> dijkstra() {
		Hashtable<Node, Integer> costTable = new Hashtable<Node, Integer>();
		ArrayList<Node> completed = new ArrayList<Node>();

		this.dijkstraHelper(costTable, completed);

		return costTable;
	}

	private void dijkstraHelper(Hashtable<Node, Integer> costTable, ArrayList<Node> completed) {
		completed.add(this);
		for (Edge curr : this.edges) {
			if (!completed.contains(curr.end)) {
				int currCost = costTable.get(this)==null ? 0 : costTable.get(this);
				if (costTable.containsKey(curr.end)) {
					int temp = curr.cost + costTable.get(this);
					if (temp < costTable.get(curr.end)) {
						costTable.replace(curr.end, curr.cost + currCost);
					}
				} else {
					costTable.put(curr.end, curr.cost + currCost);
				}

			}

		}
		Node temp = minNodeInMap(costTable, completed);
		if (temp != null) {
			temp.dijkstraHelper(costTable, completed);
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
}
