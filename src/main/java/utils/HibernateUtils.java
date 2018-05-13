package utils;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtils {
	
	
	private static SessionFactory sessionFactory = null;
	
	public static SessionFactory getSessionFactory() throws Exception{
		if(sessionFactory==null){
			sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static void shutDown() throws Exception{
		getSessionFactory().close();
	}
}
