package Business.Concrete;

import java.util.ArrayList;

import Business.Abstract.ITaxTypeService;
import Data.Abstract.ITaxTypeRepository;
import Entity.TaxType;

public class TaxTypeManager implements ITaxTypeService{
	
	ITaxTypeRepository taxTypeRepository;
	
	public TaxTypeManager(ITaxTypeRepository taxTypeRepository) {
		this.taxTypeRepository = taxTypeRepository;
	}
	
	@Override
	public ArrayList<TaxType> getAll() {
		return taxTypeRepository.getAll();
	}

	@Override
	public void create(TaxType entity) {
		taxTypeRepository.create(entity);
	}

	@Override
	public void delete(TaxType entity) {
		taxTypeRepository.delete(entity);
	}

	@Override
	public void update(TaxType entity) {
		taxTypeRepository.update(entity);
	}

	@Override
	public TaxType getById(int id) {
		return taxTypeRepository.getById(id);
	}

}
