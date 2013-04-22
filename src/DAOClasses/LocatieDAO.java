/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.Session;
import supermarktmanager.*;

/**
 *
 * @author Bart
 */
public class LocatieDao implements Dao<Locatie> {
    
    private Session HibSession;
    
    public LocatieDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(Locatie newLocation){
        HibSession.save(newLocation);
    }
    
    @Override
    public void update(Locatie updatedLocation){
        HibSession.update(updatedLocation);
    }
    
    @Override
    public Locatie retrieve(Long location_id){
        return (Locatie)HibSession.get(Locatie.class, location_id);
    }
    
    @Override
    public List<Locatie> retrieveAll(){
        return HibSession.createQuery("from locatie").list();
    }
    
    @Override
    public void remove(Locatie deleteLocatie){
        HibSession.delete(deleteLocatie);
    }
}
