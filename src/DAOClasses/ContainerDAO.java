/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Container;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class ContainerDAO {
    private Session HibSession;
    
    public ContainerDAO(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void createNewContainer(Container newContainer){
        HibSession.save(newContainer);
    }
    
    public void updateContainer(Container updatedContainer){
        HibSession.update(updatedContainer);
    }
    
    public Object getContainer(Long container_id){
        return HibSession.get(Container.class, container_id);
    }
    
    public List<Container> getAllContainers(){
        return HibSession.createQuery("from Container").list();
    }
    
    public void deleteContainer(Container deleteContainer){
        HibSession.delete(deleteContainer);
    }
}
