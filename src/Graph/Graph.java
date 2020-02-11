package Graph;
import java.util.Hashtable;

public class Graph {
    public Hashtable<String, Node> nodes;

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
    
    public void addEdge(String node1, String node2, int cost) {
        nodes.get(node1).addEdge(nodes.get(node2), cost);
        nodes.get(node2).addEdge(nodes.get(node1), cost);
    }
}
