import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Hashtable;

public class AppMain {
	public static void main(String[] args) {
		Graph test = new Graph();
		try {
			test.nodes = read("XML-data/test.xml");
		}catch(Exception e) {
			
		}
		System.out.println(test);
		System.out.println(test.nodes.get("n3").dijkstra().values());
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
