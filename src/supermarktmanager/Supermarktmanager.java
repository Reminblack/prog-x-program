package supermarktmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Supermarktmanager {

    public static void main(String[] args) {
        SessionFactory sessionFactory = newHibernateUtil.getSessionFactory();
        System.out.println(sessionFactory); 
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product product = new Product();
        product.setAantal(200);
        product.setMerk("OMO");
        product.setNaam("OMO waspoeder");
        product.setPrijs(12.25f);
        session.save(product);
        
        session.getTransaction().commit();
    }
}
