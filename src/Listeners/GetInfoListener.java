package Listeners;

import Graph.Graph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetInfoListener implements ActionListener {

	private Graph g;
	private TextField room;

	public GetInfoListener(Graph g, TextField room) {
		this.g = g;
		this.room = room;
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NullPointerException {
		if (!g.getNodes().containsKey(room.getText())) {
			JOptionPane.showMessageDialog(null, "could not find the specified room");
			return;
		}
		if (room.getText().equals("F218")) {
			BufferedImage image1 = null;
			BufferedImage image2 = null;
			JLabel fail = null;
			JLabel success = null;
			try {
				File pic1 = new File("RoomInfo" + File.separator + "Dank2.png");
				File pic2 = new File("RoomInfo" + File.separator + "Dank.png");
				image1 = ImageIO.read(pic1);
				image2 = ImageIO.read(pic2);
				fail = new JLabel(new ImageIcon(image1));
				success = new JLabel(new ImageIcon(image2));
			} catch (NullPointerException | IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("could not find named file");
				fail = new JLabel("uh oh");
			}
			int reply = JOptionPane.showConfirmDialog(fail, "Are all AVLTrees RedBlackTrees?", "POP QUIZ",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, success, "You did it!", JOptionPane.PLAIN_MESSAGE,
						null);
			} else {
				JOptionPane.showMessageDialog(null, fail, "FAILURE", JOptionPane.PLAIN_MESSAGE,
						null);
				System.exit(0);
			}
		} else {
			BufferedImage image = null;
			JLabel picLabel = null;
			try {
				File pic = new File(g.nodes.get(room.getText()).getImage());
				image = ImageIO.read(pic);
				picLabel = new JLabel(new ImageIcon(image));
			} catch (NullPointerException | IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("could not find named file");
				picLabel = new JLabel("Schedule could not be found.");
			}
			JOptionPane.showMessageDialog(null, picLabel, g.nodes.get(room.getText()).name, JOptionPane.PLAIN_MESSAGE,
					null);
		}
	}

}
