package Listeners;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import Graph.Graph;
import Graph.Node;

public class TripPlannerListener implements ActionListener {

	private Graph g;
	private TextField start;
	private TextField distanceField;

	public TripPlannerListener(Graph g, TextField room1, TextField distanceField) {
		this.g = g;
		this.start = room1;
		this.distanceField = distanceField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Integer distance = null;
		try {
			distance = Integer.parseInt(distanceField.getText());
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "distance is invalid");
			return;
		}
		if (distance != null) {
			Node n = g.nodes.get(start.getText());
			if (n == null) {
				JOptionPane.showMessageDialog(null, "could not find room");
				return;
			}
			Hashtable<Node, Integer> dijkstraResult = n.dijkstra(g);
			ArrayList<String> results = new ArrayList<String>();
			Node closestNode = null;
			for (Node node : dijkstraResult.keySet()) {
				if (dijkstraResult.get(node).equals(distance)) {
					results.add(node.name);
				}
				if (closestNode == null || Math.abs(dijkstraResult.get(closestNode) - distance) > Math
						.abs(dijkstraResult.get(node) - distance)) {
					closestNode = node;
				}
			}
			if (results.size() > 0) {
				String string = "Here are some rooms to check out";
				for (String s : results) {
					string += "\n- " + s;
				}
				JOptionPane.showMessageDialog(null, string, "Recommended Paths", JOptionPane.PLAIN_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null,
						"could not find any rooms that distance away, but here is one "
								+ dijkstraResult.get(closestNode) + " away\n- " + closestNode.name,
						"Recommended Paths", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
