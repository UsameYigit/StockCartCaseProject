package Business.Abstract;

import java.util.ArrayList;

import Entity.TaxType;

public interface ITaxTypeService {
	public ArrayList<TaxType> getAll();
	public void create(TaxType entity);
	public void delete(TaxType entity);
	public void update(TaxType entity);
	public TaxType getById(int id);
}
