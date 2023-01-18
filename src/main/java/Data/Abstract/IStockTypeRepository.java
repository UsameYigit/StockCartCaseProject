package Data.Abstract;

import Entity.StockType;

public interface IStockTypeRepository extends IBaseRepository<StockType>{
	public StockType getById(int id);
}
