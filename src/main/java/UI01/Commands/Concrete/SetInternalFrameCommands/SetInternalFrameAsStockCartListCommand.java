package UI01.Commands.Concrete.SetInternalFrameCommands;

import UI01.Controller.GeneralMainFrameOperations;
import UI01.View.StockCartListFrame;

public class SetInternalFrameAsStockCartListCommand extends SetCurrentInternalFrameCommand{
	StockCartListFrame stockCartListFrame;
	public SetInternalFrameAsStockCartListCommand(GeneralMainFrameOperations generalMainPageOperations,
			StockCartListFrame stockCartListFrame) {
		super(generalMainPageOperations);
		this.stockCartListFrame = stockCartListFrame;
	}
	
	@Override
	public void execute() {
		generalMainPageOperations.getGeneralStockCartListOperations().getAllStockCartsToTable();
		generalMainPageOperations.setCurrentInternalFrame(stockCartListFrame);	
	}

}
