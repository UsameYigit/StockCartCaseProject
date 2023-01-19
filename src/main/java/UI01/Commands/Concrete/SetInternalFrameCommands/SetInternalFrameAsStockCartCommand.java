package UI01.Commands.Concrete.SetInternalFrameCommands;

import UI01.Controller.GeneralMainFrameOperations;
import UI01.View.StockCartFrame;

public class SetInternalFrameAsStockCartCommand extends SetCurrentInternalFrameCommand{
	StockCartFrame stockCartFrame;
	public SetInternalFrameAsStockCartCommand(GeneralMainFrameOperations generalMainPageOperations, StockCartFrame stockCartFrame) {
		super(generalMainPageOperations);
		this.stockCartFrame = stockCartFrame;
	}
	
	@Override
	public void execute() {
		generalMainPageOperations.getGeneralStockCartOperations().setComboBoxes();
		generalMainPageOperations.getGeneralStockCartOperations().resetViewFields();
		generalMainPageOperations.setCurrentInternalFrame(stockCartFrame);
	}

}
