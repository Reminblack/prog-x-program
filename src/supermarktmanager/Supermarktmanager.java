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
        DAOClasses.VakkenVullerDAO vvdao = new DAOClasses.VakkenVullerDAO();
        for(Persoon employee : vvdao.getAllVakkenVullers()){
            System.out.println(employee);
        }
        session.getTransaction().commit();
    }
}
