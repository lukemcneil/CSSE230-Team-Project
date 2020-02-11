import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
		roomNumber = new JTextField("Room #");
		this.add(findPath);
		this.add(findRoom);
		this.add(getInfo);
		this.add(startingRoom);
		this.add(destination);
		this.add(roomNumber);
	}
}
