package UI01.Commands.Concrete.StockCartCrudCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralStockCartOperations;

public class DeleteStockCartCommand implements ICommand{
	GeneralStockCartOperations generalStockCartOperations;
	
	public DeleteStockCartCommand(GeneralStockCartOperations generalStockCartOperations) {
		this.generalStockCartOperations = generalStockCartOperations;
	}
	@Override
	public void execute() {
		generalStockCartOperations.deleteStockCart();		
	}

}
