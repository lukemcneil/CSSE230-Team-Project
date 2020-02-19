package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Edge;
import Graph.Graph;

public class ModeListener implements ActionListener {
	private Graph g;
	private FindPathListener f;

	public ModeListener(Graph g, FindPathListener f) {
		this.g = g;
		this.f = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.switchMode();
		f.doStuff();
	}

}
