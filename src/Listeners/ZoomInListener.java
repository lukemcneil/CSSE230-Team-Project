package Listeners;


import Graph.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoomInListener implements ActionListener {

	private Graph g;

	public ZoomInListener(Graph g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.zoomIn(null);
	}

}
