package UI01.Commands.Concrete.StockCartCrudCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralStockCartOperations;

public class SearchStockCartCommand implements ICommand{
	GeneralStockCartOperations generalStockCartOperations;
	
	public SearchStockCartCommand(GeneralStockCartOperations generalStockCartOperations) {
		this.generalStockCartOperations = generalStockCartOperations;
	}
	
	@Override
	public void execute() {
		generalStockCartOperations.searchStockCart();
	}

}
