package Listeners;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Edge;
import Graph.Graph;

public class FindRoomListener implements ActionListener {

	private Graph g;
	private TextField field;
	
	public FindRoomListener(Graph g, TextField field) {
		this.g = g;
		this.field = field;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String room = field.getText();
		System.out.println(room);
		if(g.getNodes().get(room) == null) {
			return;
		}
		for(String i : g.getNodes().keySet()) {
			g.getNodes().get(i).setHighlighted(false);
			for(Edge c : g.nodes.get(i).edges) {
				c.highlighted=false;
			}
		}
		g.getNodes().get(room).setHighlighted(true);
		System.out.println("Found");
	}

}
