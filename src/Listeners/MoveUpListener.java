package Listeners;


import Graph.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveUpListener implements ActionListener {

	private Graph g;

	public MoveUpListener(Graph g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.moveUp();
	}

}
