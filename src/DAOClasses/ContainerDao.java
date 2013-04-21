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
public class ContainerDao implements Dao<Container>{
    private Session HibSession;
    
    public ContainerDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(Container newObject){
        HibSession.save(newObject);
    }
    
    @Override
    public void update(Container updatedObject){
        HibSession.update(updatedObject);
    }
    
    @Override
    public Container retrieve(Long container_id){
        return (Container)HibSession.get(Container.class, container_id);
    }
    
    @Override
    public List<Container> retrieveAll(){
        return HibSession.createQuery("from Container").list();
    }
    
    @Override
    public void remove(Container deleteContainer){
        HibSession.delete(deleteContainer);
    }
}
