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
        for (String i : graph.getNodes().keySet()) {
//			g.drawOval(graph.getNodes().get(i).getVisualX(), graph.getNodes().get(i).getVisualY(), 30, 30);
        	nodes.add(new NodeComponent(graph.getNodes().get(i)));
        }
        for(NodeComponent n: nodes) {
        	n.drawOn(g);
        }
    } 
}
