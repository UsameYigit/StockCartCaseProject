package Data.Abstract;

import java.util.ArrayList;

import Entity.StockCart;

//Repository for StockCart operations
public interface IStockCartRepository extends IBaseRepository<StockCart> {
	public StockCart getByStockCode(String stockCode);
	public ArrayList<StockCart> getByStockName(String stockName);
	public ArrayList<StockCart> getByBarcode(String barcode);
}
