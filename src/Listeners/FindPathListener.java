package Listeners;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Graph.Edge;
import Graph.Graph;
import Graph.Node;

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
		for(String i : g.getNodes().keySet()) { // Unhighlights all previous
			g.getNodes().get(i).setHighlighted(false);
			for(Edge c : g.nodes.get(i).edges) {
				c.highlighted=false;
			}
		}
		ArrayList<Edge> edgePath = g.nodes.get(start.getText()).edgePathTo(g.nodes.get(end.getText()));
		g.nodes.get(start.getText()).highlighted = true;
		g.nodes.get(end.getText()).highlighted = true;
		for(Edge edge : edgePath) {
			edge.highlighted = true;
		}
	}

}
