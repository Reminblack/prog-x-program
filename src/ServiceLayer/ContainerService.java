/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.ContainerDao;
import DAOClasses.LocatieDao;
import DAOClasses.ProductDao;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.*;

/**
 *
 * @author Remco
 */
public class ContainerService {

    private ContainerDao containerDao;
    private ProductDao productDao;
    private LocatieDao locatieDao;
    private Session hibSession;
    
    public void setContainerService(ContainerDao c, ProductDao pd, LocatieDao ld)
    {
        containerDao = c;
        productDao = pd;
        locatieDao = ld;
    }

    public void createContainer(Container c) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            
            containerDao.create(c);
            
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }

    public void deleteContainer(Container c) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            
            containerDao.remove(c);
            
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }

    public void assignToLocation(Container c, Locatie l) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            
            Locatie lTemp = c.getLocatie();
            c.getLocatie().removeContainer(c);
            c.setLocatie(l);
            l.addContainer(c);
            locatieDao.update(lTemp);
            locatieDao.update(l);
            containerDao.update(c);
            
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }

    public void addProduct(Container c, Product p) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            p.getRek().removeProduct(p);
            containerDao.update(p.getRek());
            c.addProduct(p);
            p.setRek(c);
            productDao.update(p);
            containerDao.update(c);
            
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }

    public void removeProduct(Container c, Product p) {
        try {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            
            c.removeProduct(p);
            p.setRek(null);
            containerDao.update(c);
            productDao.update(p);
            hibSession.flush();
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
        } finally {
            hibSession.close();
        }
    }
    
    public List<Container> getContent()
    {
        try {
            hibSession = ServiceLayer.StaticContainer.getSession();
            hibSession.beginTransaction();
            
            List<Container> prod = containerDao.retrieveAll();
            
            hibSession.flush();
            return prod;
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
            return null;
        } finally {
            hibSession.close();
        }
    }
    
    public Container getOneContent(Container p)
    {
        try {
            hibSession = ServiceLayer.StaticContainer.getSession();
            hibSession.beginTransaction();
            
            Container prod = containerDao.retrieve(p.getId());
            
            hibSession.flush();
            return prod;
        } catch (RuntimeException e) {
            System.out.println("Exception e has occured: " + e);
            hibSession.getTransaction().rollback();
            return null;
        } finally {
            hibSession.close();
        }
    }
}
