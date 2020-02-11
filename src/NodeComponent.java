import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class NodeComponent extends Component{
	public Node target;
	public int x;
	public int y;
	
	public NodeComponent(Node node, int x, int y) {
		this.target=node;
		this.x=x;
		this.y=y;
	}
	
	public void setX(int val) {
		this.x=val;
	}
	
	public void setY(int val) {
		this.y=val;
	}
	
	public void drawOn(Graphics g) {
		Graphics2D g2=(Graphics2D) g;
		g.setColor(Color.black);
		g2.drawOval(x, y, 10, 10);
		g2.drawString(target.name, x, y+15);
	}
}
