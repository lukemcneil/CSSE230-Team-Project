package Visuals;

import Graph.Graph;
import Listeners.*;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

	private JButton findPath, findRoom, getInfo, zoomIn, zoomOut;
	private TextField startingRoom, destination, roomNumber;

	private Graph g;

	private FindPathListener fpl;

	public ButtonPanel(Graph g, JFrame frame) {
		this.g = g;
		findPath = new JButton("Find Path");
		findRoom = new JButton("Find Room");
		getInfo = new JButton("Get Info");
		zoomIn = new JButton("+");
		zoomOut = new JButton("-");

		startingRoom = new TextField("");
		destination = new TextField("");
		this.add(new JLabel("start"));
		this.add(startingRoom);
		this.add(new JLabel("destination"));
		this.add(destination);
		roomNumber = new TextField("");
		this.add(findPath);
		this.add(roomNumber);
		this.add(findRoom);
		this.add(getInfo);
		this.add(zoomIn);
		this.add(zoomOut);

		fpl = new FindPathListener(g, startingRoom, destination);

		findPath.addActionListener(fpl);
		findRoom.addActionListener(new FindRoomListener(g, roomNumber));
		getInfo.addActionListener(new GetInfoListener(g, roomNumber));
		zoomIn.addActionListener(new ZoomInListener(g));
		zoomOut.addActionListener(new ZoomOutListener(g));
	}

	public void setStartingRoom(String set) {
		startingRoom.setText(set);
	}

	public void setDestination(String set) {
		destination.setText(set);
	}

	public void setRoomNumber(String set) {
		roomNumber.setText(set);
	}

	public int doStuff() {
		fpl.doStuff();
		return fpl.getCost();
	}
	
	public void clearPanels() {
		startingRoom.setText("");
		destination.setText("");
	}
}
