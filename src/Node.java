import java.util.ArrayList;

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
