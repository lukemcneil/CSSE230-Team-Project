import java.awt.Graphics;
import java.awt.Graphics2D;

public class EdgeComponent {
	public int cost;
	public int x1;
	public int x2;
	public int y1;
	public int y2;
	
	public EdgeComponent(int cost, int x1, int x2, int y1, int y2) {
		this.cost=cost;
		this.x1=x1;
		this.x2=x2;
		this.y1=y1;
		this.y2=y2;
	}
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		g2.drawLine(x1, y1, x2, y2);
		g2.drawString(String.valueOf(cost), (x1+x2)/2, (y1+y2)/2+10);
	}
}
