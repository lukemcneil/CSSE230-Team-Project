package Listeners;


import Graph.Graph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZoomOutListener implements ActionListener {

	private Graph g;

	public ZoomOutListener(Graph g) {
		this.g = g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.zoomOut(null);
	}

}
