package UI01.Commands.Abstract;

import java.awt.event.MouseEvent;

public interface IMouseCommand extends ICommand{
	public void executeRightClick(MouseEvent e);
}
