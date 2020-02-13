package Visuals;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

public class MainComponent extends JComponent implements MouseListener {

	private Graph graph;

	private Timer timer;
	
	private ButtonPanel bp;

	public MainComponent(Graph g, ButtonPanel bp) {
		addMouseListener(this);
		this.graph = g;
		this.timer = new Timer();
		timer.schedule(new ComponentTimerLogic(), 10, 10);
		this.bp = bp;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		for(String i : graph.getNodes().keySet()) {
			graph.getNodes().get(i).setHighlighted(false);
			if(graph.getNodes().get(i).getHitbox().contains(e.getX(), e.getY())) {
				graph.getNodes().get(i).setHighlighted(true);
				if(e.getModifiers() == MouseEvent.BUTTON3_MASK) {
					bp.setDestination(i);
					bp.doStuff();
				}
				else {
					bp.setRoomNumber(i);
					bp.setStartingRoom(i);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
