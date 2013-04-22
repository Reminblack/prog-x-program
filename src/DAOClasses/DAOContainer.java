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
    public static BakkerDao bakker;
    public static ContainerDao container;
    public static KassiereDao kassiere;
    public static LocatieDao locatie;
    public static ProductDao product;
    public static ProductHistoryDao history;
    public static SlagerDao slager;
    public static VakkenVullerDao vakkenvuller;
    public DAOContainer()
    {
    sessionFactory = newHibernateUtil.getSessionFactory();
    session = sessionFactory.getCurrentSession();
    bakker = new BakkerDao();
    container = new ContainerDao();
    kassiere = new KassiereDao();
    locatie = new LocatieDao();
    product = new ProductDao();
    history = new ProductHistoryDao();
    slager = new SlagerDao();
    vakkenvuller = new VakkenVullerDao();
    }
}
