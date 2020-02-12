package Listeners;


import Graph.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveDownListener implements ActionListener {

	private Graph g;

	public MoveDownListener(Graph g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.moveDown();
	}

}
