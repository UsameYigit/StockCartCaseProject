package Business.Abstract;

import java.util.ArrayList;

import Entity.StockType;

public interface IStockTypeService {
	public ArrayList<StockType> getAll();
	public void create(StockType entity);
	public void delete(StockType entity);
	public void update(StockType entity);
	public StockType getById(int id);
}
