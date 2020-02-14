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
	public void actionPerformed(ActionEvent e) throws NullPointerException{
		if (!g.getNodes().containsKey(room.getText())) {
			JOptionPane.showMessageDialog(null, "could not find the specified room");
			return;
		}
		BufferedImage image=null;
		JLabel picLabel=null;
		try {
			File pic=new File(g.nodes.get(room.getText()).getImage());
			image = ImageIO.read(pic);
			picLabel = new JLabel(new ImageIcon(image));
		} catch (NullPointerException | IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("could not find named file");
			picLabel=new JLabel("Schedule could not be found.");
			e1.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, picLabel, g.nodes.get(room.getText()).name, JOptionPane.PLAIN_MESSAGE, null);
	}

}
