import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        GraphMaker gm = new GraphMaker();
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setFocusable(true);
        JComponent mainComponent = new MainComponent(gm.getGraph());
        JPanel mainPanel = new JPanel();
        mainPanel.add(mainComponent);
        JPanel buttonPanel = new ButtonPanel();
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.EAST);
//        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.repaint();
    }
}

