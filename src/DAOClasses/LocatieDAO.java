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
public class LocatieDAO {
    
    private Session HibSession;
    
    public LocatieDAO(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    public void createNewLocatie(Locatie newLocation){
        HibSession.save(newLocation);
    }
    
    public void updateLocatie(Locatie updatedLocation){
        HibSession.update(updatedLocation);
    }
    
    public Object getLocatie(Long location_id){
        return HibSession.get(Locatie.class, location_id);
    }
    
    public List<Locatie> getAllLocations(){
        return HibSession.createQuery("from locatie").list();
    }
    
    public void deleteLocatie(Locatie deleteLocatie){
        HibSession.delete(deleteLocatie);
    }
}
