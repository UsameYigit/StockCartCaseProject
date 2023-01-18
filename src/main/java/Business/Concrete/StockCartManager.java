package Business.Concrete;

import java.util.ArrayList;

import Business.Abstract.IStockCartService;
import Data.Abstract.IStockCartRepository;
import Entity.StockCart;

public class StockCartManager implements IStockCartService{

	IStockCartRepository stockCartRepository;
	
	public StockCartManager(IStockCartRepository stockRepository) {
		this.stockCartRepository = stockRepository;
	}
	
	public ArrayList<StockCart> getAll() {
		return stockCartRepository.getAll();
	}

	public void create(StockCart entity) {
		stockCartRepository.create(entity);
	}

	public void delete(StockCart entity) {
		stockCartRepository.delete(entity);
	}

	public void update(StockCart entity) {
		stockCartRepository.update(entity);
	}

	public StockCart getByStockCode(String stockCode) {
		return stockCartRepository.getByStockCode(stockCode);
	}

	public ArrayList<StockCart> getByStockName(String stockName) {
		return stockCartRepository.getByStockName(stockName);
	}

	public ArrayList<StockCart> getByBarcode(String barcode) {
		return stockCartRepository.getByBarcode(barcode);
	}

}
