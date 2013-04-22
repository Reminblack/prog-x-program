package supermarktmanager;

import ServiceLayer.LocatieService;
import ServiceLayer.StaticContainer;
import ServiceLayer.VakkenVullerService;
import org.hibernate.SessionFactory;

public class Supermarktmanager {

    public static void main(String[] args) {
        SessionFactory sessionFactory = newHibernateUtil.getSessionFactory();
        System.out.println(sessionFactory); 
        StaticContainer.getInstance();
        VakkenVullerService vvs = (VakkenVullerService)StaticContainer.getService("VakkenVullerService");
        LocatieService lss= (LocatieService)StaticContainer.getService("LocatieService");
        Locatie newMadeLocatie = lss.getLocatieById(new Long(1));
        vvs.assignVakkenVullerToLocation(new Long(1),newMadeLocatie);
    }
}
