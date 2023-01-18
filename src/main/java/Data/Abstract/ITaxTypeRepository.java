package Data.Abstract;

import Entity.TaxType;

public interface ITaxTypeRepository extends IBaseRepository<TaxType> {
	public TaxType getById(int id);
}
