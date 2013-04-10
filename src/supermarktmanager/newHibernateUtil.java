package supermarktmanager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class newHibernateUtil {
// The sessionFactory object
    private static SessionFactory sessionFactory;
// Disables instantiation of HibernateUtil constructor
    private newHibernateUtil() {
    }
// Needed for clients to get the sessionFactory object
    public static SessionFactory getSessionFactory() {
// Initialize sessionFactory on first call
        if (sessionFactory == null) {
//            Configuration configuration = new Configuration().configure();
//            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        return sessionFactory;
    }
}