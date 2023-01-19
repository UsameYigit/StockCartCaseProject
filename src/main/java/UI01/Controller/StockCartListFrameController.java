package UI01.Controller;

import Business.Abstract.IStockCartService;
import UI01.Commands.GeneralAction;
import UI01.Commands.GeneralMouseAction;
import UI01.Commands.Concrete.StockCartListCommands.StockCartListExportToExcellCommand;
import UI01.Commands.Concrete.StockCartListCommands.StockCartListSetSelectedItemCommand;
import UI01.View.StockCartListFrame;

public class StockCartListFrameController {
	StockCartListFrame stockCartListFrame;
	IStockCartService stockCartService;
	GeneralStockCartListOperations generalStockCartListOperations;
	
	public StockCartListFrameController(StockCartListFrame stockCartListFrame, IStockCartService stockCartService, GeneralStockCartListOperations generalStockCartListOperations){
		this.stockCartListFrame = stockCartListFrame;
		this.stockCartService = stockCartService;
		
		this.generalStockCartListOperations = generalStockCartListOperations;
	}
	
	public void launch(){
		try {
			setMouseListeners();
			setMenuItemListeners();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setMenuItemListeners() {
		stockCartListFrame.getMiExcell().addActionListener(new GeneralAction(new StockCartListExportToExcellCommand(generalStockCartListOperations)));
	}
	
	private void setMouseListeners() { 
		stockCartListFrame.getTblStockCartList().addMouseListener(new GeneralMouseAction(new StockCartListSetSelectedItemCommand(generalStockCartListOperations)));
	}
	
	
}
