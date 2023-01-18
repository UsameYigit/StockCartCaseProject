package Data;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Entity.StockCart;
import Entity.StockType;
import Entity.TaxType;

//Singleton for SesssionFactory 
public class SessionFactorySingleton {
	//SessionFactory variable
	public static SessionFactory sessionFactory;
	
	//Made private to prevent from taking instance
	private SessionFactorySingleton() {
		
	}
	
	//A method where if it's null an instance is created for sessionFactory 
	public static synchronized  SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				//instance uses hibernate.cfg.xml to create connection with mysql and adds StockCart table to database named as stock(db name can be changed)
				sessionFactory = new Configuration().configure(".\\hibernate.cfg.xml").addAnnotatedClass(StockCart.class).addAnnotatedClass(StockType.class).addAnnotatedClass(TaxType.class).
	                    buildSessionFactory();
			}
			catch(HibernateException he) {
				System.out.println("Veri ile bağlantıda teknir bir sıkıntı oluştu.");
			}
		}
		return sessionFactory;
	}
}
