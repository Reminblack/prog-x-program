package supermarktmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Supermarktmanager {

    public static void main(String[] args) {
        SessionFactory sessionFactory = newHibernateUtil.getSessionFactory();
        System.out.println(sessionFactory); 
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        DAOClasses.PersoonDAO pdao = new DAOClasses.PersoonDAO();
        pdao.createNewPersoon(new VakkenVuller());
        System.out.println(pdao.getPersoon());
        session.getTransaction().commit();
    }
}
