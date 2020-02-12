package Visuals;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainComponent extends JComponent {

	private Graph graph;

	private Timer timer;

	public MainComponent(Graph g) {
		this.graph = g;
		this.timer = new Timer();
		timer.schedule(new ComponentTimerLogic(), 10, 10);
		repaint();
	}

	public void paintComponent(Graphics g) {
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<EdgeComponent> owTheEdge = new ArrayList<EdgeComponent>();
		for (String i : graph.getNodes().keySet()) {
			nodes.add(graph.getNodes().get(i));
		}

		for (Node n : nodes) {

			n.drawOn(g, graph.getX(), graph.getY(), graph.getM());
			for (Edge e : n.getEdges()) {
				Node n1 = e.end;
				Node n2 = n;
				owTheEdge.add(new EdgeComponent(e.cost, n1.x * graph.getM() - graph.getX(), n2.x * graph.getM() - graph.getX(), n1.y * graph.getM() - graph.getY(), n2.y * graph.getM() - graph.getY(), e.highlighted));
				n.drawOn(g, graph.getX(), graph.getY(), graph.getM());
			}
		}
		for (EdgeComponent e : owTheEdge) {
			if (!e.highlighted) {
				e.drawOn(g);
			}
		}
		for (EdgeComponent e : owTheEdge) {
			if (e.highlighted) {
				e.drawOn(g);
			}
		}
	}

	public class ComponentTimerLogic extends TimerTask {

		@Override
		public void run() {
			repaint();
		}
	}
}
