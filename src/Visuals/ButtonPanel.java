package Visuals;

import Graph.Graph;
import Listeners.*;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

	private JButton findPath, findRoom, getInfo, zoomIn, zoomOut, moveLeft, moveRight, moveUp, moveDown;
	private TextField startingRoom, destination, roomNumber;

	private Graph g;

	public ButtonPanel(Graph g) {
		this.g = g;
		findPath = new JButton("Find Path");
		findRoom = new JButton("Find Room");
		getInfo = new JButton("Get Info");
		zoomIn = new JButton("+");
		zoomOut = new JButton("-");
		moveRight = new JButton("right");
		moveLeft = new JButton("left");
		moveUp = new JButton("up");
		moveDown = new JButton("down");

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
		this.add(moveLeft);
		this.add(moveRight);
		this.add(moveUp);
		this.add(moveDown);

		findPath.addActionListener(new FindPathListener(g, startingRoom, destination));
		findRoom.addActionListener(new FindRoomListener(g, roomNumber));
		getInfo.addActionListener(new GetInfoListener(g, roomNumber));
		zoomIn.addActionListener(new ZoomInListener(g));
		zoomOut.addActionListener(new ZoomOutListener(g));
		moveUp.addActionListener(new MoveUpListener(g));
		moveDown.addActionListener(new MoveDownListener(g));
		moveRight.addActionListener(new MoveRightListener(g));
		moveLeft.addActionListener(new MoveLeftListener(g));
	}
}
