package UI01.Controller;

import Business.Abstract.IStockCartService;
import UI01.Commands.GeneralAction;
import UI01.Commands.GeneralMouseAction;
import UI01.Commands.Concrete.StockCartListCommands.StockCartListExportToExcellCommand;
import UI01.Commands.Concrete.StockCartListCommands.StockCartListSetSelectedItemCommand;
import UI01.Commands.Concrete.StockCartListCommands.StockCartToEditCommand;
import UI01.View.StockCartFrame;
import UI01.View.StockCartListFrame;

public class StockCartListFrameController {
	StockCartListFrame stockCartListFrame;
	IStockCartService stockCartService;
	GeneralStockCartListOperations generalStockCartListOperations;
	GeneralMainFrameOperations generalMainPageOperations;
	StockCartFrame stockCartFrame;
	
	public StockCartListFrameController(StockCartListFrame stockCartListFrame, IStockCartService stockCartService, GeneralStockCartListOperations generalStockCartListOperations, GeneralMainFrameOperations generalMainPageOperations, StockCartFrame stockCartFrame){
		this.stockCartListFrame = stockCartListFrame;
		this.stockCartService = stockCartService;
		
		this.generalStockCartListOperations = generalStockCartListOperations;
		
		this.generalMainPageOperations = generalMainPageOperations;
		this.stockCartFrame = stockCartFrame;
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
		stockCartListFrame.getMiStockCart().addActionListener(new GeneralAction(new StockCartToEditCommand(generalStockCartListOperations, generalMainPageOperations, stockCartFrame)));
	}
	
	private void setMouseListeners() { 
		stockCartListFrame.getTblStockCartList().addMouseListener(new GeneralMouseAction(new StockCartListSetSelectedItemCommand(generalStockCartListOperations)));
	}
	
	
}
