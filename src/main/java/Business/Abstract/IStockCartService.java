package Business.Abstract;

import java.util.ArrayList;

import Entity.StockCart;

public interface IStockCartService {
	public ArrayList<StockCart> getAll();
	public void create(StockCart entity);
	public void delete(StockCart entity);
	public void update(StockCart entity);
	public StockCart getByStockCode(String stockCode);
	public ArrayList<StockCart> getByStockName(String stockName);
	public ArrayList<StockCart> getByBarcode(String barcode);
	public StockCart getNextItem(String stockCode);
	public StockCart getPreviousItem(String stockCode);
	public StockCart getLastItem();
	public StockCart getFirstItem();
}
