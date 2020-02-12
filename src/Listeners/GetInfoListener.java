package Listeners;


import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Graph.Graph;

public class GetInfoListener implements ActionListener {

	private Graph g;
	private TextField room;
	public GetInfoListener(Graph g, TextField room) {
		this.g = g;
		this.room = room;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedImage image = g.nodes.get(room.getText()).getImage();
		JLabel picLabel = new JLabel(new ImageIcon(image));
		JOptionPane.showMessageDialog(null, picLabel, "About", JOptionPane.PLAIN_MESSAGE, null);
	}

}
