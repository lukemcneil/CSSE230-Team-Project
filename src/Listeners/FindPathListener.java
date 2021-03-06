package Listeners;

import Graph.Edge;
import Graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FindPathListener implements ActionListener {

	private Graph g;
	private TextField start;
	private TextField end;

	private int cost = 0;

	public FindPathListener(Graph g, TextField room1, TextField room2) {
		this.g = g;
		start = room1;
		end = room2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		doStuff();
	}

	public void doStuff() {
		cost = 0;

		for (String i : g.getNodes().keySet()) { // Unhighlights all previous
			g.getNodes().get(i).setHighlighted(false);
			for (Edge c : g.nodes.get(i).edges) {
				c.highlighted = false;
			}
		}

		if (!g.getNodes().containsKey(start.getText())) {
			if (!g.getNodes().containsKey(end.getText())) {
				JOptionPane.showMessageDialog(null, "start and end are invalid");
				return;
			}
			JOptionPane.showMessageDialog(null, "start is invalid");
			return;
		} else if (!g.getNodes().containsKey(end.getText())) {
			JOptionPane.showMessageDialog(null, "end is invalid");
			return;
		}

		ArrayList<Edge> edgePath = g.nodes.get(start.getText()).edgePathTo(g.nodes.get(end.getText()), g);
		g.nodes.get(start.getText()).highlighted = true;
		g.nodes.get(end.getText()).highlighted = true;
		for (Edge edge : edgePath) {
			edge.highlighted = true;
		}
		cost = g.nodes.get(start.getText()).getCost();
	}

	public int getCost() {
		return cost;
	}
}
