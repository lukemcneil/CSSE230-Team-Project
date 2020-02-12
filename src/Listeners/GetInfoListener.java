package Listeners;


import Graph.Graph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GetInfoListener implements ActionListener {

	private Graph g;
	private TextField room;

	public GetInfoListener(Graph g, TextField room) {
		this.g = g;
		this.room = room;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!g.getNodes().containsKey(room.getText())) {
			JOptionPane.showMessageDialog(null, "could not find the specified room");
			return;
		}
		BufferedImage image = g.nodes.get(room.getText()).getImage();
		JLabel picLabel = new JLabel(new ImageIcon(image));
		JOptionPane.showMessageDialog(null, picLabel, "About", JOptionPane.PLAIN_MESSAGE, null);
	}

}
