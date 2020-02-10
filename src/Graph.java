import java.util.Hashtable;

public class Graph {
    Hashtable<String, Node> nodes;

    public Graph() {
        nodes = new Hashtable<String, Node>();
    }

    public String toString() {
        return nodes.values().toString();
    }

    public Hashtable<String, Node> getNodes() {
        return nodes;
    }
}
