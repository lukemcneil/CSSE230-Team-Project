package Listeners;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		g.getNodes().get(room).setHighlighted(true);
		System.out.println("Found");
	}

}
