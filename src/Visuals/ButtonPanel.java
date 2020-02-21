package Visuals;

import Graph.Graph;
import Listeners.*;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

	private JButton findPath, findRoom, getInfo, zoomIn, zoomOut, floorUp, floorDown, tripPlanner;
	private TextField startingRoom, destination, roomNumber, distance;
	private JLabel floorLabel;
	private JToggleButton elevatorToggle;

	private Graph g;

	private int cost;

	private FindPathListener fpl;

	public ButtonPanel(Graph g, JFrame frame) {
		cost = 0;
		this.g = g;
		findPath = new JButton("Find Path");
		findRoom = new JButton("Find Room");
		getInfo = new JButton("Get Info");
		zoomIn = new JButton("+");
		zoomOut = new JButton("-");
		floorUp = new JButton("+ Floor");
		floorDown = new JButton("- Floor");
		elevatorToggle = new JToggleButton("Elevators Only");

		floorLabel = new JLabel("Floor: " + g.getFloor());
		tripPlanner = new JButton("Trip Planner"); 

		startingRoom = new TextField("");
		destination = new TextField("");
		roomNumber = new TextField("");
		distance = new TextField("");
		this.add(new JLabel("Start #"));
		this.add(startingRoom);
		this.add(new JLabel("Destination #"));
		this.add(destination);
		this.add(findPath);
		this.add(new JLabel("\n"));
		this.add(new JLabel("Room Number"));
		this.add(roomNumber);
		this.add(findRoom);
		this.add(getInfo);
		this.add(new JLabel("\n"));
		this.add(new JLabel("Zoom"));
		this.add(zoomIn);
		this.add(zoomOut);
		this.add(new JLabel("\n"));
		this.add(floorLabel);
		this.add(floorUp);
		this.add(floorDown);
		this.add(new JLabel("\n"));
		this.add(new JLabel("Distance"));
		this.add(distance);
		this.add(tripPlanner);
		this.add(new JLabel("\n"));
		this.add(elevatorToggle);

		fpl = new FindPathListener(g, startingRoom, destination);

		findPath.addActionListener(fpl);
		findRoom.addActionListener(new FindRoomListener(g, roomNumber,floorLabel));
		getInfo.addActionListener(new GetInfoListener(g, roomNumber));
		zoomIn.addActionListener(new ZoomInListener(g));
		zoomOut.addActionListener(new ZoomOutListener(g));
		tripPlanner.addActionListener(new TripPlannerListener(g, roomNumber, distance));
		floorUp.addActionListener(new FloorUpListener(g, floorLabel));
		floorDown.addActionListener(new FloorDownListener(g, floorLabel));
		elevatorToggle.addActionListener(new ModeListener(g, this));
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
		if (startingRoom.getText().isEmpty() || destination.getText().isEmpty()) {
			return 0;
		}
		fpl.doStuff();
		cost = fpl.getCost();
		return fpl.getCost();
	}

	public int getCost() {
		return cost;
	}

	public void clearPanels() {
		startingRoom.setText("");
		destination.setText("");
	}
}
