/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;
import DaoLayer.ContainerDao;
import DaoLayer.Dao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import Entity.Container;
import Entity.Locatie;
import Entity.Product;
/**
 *
 * @author Remco
 */
public class ContainerService {
    private ContainerDao containerDao;
    private LocatieService locatieService;
    private Session hibSession;
    
    public void setContainerDAO(Dao containerDao){
        this.containerDao = (ContainerDao)containerDao;
    }
    
    public void createContainer(Container newContainer){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            containerDao.create(newContainer);
            hibSession.getTransaction().commit();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           e.getStackTrace();
           hibSession.getTransaction().rollback();
       }
    }
    
    public void updateContainer(Container updatedContainer){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            containerDao.update(updatedContainer);
            hibSession.getTransaction().commit();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       }
    }
    
    public Container getContainerById(Long container_id)
    {
        Container foundContainer = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundContainer = (Container)containerDao.retrieve(container_id);
            hibSession.close();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       }
        return foundContainer;
    }
    
    public List<Container> getAllContainers()
    {
        List<Container> foundContainers = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundContainers = new ArrayList(containerDao.retrieveAll());
            hibSession.close();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       }
        return foundContainers;
    }
    
    public void deleteAContainer(Container container){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            containerDao.remove(container);
            hibSession.getTransaction().commit();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           e.getStackTrace();
           hibSession.getTransaction().rollback();
       }
    }
    
    public void assignToLocation(Container currentContainer, Locatie newLocation)
    {
        Locatie currentLocation = currentContainer.getLocatie();
        if(currentLocation != null){
            currentLocation.removeContainer(currentContainer);
            currentContainer.setLocatie(newLocation);
            newLocation.addContainer(currentContainer);
        }
        StaticContainer.getSession().beginTransaction();
        locatieService.updateLocatie(newLocation);
        locatieService.updateLocatie(currentLocation);
        containerDao.update(currentContainer);
        StaticContainer.getSession().getTransaction().commit();
    }
    
    public void addProduct(Container container, Product product){
        container.addProduct(product);
    }
    
    public void removeProduct(Container container, Product product){
        container.removeProduct(product);
    }
}
