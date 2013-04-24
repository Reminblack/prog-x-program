/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoLayer;

import java.util.List;
import Entity.Container;
import ServiceLayer.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class ContainerDao implements Dao<Container>{
    
    public ContainerDao(){
    }
    
    @Override
    public void create(Container newObject){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newObject);
    }
    
    @Override
    public void update(Container updatedObject){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedObject);
    }
    
    @Override
    public Container retrieve(Long container_id){
        return (Container)newHibernateUtil.getSessionFactory().getCurrentSession().get(Container.class, container_id);
    }
    
    @Override
    public List<Container> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Container").list();
    }
    
    @Override
    public void remove(Container deleteContainer){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deleteContainer);
    }
}
