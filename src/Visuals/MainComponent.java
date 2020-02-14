package Visuals;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainComponent extends JComponent implements MouseListener {

	private Graph graph;

	private Timer timer;

	private ButtonPanel bp;

	private boolean hasRightClicked = false;

	private int cost = 0;

	public MainComponent(Graph g, ButtonPanel bp) {
		addMouseListener(this);
		this.graph = g;
		this.timer = new Timer();
		timer.schedule(new ComponentTimerLogic(), 10, 10);
		this.bp = bp;
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.BLACK);
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<EdgeComponent> owTheEdge = new ArrayList<EdgeComponent>();
		for (String i : graph.getNodes().keySet()) {
			nodes.add(graph.getNodes().get(i));
		}

		for (Node n : nodes) {
			if (n.floor == graph.getFloor()) {
				n.drawOn(g, graph.getX(), graph.getY(), graph.getM());
			}
			for (Edge e : n.getEdges()) {
				Node n1 = e.end;
				Node n2 = n;
				if (n1.floor == n2.floor) {
					owTheEdge.add(new EdgeComponent(e.cost, (int) (n1.x * graph.getM() - graph.getX()),
							(int) (n2.x * graph.getM() - graph.getX()), (int) (n1.y * graph.getM() - graph.getY()),
							(int) (n2.y * graph.getM() - graph.getY()), e.highlighted, e.end.floor));
					// n.drawOn(g, graph.getX(), graph.getY(), graph.getM());
				}
			}
		}
		for (EdgeComponent e : owTheEdge) {
			if (!e.highlighted && e.getFloor() == graph.getFloor()) {
				e.drawOn(g);

			}
		}
		for (EdgeComponent e : owTheEdge) {
			if (e.highlighted && e.getFloor() == graph.getFloor()) {
				e.drawOn(g);
			}
		}
		if (cost == 0) {
			g.drawString("Cost: ", 3, 12);
		} else {
			g.drawString("Cost: " + cost, 3, 12);
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
		boolean highlightedInForLoop = false;
		for (String i : graph.getNodes().keySet()) {
			if (!(e.getModifiers() == MouseEvent.BUTTON3_MASK)) {
				graph.getNodes().get(i).setHighlighted(false);
			}
			if (graph.getNodes().get(i).getHitbox() != null && graph.getNodes().get(i).getHitbox().contains(e.getX(), e.getY())) {
				graph.getNodes().get(i).setHighlighted(true);
				if (e.getModifiers() == MouseEvent.BUTTON3_MASK) {
					bp.setDestination(i);
					cost = bp.doStuff();
					hasRightClicked = true;
				} else {
					bp.setRoomNumber(i);
					bp.setStartingRoom(i);
					if (hasRightClicked) {
						cost = bp.doStuff();
					}
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
