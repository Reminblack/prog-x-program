/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.classic.Session;
import supermarktmanager.Bakker;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class BakkerDao implements Dao<Bakker>{
   
    private Session HibSession;
    
    public BakkerDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(Bakker newBakker){
        HibSession.save(newBakker);
    }
    
    @Override
    public void update(Bakker updatedBakker){
        HibSession.update(updatedBakker);
    }
    
    @Override
    public Bakker retrieve(Long Bakker_id){
        return (Bakker) HibSession.get(Bakker.class, Bakker_id);
    }
    
    @Override
    public List<Bakker> retrieveAll(){
        return HibSession.createQuery("from Bakker").list();
    }
    
    @Override
    public void remove(Bakker deletedBakker){
        HibSession.delete(deletedBakker);
    }
}
