package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Graph.Graph;

public class FloorDownListener implements ActionListener {
	
	private Graph graph;
	private JLabel count;
	
	public FloorDownListener(Graph g,JLabel counter){
		this.graph = g;
		this.count = counter;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.graph.setFloor(graph.getFloor()-1);
		this.count.setText(""+graph.getFloor());
	}

}
