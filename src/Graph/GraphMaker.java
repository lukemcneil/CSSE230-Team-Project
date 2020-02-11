package Graph;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Hashtable;

public class GraphMaker {

    private Graph g;

    public static void main(String[] args) throws Exception {
        write(drawOlin2().nodes, "XML-data/olin2.xml");
        write(drawTestGraph().nodes, "XML-data/test.xml");
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

    private static Graph drawOlin2() {
        Graph Olin2 = new Graph();
        String[] names = {"TopStairsO269", "O269", "O267", "TopStairsOCommons", "O259", "O257", "O225Corner", "O222", "O227", "O229", "O226", "O231", "O233", "OTopHadCommons", "TopStairsO238", "O201", "O203", "O202", "O204", "O203-1", "O205", "O206", "O207Corner", "TopStairsO214"};
        for (String n : names) {
            Olin2.addNode(n);
        }
        Olin2.addEdge("TopStairsO269", "O269", 10);
        Olin2.addEdge("O269", "O267", 10);
        Olin2.addEdge("O267", "TopStairsOCommons", 30);
        Olin2.addEdge("TopStairsOCommons", "O259", 30);
        Olin2.addEdge("O259", "O257", 10);
        Olin2.addEdge("O257", "O225Corner", 40);
        Olin2.addEdge("O225Corner", "O222", 20);
        Olin2.addEdge("O225Corner", "TopStairsO214", 30);
        Olin2.addEdge("O222", "O227", 10);
        Olin2.addEdge("O227", "O229", 10);
        Olin2.addEdge("O229", "O226", 10);
        Olin2.addEdge("O226", "O231", 30);
        Olin2.addEdge("O231", "O233", 20);
        Olin2.addEdge("O233", "OTopHadCommons", 20);
        Olin2.addEdge("OTopHadCommons", "TopStairsO238", 15);
        Olin2.addEdge("OTopHadCommons", "O201", 20);
        Olin2.addEdge("O201", "O203", 10);
        Olin2.addEdge("O203", "O202", 20);
        Olin2.addEdge("O202", "O204", 10);
        Olin2.addEdge("O204", "O203-1", 10);
        Olin2.addEdge("O203-1", "O205", 10);
        Olin2.addEdge("O205", "O206", 10);
        Olin2.addEdge("O206", "O207Corner", 10);
        Olin2.addEdge("O207Corner", "TopStairsO214", 20);


        System.out.println("added olin2.xml");
        return Olin2;
    }

    private static Graph drawTestGraph() {
        Graph g = new Graph();

        Node n0 = new Node("n0");
        Node n1 = new Node("n1");
        Node n2 = new Node("n2");
        Node n3 = new Node("n3");
        Node n4 = new Node("n4");
        Node n5 = new Node("n5");
        Node n6 = new Node("n6");
        Node n7 = new Node("n7");

        addEdge(n0, n1, 3);
        addEdge(n0, n2, 5);

        addEdge(n1, n2, 6);
        addEdge(n1, n6, 1);

        addEdge(n2, n5, 7);
        addEdge(n2, n6, 7);

        addEdge(n3, n7, 2);

        addEdge(n4, n6, 7);
        addEdge(n4, n7, 7);

        addEdge(n5, n7, 1);

        addEdge(n6, n7, 7);

        g.nodes.put("n0", n0);
        g.nodes.put("n1", n1);
        g.nodes.put("n2", n2);
        g.nodes.put("n3", n3);
        g.nodes.put("n4", n4);
        g.nodes.put("n5", n5);
        g.nodes.put("n6", n6);
        g.nodes.put("n7", n7);
        System.out.println("added test.xml");

        return g;
    }
}