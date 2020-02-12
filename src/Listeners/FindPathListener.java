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

	public FindPathListener(Graph g, TextField room1, TextField room2) {
		this.g = g;
		start = room1;
		end = room2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

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

		for (String i : g.getNodes().keySet()) { // Unhighlights all previous
			g.getNodes().get(i).setHighlighted(false);
			for (Edge c : g.nodes.get(i).edges) {
				c.highlighted = false;
			}
		}
		ArrayList<Edge> edgePath = g.nodes.get(start.getText()).edgePathTo(g.nodes.get(end.getText()));
		g.nodes.get(start.getText()).highlighted = true;
		g.nodes.get(end.getText()).highlighted = true;
		for (Edge edge : edgePath) {
			edge.highlighted = true;
		}
	}

}
