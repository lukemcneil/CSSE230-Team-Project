import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import buttonListeners.FindPathListener;
import buttonListeners.FindRoomListener;
import buttonListeners.GetInfoListener;

public class ButtonPanel extends JPanel {
	
	private JButton findPath, findRoom, getInfo;
	private JTextField startingRoom, destination, roomNumber;
	private JLabel information;
	
	public ButtonPanel() {
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
		
		findPath.addActionListener(new FindPathListener(startingRoom.getText(), destination.getText()));
		findRoom.addActionListener(new FindRoomListener(roomNumber.getText()));
		getInfo.addActionListener(new GetInfoListener(roomNumber.getText()));
	}
}
