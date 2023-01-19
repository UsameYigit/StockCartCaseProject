package UI01.Commands;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import UI01.Commands.Abstract.IMouseCommand;

public class GeneralMouseAction extends MouseAdapter{
	IMouseCommand mouseCommand;
	public GeneralMouseAction(IMouseCommand mouseCommand) {
		this.mouseCommand = mouseCommand;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (SwingUtilities.isRightMouseButton(e)) {
			mouseCommand.executeRightClick(e);
		}else{
			mouseCommand.execute();
		}
		
	}
}
