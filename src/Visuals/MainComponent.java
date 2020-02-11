package Visuals;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

public class MainComponent extends JComponent {

    private Graph graph;

    public MainComponent(Graph g) {
        this.graph = g;
        repaint();
    }

    public void paintComponent(Graphics g) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<EdgeComponent> owTheEdge = new ArrayList<EdgeComponent>();
        for (String i : graph.getNodes().keySet()) {
        	nodes.add(graph.getNodes().get(i));
        }
        for (Node n : nodes) {
        	n.highlighted=true;
            n.drawOn(g);
            for (Edge e : n.getEdges()) {
                Node n1 = e.end;
                Node n2 = n;
                owTheEdge.add(new EdgeComponent(e.cost, n1.x, n2.x, n1.y, n2.y));
            }
        }
        for (EdgeComponent e : owTheEdge) {
            e.drawOn(g);
        }
        for(Node n : nodes) {
        	n.drawOn(g);
        }
    }
}
