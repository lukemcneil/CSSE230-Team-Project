package Listeners;


import Graph.Graph;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ScrollListener implements MouseWheelListener {

	private Graph g;

	public ScrollListener(Graph g) {
		this.g = g;
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent) {
		if (mouseWheelEvent.getPreciseWheelRotation() < 0) {
			g.zoomIn();
		} else {
			g.zoomOut();
		}
	}
}
