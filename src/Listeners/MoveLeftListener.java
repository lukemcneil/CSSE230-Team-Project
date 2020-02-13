package Listeners;


import Graph.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveLeftListener implements ActionListener {

	private Graph g;

	public MoveLeftListener(Graph g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.moveLeft(10);
	}

}
