import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        GraphMaker gm = new GraphMaker();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setFocusable(true);
        JComponent mainComponent = new MainComponent(gm.getGraph());
        JPanel buttonPanel = new ButtonPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        frame.add(mainComponent);
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.repaint();
    }
}

