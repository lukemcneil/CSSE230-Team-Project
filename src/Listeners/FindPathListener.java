package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Graph;

public class FindPathListener implements ActionListener {

	private Graph g;
	
	public FindPathListener(Graph g, String room1, String room2) {
		g.getNodes().get(room1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
