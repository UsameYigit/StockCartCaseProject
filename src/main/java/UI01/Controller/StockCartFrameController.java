package UI01.Controller;

import Business.Abstract.IStockCartService;
import UI01.Commands.GeneralAction;
import UI01.Commands.Concrete.StockCartCrudCommands.AddStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.CopyStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.DeleteStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.FirstStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.LastStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.NextStockCartCommand;
import UI01.Commands.Concrete.StockCartCrudCommands.PreviousStockCartCommand;
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
			setButtonListeners();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setButtonListeners() { 
		stockCartFrame.getBtnSave().addActionListener(new GeneralAction(new AddStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnDelete().addActionListener(new GeneralAction(new DeleteStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnCopy().addActionListener(new GeneralAction(new CopyStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnFirst().addActionListener(new GeneralAction(new FirstStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnLast().addActionListener(new GeneralAction(new LastStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnNext().addActionListener(new GeneralAction(new NextStockCartCommand(generalStockCartOperations)));
		stockCartFrame.getBtnPrevious().addActionListener(new GeneralAction(new PreviousStockCartCommand(generalStockCartOperations)));
	}	
}
