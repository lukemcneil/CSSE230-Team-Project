package Listeners;


import Graph.Edge;
import Graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindRoomListener implements ActionListener {

	private Graph g;
	private TextField field;
	private JLabel floor;

	public FindRoomListener(Graph g, TextField field,JLabel floor) {
		this.g = g;
		this.field = field;
		this.floor = floor;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!g.getNodes().containsKey(field.getText())) {
			JOptionPane.showMessageDialog(null, "could not find the specified room");
			return;
		}
		String room = field.getText();
		if (g.getNodes().get(room) == null) {
			return;
		}
		for (String i : g.getNodes().keySet()) {
			g.getNodes().get(i).setHighlighted(false);
			for (Edge c : g.nodes.get(i).edges) {
				c.highlighted = false;
			}
		}
		int floor = g.getNodes().get(room).floor;
		g.getNodes().get(room).setHighlighted(true);
		g.setFloor(floor);
		this.floor.setText("Floor: "+ floor);
		System.out.println("Found");
	}

}
