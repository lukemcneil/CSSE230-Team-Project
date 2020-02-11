import java.awt.Graphics;

import javax.swing.JComponent;

public class MainComponent extends JComponent {
	
	private Graph graph;
	
	public MainComponent(Graph g) {
		this.graph = g;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		for(String i : graph.getNodes().keySet()) {
			g.drawOval(graph.getNodes().get(i).getVisualX(), graph.getNodes().get(i).getVisualY(), 30, 30);
		}
	}
}
