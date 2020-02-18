package Listeners;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Visuals.CaptchaPanel;

public class EnterListener implements ActionListener {

	private TextField password;
	private TextField team;
	private CaptchaPanel cp;
	
	public EnterListener(TextField password, TextField team, CaptchaPanel cp) {
		this.password = password;
		this.team = team;
		this.cp = cp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(password.getText().length() == 10 && team.getText().equals("D20") && cp.getClicked()) {
			cp.startProgram();
		}
	}

}
