package Listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Graph;

public class FindRoomListener implements ActionListener {

	private Graph g;
	private String room;
	
	public FindRoomListener(Graph g, String room) {
		this.g = g;
		this.room = room;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(room);
		if(g.getNodes().get(room) == null) {
			return;
		}
		g.getNodes().get(room).setHighlighted(true);
		System.out.println("Found");
	}

}
