package UI01.Commands.Concrete.StockCartCrudCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralStockCartOperations;

public class CopyStockCartCommand implements ICommand{

	GeneralStockCartOperations generalStockCartOperations;
	
	public CopyStockCartCommand(GeneralStockCartOperations generalStockCartOperations) {
		this.generalStockCartOperations = generalStockCartOperations;
	}
	
	@Override
	public void execute() {
		generalStockCartOperations.copySelectedItem();
	}

}
