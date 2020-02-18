package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Graph.Graph;

public class ModeListener implements ActionListener{
	private Graph g;
	
	public ModeListener(Graph g) {
		this.g = g;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		g.switchMode();
		System.out.println(g.getMode());
	}

}
