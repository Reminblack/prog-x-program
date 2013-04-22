/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Slager;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class SlagerDao implements Dao<Slager>{
   
    public SlagerDao(){
    }
    
    @Override
    public void create(Slager newSlager){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newSlager);
    }
    
    @Override
    public void update(Slager updatedSlager){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedSlager);
    }
    
    @Override
    public Slager retrieve(Long slager_id){
        return (Slager) newHibernateUtil.getSessionFactory().getCurrentSession().get(Slager.class, slager_id);
    }
    
    @Override
    public List<Slager> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Slager").list();
    }
    
    @Override
    public void remove(Slager deletedSlager){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedSlager);
    }
}
