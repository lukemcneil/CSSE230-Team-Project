package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Visuals.CaptchaPanel;

public class ClickListener implements ActionListener {

	private CaptchaPanel cp;
	
	public ClickListener(CaptchaPanel cp) {
		this.cp = cp;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		cp.setClickedTrue();
	}
	
}
