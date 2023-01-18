package UI01.Controller;

import Business.Abstract.IStockCartService;
import UI01.Commands.GeneralAction;
import UI01.Commands.Concrete.StockCartCrudCommands.AddStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.CopyStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.DeleteStockCartCommand;
import UI01.View.StockCartFrame;


public class StockCartFrameController {
	StockCartFrame stockCartFrame;
	IStockCartService stockCartService;
	GeneralStockCartOperations generalStockCartOperations;
	
	public StockCartFrameController(StockCartFrame stockCartFrame, IStockCartService stockCartService, GeneralStockCartOperations generalStockCartOperations){
		this.stockCartFrame = stockCartFrame;
		this.stockCartService = stockCartService;
		
		this.generalStockCartOperations = generalStockCartOperations;
	}
	
	public void launch(){
		try {
			generalStockCartOperations.refreshLists();
			setButtonListeners();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setButtonListeners() { 
		stockCartFrame.getBtnSave().addActionListener(new GeneralAction(new AddStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnDelete().addActionListener(new GeneralAction(new DeleteStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnCopy().addActionListener(new GeneralAction(new CopyStockCartCommand(generalStockCartOperations)));
	}	
}
