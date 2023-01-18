package UI01.Controller;

import Business.Abstract.IStockCartService;
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
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	private void setButtonListeners() { 
//		
//	}
	
	
}
