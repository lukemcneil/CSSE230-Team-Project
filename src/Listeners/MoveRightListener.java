package Listeners;


import Graph.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveRightListener implements ActionListener {

	private Graph g;

	public MoveRightListener(Graph g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.moveRight();
	}

}
