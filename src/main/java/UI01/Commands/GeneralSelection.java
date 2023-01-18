package UI01.Commands;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import UI01.Commands.Abstract.ICommand;

public class GeneralSelection implements ListSelectionListener {
	ICommand command;
	public GeneralSelection(ICommand command) {
		this.command = command;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!e.getValueIsAdjusting()) {
			command.execute();
		}
	}
}
