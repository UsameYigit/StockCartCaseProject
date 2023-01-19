package UI01.Commands.Concrete.StockCartListCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralStockCartListOperations;

public class StockCartListExportToExcellCommand implements ICommand{
	GeneralStockCartListOperations generalStockCartListOperations;
	
	public StockCartListExportToExcellCommand(GeneralStockCartListOperations generalStockCartListOperations) {
		this.generalStockCartListOperations = generalStockCartListOperations;
	}
	
	@Override
	public void execute() {
		generalStockCartListOperations.exportStockCartListToExcel();
	}
	
}
