package Listeners;


import Graph.Graph;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class PanListener implements MouseMotionListener, MouseListener {
	private Point previous = new Point(0, 0);

	private Graph g;

	public PanListener(Graph g) {
		this.g = g;
	}


	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		previous = mouseEvent.getPoint();
	}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		if (mouseEvent.getY() < previous.y) {
			g.moveUp(previous.y - mouseEvent.getY());
		} else if (mouseEvent.getY() > previous.y) {
			g.moveDown(mouseEvent.getY() - previous.y);
		}
		if (mouseEvent.getX() < previous.x) {
			g.moveLeft(previous.x - mouseEvent.getX());
		} else if (mouseEvent.getX() > previous.x) {
			g.moveRight(mouseEvent.getX() - previous.x);
		}
		previous = mouseEvent.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {

	}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {

	}
}
