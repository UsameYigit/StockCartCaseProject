package UI01.Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import UI01.Commands.Abstract.ICommand;

public class GeneralAction implements ActionListener {
	ICommand command;
	public GeneralAction(ICommand command) {
		this.command = command;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		command.execute();
	}
}
