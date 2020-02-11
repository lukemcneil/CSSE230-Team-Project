import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Hashtable;


public class GraphMaker {

    public static void main(String[] args) throws Exception {

        Graph g = new Graph();

        Node n1 = new Node("node1");
        Node n2 = new Node("node2");
        Node n3 = new Node("node3");

        ArrayList<Edge> n1edges = new ArrayList<Edge>();
        n1edges.add(new Edge(n2, 15));
        n1edges.add(new Edge(n3, 10));
        n1.setEdges(n1edges);

        ArrayList<Edge> n2edges = new ArrayList<Edge>();
        n2edges.add(new Edge(n1, 25));
        n2.setEdges(n2edges);

        ArrayList<Edge> n3edges = new ArrayList<Edge>();
        n3edges.add(new Edge(n1, 5));
        n3edges.add(new Edge(n2, 7));
        n3.setEdges(n3edges);

        g.nodes.put("n1", n1);
        g.nodes.put("n2", n2);
        g.nodes.put("n3", n3);
        System.out.println(g + "\n\n");

    //    write(g.nodes, "XML-data/test.xml");

        Hashtable<String, Node> readNodes = read("XML-data/test.xml");
        Graph newGraph = new Graph();
        newGraph.nodes = readNodes;
        System.out.println(newGraph);
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
}