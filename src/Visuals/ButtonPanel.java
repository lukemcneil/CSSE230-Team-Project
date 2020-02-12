package Visuals;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Graph.Graph;
import Listeners.FindPathListener;
import Listeners.FindRoomListener;
import Listeners.GetInfoListener;

public class ButtonPanel extends JPanel {
	
	private JButton findPath, findRoom, getInfo;
	private TextField startingRoom, destination, roomNumber;
	private JLabel information;
	
	private Graph g;
	
	public ButtonPanel(Graph g) {
		this.g = g;
		findPath = new JButton("Find Path");
		findRoom = new JButton("Find Room");
		getInfo = new JButton("Get Info");
		
		startingRoom = new TextField("Starting Room");
		destination = new TextField("Destination");
		this.add(startingRoom);
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
