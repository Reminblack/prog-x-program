package supermarktmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Supermarktmanager {

    public static void main(String[] args) {
        SessionFactory sessionFactory = newHibernateUtil.getSessionFactory();
        System.out.println(sessionFactory); 
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //session.save(new Product("tfsdafsdafs"));
        
        session.getTransaction().commit();
    }
}
