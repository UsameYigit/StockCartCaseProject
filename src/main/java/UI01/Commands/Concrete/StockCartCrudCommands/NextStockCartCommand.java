package UI01.Commands.Concrete.StockCartCrudCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralStockCartOperations;

public class NextStockCartCommand implements ICommand{
	
	GeneralStockCartOperations generalStockCartOperations;
	
	public NextStockCartCommand(GeneralStockCartOperations generalStockCartOperations) {
		this.generalStockCartOperations = generalStockCartOperations;
	}
	
	@Override
	public void execute() {
		generalStockCartOperations.getNextItem();
	}
}
