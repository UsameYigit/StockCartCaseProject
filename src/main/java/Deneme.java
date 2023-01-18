import java.time.LocalDateTime;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Business.Concrete.StockCartManager;
import Data.SessionFactorySingleton;
import Data.Concrete.StockCartOperations;
import Entity.StockCart;

public class Deneme {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure(".\\hibernate.cfg.xml").addAnnotatedClass(StockCart.class).
                buildSessionFactory();
	}
}
