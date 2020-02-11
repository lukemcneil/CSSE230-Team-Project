import java.awt.*;

public class NodeComponent extends Component {
    public Node target;
    public int x;
    public int y;

    public NodeComponent(Node node) {
        this.target = node;
        this.x = target.x;
        this.y = target.y;
    }

    public void setX(int val) {
        this.x = val;
    }

    public void setY(int val) {
        this.y = val;
    }

    public void drawOn(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g.setColor(Color.black);
        g2.drawOval(x, y, 10, 10);
        g2.drawString(target.name, x, y + 25);
    }
}
