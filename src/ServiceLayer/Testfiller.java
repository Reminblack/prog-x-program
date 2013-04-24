package ServiceLayer;

import Entity.Container;
import Entity.Locatie;
import Entity.Persoon;
import Entity.Product;
import Entity.ProductHistory;
import Entity.VakkenVuller;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Testfiller {

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


        Locatie locatie = new Locatie();

        Container container = new Container();
        container.setType("Schappenrek 1 rij 1");
        container.setLocatie(locatie);

        VakkenVuller vakkenvuller = new VakkenVuller();
        vakkenvuller.setMemberName("Hans de Vakkenvuller");
        vakkenvuller.addLocation(locatie);

        locatie.addWerknemer(vakkenvuller);
        
        
        ProductHistory history = new ProductHistory();
        history.setProductId(product);
        
        session.save(product);
        session.save(container);
        session.save(vakkenvuller);
        session.save(locatie);
        session.save(history);

        session.getTransaction().commit();
    }
}
