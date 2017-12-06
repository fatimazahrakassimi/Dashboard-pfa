package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@SuppressWarnings("deprecation")
public class HibernateUtil {
 
   public static final SessionFactory sessionFactory;
   static{
	   try{
		   //création de la sessionFactory à partir de Hibernate.cfg.xml
		   sessionFactory = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory();
	   }catch(Throwable ex){
		   System.err.println("Initial SessionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
	   }
   }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	 public static Session openSession() {
        return sessionFactory.openSession();
    
	}}