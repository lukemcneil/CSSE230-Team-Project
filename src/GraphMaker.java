import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Hashtable;


public class GraphMaker {
	
	private Graph g;
	
	public GraphMaker() {
		g = new Graph();

        Node n1 = new Node("n1", 10, 10);
        Node n2 = new Node("n2", 90, 10);
        Node n3 = new Node("n3", 170, 10);
        Node n4 = new Node("n4", 250, 10);

        addEdge(n1, n2, 15);
        addEdge(n1, n3, 5);
        addEdge(n2, n3, 10);
        addEdge(n3, n4, 20);

        g.nodes.put("n1", n1);
        g.nodes.put("n2", n2);
        g.nodes.put("n3", n3);
        g.nodes.put("n4", n4);
//        System.out.println(g + "\n\n");

//        write(g.nodes, "XML-data/test.xml");

//        Hashtable<String, Node> readNodes = read("XML-data/test.xml");
//        Graph newGraph = new Graph();
//        newGraph.nodes = readNodes;
//        System.out.println(newGraph);
	}
	
    public static void main(String[] args) throws Exception {
    	
        Graph g = new Graph();

        Node n1 = new Node("n1", 10, 10);
        Node n2 = new Node("n2", 90, 10);
        Node n3 = new Node("n3", 170, 10);
        Node n4 = new Node("n4", 250, 10);

        addEdge(n1, n2, 15);
        addEdge(n1, n3, 5);
        addEdge(n2, n3, 10);
        addEdge(n3, n4, 20);

        g.nodes.put("n1", n1);
        g.nodes.put("n2", n2);
        g.nodes.put("n3", n3);
        g.nodes.put("n4", n4);
        System.out.println(g + "\n\n");

        write(g.nodes, "XML-data/test.xml");

        Hashtable<String, Node> readNodes = read("XML-data/test.xml");
        Graph newGraph = new Graph();
        newGraph.nodes = readNodes;
        System.out.println(newGraph);
    }

    private static void addEdge(Node node1, Node node2, int cost) {
        node1.addEdge(node2, cost);
        node2.addEdge(node1, cost);
    }

    private static void write(Hashtable<String, Node> nodes, String filename) throws Exception {
        XMLEncoder encoder =
                new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)));
        encoder.writeObject(nodes);
        encoder.close();
    }

    public static Hashtable<String, Node> read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(
                        new BufferedInputStream(
                                new FileInputStream(filename)));
        Hashtable<String, Node> n = (Hashtable<String, Node>) decoder.readObject();
        decoder.close();
        return n;
    }
    
    public Graph getGraph() {
    	return g;
    }
}