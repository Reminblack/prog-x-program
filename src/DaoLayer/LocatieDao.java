/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoLayer;

import ServiceLayer.newHibernateUtil;
import Entity.Locatie;
import java.util.List;

/**
 *
 * @author Bart
 */
public class LocatieDao implements Dao<Locatie> {
     
    public LocatieDao(){
    }
    
    @Override
    public void create(Locatie newLocation){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newLocation);
    }
    
    @Override
    public void update(Locatie updatedLocation){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedLocation);
    }
    
    @Override
    public Locatie retrieve(Long location_id){
        return (Locatie)newHibernateUtil.getSessionFactory().getCurrentSession().get(Locatie.class, location_id);
    }
    
    @Override
    public List<Locatie> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Locatie").list();
    }
    
    @Override
    public void remove(Locatie deleteLocatie){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deleteLocatie);
    }
}
