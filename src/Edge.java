public class Edge {
    public Node end;
    public int cost;

    public Edge() {
    }

    public Edge(Node end, int cost) {
        this.end = end;
        this.cost = cost;
    }

    public String toString() {
        return end.name + "(cost: " + cost + ") ";
    }

}
