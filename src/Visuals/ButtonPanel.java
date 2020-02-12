package Visuals;

import Graph.Graph;
import Listeners.FindPathListener;
import Listeners.FindRoomListener;
import Listeners.GetInfoListener;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

	private JButton findPath, findRoom, getInfo;
	private TextField startingRoom, destination, roomNumber;

	private Graph g;

	public ButtonPanel(Graph g) {
		this.g = g;
		findPath = new JButton("Find Path");
		findRoom = new JButton("Find Room");
		getInfo = new JButton("Get Info");

		startingRoom = new TextField("Starting Room");
		destination = new TextField("Destination");
		this.add(new JLabel("start"));
		this.add(startingRoom);
		this.add(new JLabel("destination"));
		this.add(destination);
		roomNumber = new TextField("Room #");
		this.add(findPath);
		this.add(roomNumber);
		this.add(findRoom);
		this.add(getInfo);

		findPath.addActionListener(new FindPathListener(g, startingRoom, destination));
		findRoom.addActionListener(new FindRoomListener(g, roomNumber));
		getInfo.addActionListener(new GetInfoListener(g, roomNumber));
	}
}
