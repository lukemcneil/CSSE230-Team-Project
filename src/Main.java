import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GraphMaker gm = new GraphMaker();
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setFocusable(true);
        JComponent mainComponent = new MainComponent(gm.getGraph());
        frame.add(mainComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.repaint();
    }
}

