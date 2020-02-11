import org.junit.Test;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Hashtable;

import static org.junit.Assert.assertEquals;

public class Testing {

    @Test
    public void testBasicGraph() throws Exception {
        Graph g = new Graph();
        g.nodes = read("XML-data/test.xml");
        Hashtable<Node, Integer> costs = g.nodes.get("n0").dijkstra();

        Node n0 = g.nodes.get("n0");
        Node n1 = g.nodes.get("n1");
        Node n2 = g.nodes.get("n2");
        Node n3 = g.nodes.get("n3");
        Node n4 = g.nodes.get("n4");
        Node n5 = g.nodes.get("n5");
        Node n6 = g.nodes.get("n6");
        Node n7 = g.nodes.get("n7");

        assertEquals((int) costs.get(n0), 0);
        assertEquals((int) costs.get(n1), 3);
        assertEquals((int) costs.get(n2), 5);
        assertEquals((int) costs.get(n3), 13);
        assertEquals((int) costs.get(n4), 11);
        assertEquals((int) costs.get(n5), 12);
        assertEquals((int) costs.get(n6), 4);
        assertEquals((int) costs.get(n7), 11);

        assertEquals(n0.pathTo(n0).size(), 1);
        assertEquals(n0.pathTo(n1).size(), 2);
        assertEquals(n0.pathTo(n2).size(), 2);
        assertEquals(n0.pathTo(n3).size(), 5);
        assertEquals(n0.pathTo(n4).size(), 4);
        assertEquals(n0.pathTo(n5).size(), 3);
        assertEquals(n0.pathTo(n6).size(), 3);
        assertEquals(n0.pathTo(n7).size(), 4);

        assertEquals(n0.pathTo(n0).get(0), n0);

        assertEquals(n0.pathTo(n1).get(0), n0);
        assertEquals(n0.pathTo(n1).get(1), n1);

        assertEquals(n0.pathTo(n2).get(0), n0);
        assertEquals(n0.pathTo(n2).get(1), n2);

        assertEquals(n0.pathTo(n3).get(0), n0);
        assertEquals(n0.pathTo(n3).get(1), n1);
        assertEquals(n0.pathTo(n3).get(2), n6);
        assertEquals(n0.pathTo(n3).get(3), n7);
        assertEquals(n0.pathTo(n3).get(4), n3);

        assertEquals(n0.pathTo(n4).get(0), n0);
        assertEquals(n0.pathTo(n4).get(1), n1);
        assertEquals(n0.pathTo(n4).get(2), n6);
        assertEquals(n0.pathTo(n4).get(3), n4);

        assertEquals(n0.pathTo(n5).get(0), n0);
        assertEquals(n0.pathTo(n5).get(1), n2);
        assertEquals(n0.pathTo(n5).get(2), n5);

        assertEquals(n0.pathTo(n6).get(0), n0);
        assertEquals(n0.pathTo(n6).get(1), n1);
        assertEquals(n0.pathTo(n6).get(2), n6);

        assertEquals(n0.pathTo(n7).get(0), n0);
        assertEquals(n0.pathTo(n7).get(1), n1);
        assertEquals(n0.pathTo(n7).get(2), n6);
        assertEquals(n0.pathTo(n7).get(3), n7);
    }

    private static Hashtable<String, Node> read(String filename) throws Exception {
        XMLDecoder decoder =
                new XMLDecoder(
                        new BufferedInputStream(
                                new FileInputStream(filename)));
        Hashtable<String, Node> n = (Hashtable<String, Node>) decoder.readObject();
        decoder.close();
        return n;
    }
}





