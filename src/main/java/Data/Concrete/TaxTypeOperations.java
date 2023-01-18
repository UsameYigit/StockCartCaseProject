package Data.Concrete;

import java.util.ArrayList;

import org.hibernate.Session;

import Data.SessionFactorySingleton;
import Data.Abstract.ITaxTypeRepository;
import Entity.TaxType;



public class TaxTypeOperations implements ITaxTypeRepository{

	@Override
	public ArrayList<TaxType> getAll() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<TaxType> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<TaxType>(session.createQuery( "FROM TaxType" ).list());
			session.getTransaction().commit();
		}
		catch(IllegalArgumentException iae) {
			System.out.println("Illegal Argument Excepition occured.");
		}
		catch(Exception e){
			System.out.println("Exception occured.");
		}
		finally {
			session.close();
		}
		return result;
	}

	@Override
	public void create(TaxType entity) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		try {
			//Transaction starts inserts/saves the given parameter into the related table (StockCart).
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
			System.out.println("Ekleme işlemi başarıyla tamamlandı.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		finally {
			//
			session.close();
		}
	}

	@Override
	public void delete(TaxType entity) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
			System.out.println("Silme işlemi başarıyla tamamlandı.");
		}
		catch(Exception e) {
			System.out.println("Silme işlemi sırasında beklenmedik bir sıkıntı oluştu.");
		}
		finally {
			session.close();
		}
	}

	@Override
	public void update(TaxType entity) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			//Gets the specified StockCart, then sets with the new variables
			TaxType tt = session.find(TaxType.class, entity.getId());
			tt.setCode(entity.getCode());
			tt.setName(entity.getName());
			tt.setDescription(entity.getDescription());
			session.getTransaction().commit();
		}
		catch(IllegalArgumentException iae) {
			System.out.println("Illegal Argument Excepition occured.");
		}
		catch(Exception e){
			System.out.println("Exception occured.");
		}
		finally {
			session.close();
		}
	}

	@Override
	public TaxType getById(int id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<TaxType> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<TaxType>(session.createQuery("FROM TaxType WHERE id = '"+id+"'").list());
			session.getTransaction().commit();
		}
		catch(IllegalArgumentException iae) {
			System.out.println("Illegal Argument Excepition occured.");
		}
		catch(Exception e){
			System.out.println("Exception occured.");
		}
		finally {
			session.close();
		}
		
		if(!result.isEmpty())
			return result.get(0);
		else
			return null;
	}

}
