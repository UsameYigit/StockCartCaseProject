package Data.Concrete;

import java.util.ArrayList;

import org.hibernate.Session;

import Data.SessionFactorySingleton;
import Data.Abstract.IStockTypeRepository;
import Entity.StockType;

public class StockTypeOperations implements IStockTypeRepository{

	@Override
	public ArrayList<StockType> getAll() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<StockType> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<StockType>(session.createQuery( "FROM StockType" ).list());
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
	public void create(StockType entity) {
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
	public void delete(StockType entity) {
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
	public void update(StockType entity) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			//Gets the specified StockCart, then sets with the new variables
			StockType st = session.find(StockType.class, entity.getId());
			st.setCode(entity.getCode());
			st.setName(entity.getName());
			st.setRating(entity.getRating());
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
	public StockType getById(int id) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<StockType> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<StockType>(session.createQuery("FROM StockType WHERE id = '"+id+"'").list());
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
