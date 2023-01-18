package UI01.Commands.Concrete.StockCartCrudCommands;

import UI01.Commands.Abstract.ICommand;
import UI01.Controller.GeneralStockCartOperations;

public class AddStockCartCommand implements ICommand{
	GeneralStockCartOperations generalStockCartOperations;
	
	public AddStockCartCommand(GeneralStockCartOperations generalStockCartOperations) {
		this.generalStockCartOperations = generalStockCartOperations;
	}
	@Override
	public void execute() {
		generalStockCartOperations.addStockCart();		
	}
	
}
