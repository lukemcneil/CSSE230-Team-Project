package Visuals;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class EdgeComponent {
	public int cost;
	public int x1;
	public int x2;
	public int y1;
	public int y2;
	public boolean highlighted;
	private int floor;
	
	public EdgeComponent(int cost, int x1, int x2, int y1, int y2, boolean highlighted, int floor) {
		this.cost=cost;
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.highlighted=highlighted;
		this.floor = floor;
	}
	
	public int getFloor() {
		return this.floor;
	}
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		Stroke normal=g2.getStroke();
		if(highlighted) {
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.red);
		}else {
			g2.setColor(Color.black);
		}
		g2.drawLine(x1+5, y1+5, x2+5, y2+5);
		g2.setStroke(normal);
		g2.setColor(Color.BLACK);
		if(highlighted) {
			g2.drawString(String.valueOf(cost), (x1+x2)/2, (y1+y2)/2+10);
		}
	}
}
