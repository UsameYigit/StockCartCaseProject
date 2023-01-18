package Data.Concrete;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import Data.SessionFactorySingleton;
import Data.Abstract.IStockCartRepository;
import Entity.StockCart;

public class StockCartOperations implements IStockCartRepository {

	//Create method for mysql data. Takes StockCart entity as a parameter.
	public void create(StockCart entity) {
		//Session is created for the operation, which will need SessionFactory.
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

	public void delete(StockCart entity) {
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

	public void update(StockCart entity) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			//Gets the specified StockCart, then sets with the new variables
			StockCart sc = session.find(StockCart.class, entity.getStockCode());
			sc.setBarcode(entity.getBarcode());
			sc.setDescription(entity.getDescription());
			sc.setCreationDate(entity.getCreationDate());
			sc.setStockType(entity.getStockType());
			sc.setStockName(entity.getStockName());
			sc.setTaxType(entity.getTaxType());
			sc.setUnit(entity.getUnit());
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

	public ArrayList<StockCart> getAll() {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<StockCart> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<StockCart>(session.createQuery( "FROM StockCart" ).list());
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
	
	public StockCart getByStockCode(String stockCode) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<StockCart> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<StockCart>(session.createQuery("FROM StockCart WHERE stockCode = '"+stockCode+"'").list());
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

	public ArrayList<StockCart> getByStockName(String stockName) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<StockCart> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<StockCart>(session.createQuery( "FROM StockCart WHERE stockName LIKE '%"+stockName+"%'" ).list());
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

	public ArrayList<StockCart> getByBarcode(String barcode) {
		Session session = SessionFactorySingleton.getSessionFactory().openSession();
		ArrayList<StockCart> result = null;
		try {
			session.beginTransaction();
			result = new ArrayList<StockCart>(session.createQuery( "from StockCart WHERE barcode LIKE '%"+barcode+"%'").list());
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

}
