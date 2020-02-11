import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MainComponent extends JComponent {

    private Graph graph;

    public MainComponent(Graph g) {
        this.graph = g;
        repaint();
    }

    public void paintComponent(Graphics g) {
    	ArrayList<NodeComponent> nodes=new ArrayList<NodeComponent>();
    	ArrayList<EdgeComponent> owTheEdge=new ArrayList<EdgeComponent>();
        for (String i : graph.getNodes().keySet()) {
//			g.drawOval(graph.getNodes().get(i).getVisualX(), graph.getNodes().get(i).getVisualY(), 30, 30);
        	nodes.add(new NodeComponent(graph.getNodes().get(i)));
        }
        for(NodeComponent n: nodes) {
        	n.drawOn(g);
        	for(Edge e: n.target.getEdges()) {
        		Node n1=e.end;
        		Node n2=n.target;
        		owTheEdge.add(new EdgeComponent(n1.x, n2.x, n1.y, n2.y, e.cost));
        	}
        }
        for(EdgeComponent e: owTheEdge) {
        	e.drawOn(g);
        }
    } 
}
