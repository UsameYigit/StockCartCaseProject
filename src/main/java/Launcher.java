
import Business.Concrete.StockCartManager;
import Business.Concrete.StockTypeManager;
import Business.Concrete.TaxTypeManager;
import Data.Concrete.StockCartOperations;
import Data.Concrete.StockTypeOperations;
import Data.Concrete.TaxTypeOperations;
import UI01.Controller.GeneralStockCartListOperations;
import UI01.Controller.GeneralStockCartOperations;
import UI01.Controller.MainFrameController;
import UI01.Controller.StockCartFrameController;
import UI01.Controller.StockCartListFrameController;
import UI01.View.MainFrame;
import UI01.View.StockCartFrame;
import UI01.View.StockCartListFrame;

public class Launcher {
	public static void main(String[] args) {
		//Frames
		MainFrame frame = new MainFrame();
		StockCartFrame stockCartFrame = new StockCartFrame();
		StockCartListFrame stockCartListFrame = new StockCartListFrame();
		
		//Managers
		StockCartManager scm = new StockCartManager(new StockCartOperations());
		StockTypeManager stm = new StockTypeManager(new StockTypeOperations());
		TaxTypeManager ttm = new TaxTypeManager(new TaxTypeOperations());
		
		GeneralStockCartOperations gsco = new GeneralStockCartOperations(stockCartFrame, scm, stm, ttm);
		StockCartFrameController scfc = new StockCartFrameController(stockCartFrame, scm, gsco);
		
		scfc.launch();
		
		GeneralStockCartListOperations gsclo = new GeneralStockCartListOperations(stockCartListFrame, scm);
		StockCartListFrameController sclfc = new StockCartListFrameController(stockCartListFrame, scm, gsclo);
		
		sclfc.launch();
		
		MainFrameController mainFrameController = new MainFrameController(frame, stockCartFrame, stockCartListFrame, gsclo, gsco);
		mainFrameController.launch();
		
	}
}
