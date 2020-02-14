package Graph;

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
		Hashtable<Node, Integer> costs = g.nodes.get("n0").dijkstra(g);

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

		assertEquals(n0.pathTo(n0, g).size(), 1);
		assertEquals(n0.pathTo(n1, g).size(), 2);
		assertEquals(n0.pathTo(n2, g).size(), 2);
		assertEquals(n0.pathTo(n3, g).size(), 5);
		assertEquals(n0.pathTo(n4, g).size(), 4);
		assertEquals(n0.pathTo(n5, g).size(), 3);
		assertEquals(n0.pathTo(n6, g).size(), 3);
		assertEquals(n0.pathTo(n7, g).size(), 4);

		assertEquals(n0.pathTo(n0, g).get(0), n0);

		assertEquals(n0.pathTo(n1, g).get(0), n0);
		assertEquals(n0.pathTo(n1, g).get(1), n1);

		assertEquals(n0.pathTo(n2, g).get(0), n0);
		assertEquals(n0.pathTo(n2, g).get(1), n2);

		assertEquals(n0.pathTo(n3, g).get(0), n0);
		assertEquals(n0.pathTo(n3, g).get(1), n1);
		assertEquals(n0.pathTo(n3, g).get(2), n6);
		assertEquals(n0.pathTo(n3, g).get(3), n7);
		assertEquals(n0.pathTo(n3, g).get(4), n3);

		assertEquals(n0.pathTo(n4, g).get(0), n0);
		assertEquals(n0.pathTo(n4, g).get(1), n1);
		assertEquals(n0.pathTo(n4, g).get(2), n6);
		assertEquals(n0.pathTo(n4, g).get(3), n4);

		assertEquals(n0.pathTo(n5, g).get(0), n0);
		assertEquals(n0.pathTo(n5, g).get(1), n2);
		assertEquals(n0.pathTo(n5, g).get(2), n5);

		assertEquals(n0.pathTo(n6, g).get(0), n0);
		assertEquals(n0.pathTo(n6, g).get(1), n1);
		assertEquals(n0.pathTo(n6, g).get(2), n6);

		assertEquals(n0.pathTo(n7, g).get(0), n0);
		assertEquals(n0.pathTo(n7, g).get(1), n1);
		assertEquals(n0.pathTo(n7, g).get(2), n6);
		assertEquals(n0.pathTo(n7, g).get(3), n7);
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





