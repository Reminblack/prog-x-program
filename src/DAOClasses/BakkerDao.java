/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Bakker;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class BakkerDao implements Dao<Bakker>{
   
    public BakkerDao(){
        
    }
    
    @Override
    public void create(Bakker newBakker){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newBakker);
    }
    
    @Override
    public void update(Bakker updatedBakker){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedBakker);
    }
    
    @Override
    public Bakker retrieve(Long Bakker_id){
        return (Bakker) newHibernateUtil.getSessionFactory().getCurrentSession().get(Bakker.class, Bakker_id);
    }
    
    @Override
    public List<Bakker> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Bakker").list();
    }
    
    @Override
    public void remove(Bakker deletedBakker){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedBakker);
    }
}
