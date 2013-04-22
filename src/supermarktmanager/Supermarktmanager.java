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


        Locatie locatie = new Locatie();

        Container container = new Container();
        container.setType("Schappenrek 1 rij 1");
        container.setLocatie(locatie);

        Persoon vakkenvuller = new VakkenVuller();
        vakkenvuller.setMemberName("Hans de Vakkenvuller");
        vakkenvuller.werkplekken.add(locatie);

        locatie.werkplekken.add(vakkenvuller);
        
        ProductHistory history = new ProductHistory();
        history.setProductId(product);
        
        session.save(product);
        session.save(container);
        session.save(vakkenvuller);
        session.save(locatie);

        session.getTransaction().commit();
    }
}
