import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Hashtable;

public class AppMain {
	public static void main(String[] args) {
		Graph test = new Graph();
		try {
			test.nodes = read("XML-data/test.xml");
		}catch(Exception e) {
			
		}
		System.out.println();
		ArrayList<Node> temp = test.nodes.get("n1").pathTo(test.nodes.get("n4"));
		for(Node c : temp) {
			System.out.println(c);
		}
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
