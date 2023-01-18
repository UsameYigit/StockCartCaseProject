package UI01.Commands.Concrete.SetInternalFrameCommands;

import javax.swing.JInternalFrame;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralMainFrameOperations;

public abstract class SetCurrentInternalFrameCommand implements ICommand{
	GeneralMainFrameOperations generalMainPageOperations;
	JInternalFrame internalFrame;
	
	public SetCurrentInternalFrameCommand(GeneralMainFrameOperations generalMainPageOperations) {
		this.generalMainPageOperations = generalMainPageOperations;
	}
	
}
