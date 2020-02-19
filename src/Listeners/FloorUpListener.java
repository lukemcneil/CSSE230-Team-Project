package Listeners;

import Graph.Graph;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FloorUpListener implements ActionListener {
	private Graph graph;
	private JLabel count;

	public FloorUpListener(Graph g, JLabel counter) {
		this.graph = g;
		this.count = counter;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (graph.getFloor() <= 1) {
			this.graph.setFloor(graph.getFloor() + 1);
			this.count.setText("" + graph.getFloor());
		}
	}

}
