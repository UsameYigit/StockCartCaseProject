package UI01.Controller;

import UI01.Commands.GeneralAction;
import UI01.Commands.Concrete.SetInternalFrameCommands.SetInternalFrameAsStockCartCommand;
import UI01.Commands.Concrete.SetInternalFrameCommands.SetInternalFrameAsStockCartListCommand;
import UI01.View.MainFrame;
import UI01.View.StockCartFrame;
import UI01.View.StockCartListFrame;

public class MainFrameController {
	MainFrame frame;
	GeneralMainFrameOperations generalMainPageOperations;	
	StockCartFrame stockCartFrame;
	StockCartListFrame stockCartListFrame;
	
	
	
	public MainFrameController(MainFrame frame, StockCartFrame stockCartFrame, StockCartListFrame stockCartListFrame, GeneralStockCartListOperations generalStockCartListOperations, GeneralStockCartOperations generalStockCartOperations, GeneralMainFrameOperations generalMainPageOperations) {
		this.frame = frame;
		this.stockCartFrame = stockCartFrame;
		this.stockCartListFrame = stockCartListFrame;
		this.generalMainPageOperations = generalMainPageOperations;
	}
	
	public void launch(){
		try {
			setMenuItemListeners();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void setMenuItemListeners() { 
		frame.getStockCart().addActionListener(new GeneralAction(new SetInternalFrameAsStockCartCommand(generalMainPageOperations, stockCartFrame)));
		frame.getStockCartList().addActionListener(new GeneralAction(new SetInternalFrameAsStockCartListCommand(generalMainPageOperations, stockCartListFrame)));
	}
	
	public StockCartFrame getStockCartFrame() {
		return stockCartFrame;
	}

	public void setStockCartFrame(StockCartFrame stockCartFrame) {
		this.stockCartFrame = stockCartFrame;
	}

	public StockCartListFrame getStockCartListFrame() {
		return stockCartListFrame;
	}

	public void setStockCartListFrame(StockCartListFrame stockCartListFrame) {
		this.stockCartListFrame = stockCartListFrame;
	}
}
