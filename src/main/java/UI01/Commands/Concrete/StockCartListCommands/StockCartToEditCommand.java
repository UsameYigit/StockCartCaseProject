package UI01.Commands.Concrete.StockCartListCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralMainFrameOperations;
import UI01.Controller.GeneralStockCartListOperations;
import UI01.View.StockCartFrame;

public class StockCartToEditCommand implements ICommand {
	GeneralStockCartListOperations generalStockCartListOperations;
	GeneralMainFrameOperations generalMainPageOperations;
	StockCartFrame stockCartFrame;
	
	public StockCartToEditCommand(GeneralStockCartListOperations generalStockCartListOperations, GeneralMainFrameOperations generalMainPageOperations, StockCartFrame stockCartFrame) {
		this.generalStockCartListOperations = generalStockCartListOperations;
		this.generalMainPageOperations = generalMainPageOperations;
		this.stockCartFrame = stockCartFrame;
	}
	
	@Override
	public void execute() {
		generalStockCartListOperations.setStockCartFrameToSelected(stockCartFrame);
		generalMainPageOperations.setCurrentInternalFrame(stockCartFrame);
	}
	
}
