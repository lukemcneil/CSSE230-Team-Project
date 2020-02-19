package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Graph;
import Visuals.ButtonPanel;

public class ModeListener implements ActionListener {
	private Graph g;
	private ButtonPanel bp;

	public ModeListener(Graph g, ButtonPanel bp) {
		this.g = g;
		this.bp = bp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		g.switchMode();
		bp.doStuff();
	}

}
