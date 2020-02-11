package Visuals;
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
	private JTextField startingRoom, destination, roomNumber;
	private JLabel information;
	
	private Graph g;
	
	public ButtonPanel(Graph g) {
		this.g = g;
		findPath = new JButton("Find Path");
		findRoom = new JButton("Find Room");
		getInfo = new JButton("Get Info");
		
		startingRoom = new JTextField("Starting Room");
		destination = new JTextField("Destination");
		this.add(startingRoom);
		this.add(destination);
		roomNumber = new JTextField("Room #");
		this.add(findPath);
		this.add(roomNumber);
		this.add(findRoom);
		this.add(getInfo);
		
		findPath.addActionListener(new FindPathListener(g, startingRoom.getText(), destination.getText()));
		findRoom.addActionListener(new FindRoomListener(g, roomNumber.getText()));
		getInfo.addActionListener(new GetInfoListener(g, roomNumber.getText()));
	}
}
