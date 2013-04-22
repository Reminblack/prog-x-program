/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;
import supermarktmanager.*;
import java.util.List;
/**
 *
 * @author Remco
 */
public class ContainerService {
    public void createContainer(Container c){
        StaticContainer.getSession().beginTransaction();
        StaticContainer.getSession().save(c);
        StaticContainer.getSession().getTransaction().commit();
    }
    
    public void deleteContainer(Container c){
        StaticContainer.getSession().beginTransaction();
        StaticContainer.getSession().delete(c);
        StaticContainer.getSession().getTransaction().commit();
    }
    
    public void assignToLocation(Container c, Locatie l)
    {
        StaticContainer.getSession().beginTransaction();
        Locatie lTemp = c.getLocatie();
        c.getLocatie().removeContainer(c);
        c.setLocatie(l);
        l.addContainer(c);
        
        DAOContainer.session.save(l);
        DAOContainer.session.save(c);
        DAOContainer.session.save(lTemp);
        DAOContainer.session.getTransaction().commit();
    }
    
    public void addProduct(Container c, Product p){
        DAOContainer.session.beginTransaction();
        
        c.addProduct(p);
        
        DAOContainer.session.getTransaction().commit();
    }
    
    public void removeProduct(Container c, Product p){
        DAOContainer.session.beginTransaction();
        
        c.removeProduct(p);
        
        DAOContainer.session.getTransaction().commit();
    }
}
