package Graph;
public class Edge {
    public Node end;
    public int cost;
    public boolean highlighted=false;
    private String mode;

    public Edge() {
    }

    public Edge(Node end, int cost) {
        this.end = end;
        this.cost = cost;
    }
    
    public Edge(Node end, int cost, String mode) {
    	this.end = end;
    	this.cost = cost;
    	this.mode = mode;
    }

    public String toString() {
        return end.name + "(cost: " + cost + ") ";
    }
    
    public void setMode(String input) {
    	this.mode = input;
    }
    
    public String getMode() {
    	return this.mode;
    }
    
}
