/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Remco
 */
public class DAOContainer {
    public static SessionFactory sessionFactory;
    public static Session session;
    public static BakkerDAO bakker;
    public static ContainerDAO container;
    public static KassiereDAO kassiere;
    public static LocatieDAO locatie;
    public static PersoonDAO persoon;
    public static ProductDAO product;
    public static ProductHistoryDAO history;
    public static SlagerDAO slager;
    public static VakkenVullerDAO vakkenvuller;
    public DAOContainer()
    {
    sessionFactory = newHibernateUtil.getSessionFactory();
    session = sessionFactory.getCurrentSession();
    bakker = new BakkerDAO();
    container = new ContainerDAO();
    kassiere = new KassiereDAO();
    locatie = new LocatieDAO();
    persoon = new PersoonDAO();
    product = new ProductDAO();
    history = new ProductHistoryDAO();
    slager = new SlagerDAO();
    vakkenvuller = new VakkenVullerDAO();
    }
}
