/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Slager;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class SlagerDao implements Dao<Slager>{
    
    private Session HibSession;
    
    public SlagerDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(Slager newSlager){
        HibSession.save(newSlager);
    }
    
    @Override
    public void update(Slager updatedSlager){
        HibSession.update(updatedSlager);
    }
    
    @Override
    public Slager retrieve(Long slager_id){
        return (Slager) HibSession.get(Slager.class, slager_id);
    }
    
    @Override
    public List<Slager> retrieveAll(){
        return HibSession.createQuery("from Slager").list();
    }
    
    @Override
    public void remove(Slager deletedSlager){
        HibSession.delete(deletedSlager);
    }
}
