package Business.Concrete;

import java.util.ArrayList;

import Business.Abstract.IStockTypeService;
import Data.Abstract.IStockTypeRepository;
import Entity.StockType;

public class StockTypeManager implements IStockTypeService{

	IStockTypeRepository stockTypeRepository;
	
	public StockTypeManager(IStockTypeRepository stockTypeRepository) {
		this.stockTypeRepository = stockTypeRepository;
	}
	
	@Override
	public ArrayList<StockType> getAll() {
		return stockTypeRepository.getAll();
	}

	@Override
	public void create(StockType entity) {
		stockTypeRepository.create(entity);
	}

	@Override
	public void delete(StockType entity) {
		stockTypeRepository.delete(entity);
	}

	@Override
	public void update(StockType entity) {
		stockTypeRepository.update(entity);
	}

	@Override
	public StockType getById(int id) {
		return stockTypeRepository.getById(id);
	}

}
