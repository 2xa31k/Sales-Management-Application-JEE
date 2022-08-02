package util;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;

public class HibernateUtil {

	public static final SessionFactory sessionFactory ;

	static {
		try {
			 Configuration cfg=new Configuration();
			    cfg.configure("hibernate.cfg.xml");
			sessionFactory = cfg.buildSessionFactory();
			
			
		}catch(Throwable ex) {
			System.err.println("Initial SessionFactory creation Failed."+ ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
}
