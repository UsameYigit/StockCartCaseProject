package UI01.Commands.Concrete.StockCartListCommands;

import java.awt.event.MouseEvent;

import UI01.Commands.Abstract.IMouseCommand;
import UI01.Controller.GeneralStockCartListOperations;

public class StockCartListSetSelectedItemCommand implements IMouseCommand{
	GeneralStockCartListOperations generalStockCartListOperations;
	
	public StockCartListSetSelectedItemCommand(GeneralStockCartListOperations generalStockCartListOperations) {
		this.generalStockCartListOperations = generalStockCartListOperations;
	}
	
	@Override
	public void execute() {
				
	}

	@Override
	public void executeRightClick(MouseEvent e) {
		generalStockCartListOperations.openPopUpMenu(e);		
	}
}
