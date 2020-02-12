package Visuals;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class EdgeComponent {
	public int cost;
	public int x1;
	public int x2;
	public int y1;
	public int y2;
	public boolean highlighted;
	
	public EdgeComponent(int cost, int x1, int x2, int y1, int y2, boolean highlighted) {
		this.cost=cost;
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
		this.highlighted=highlighted;
	}
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		if(highlighted) {
			g2.setColor(Color.red);
		}else {
			g2.setColor(Color.black);
		}
		g2.drawLine(x1+5, y1+5, x2+5, y2+5);
		//g2.drawString(String.valueOf(cost), (x1+x2)/2, (y1+y2)/2+10);
	}
}
