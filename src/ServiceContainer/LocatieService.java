/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.LocatieDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Locatie;
/**
 *
 * @author Bart
 */
public class LocatieService {
    
    private LocatieDao locatieDao;
    private Session hibSession;
    
    public void setLocatieDao(LocatieDao locatieDao){
        
        this.locatieDao = locatieDao;
    }
    
    public void addNewLocatie(Locatie newLocatie){
        hibSession = StaticContainer.getSession();
        hibSession.beginTransaction();
        locatieDao.create(newLocatie);
        hibSession.getTransaction().commit();
    }
    
    public void updateLocatie(Locatie updatedLocatie){
        hibSession = StaticContainer.getSession();
        hibSession.beginTransaction();
        locatieDao.update(updatedLocatie);
        hibSession.getTransaction().commit();
    }
    
    public Locatie getLocatieById(Long locatie_id)
    {
        hibSession = StaticContainer.getSession();
        Locatie foundLocation;
        hibSession.beginTransaction();
        foundLocation = locatieDao.retrieve(locatie_id);
        hibSession.getTransaction().commit();
        return foundLocation;
    }
    
    public List<Locatie> getAllLocaties()
    {
        hibSession = StaticContainer.getSession();
        hibSession.beginTransaction();
        List<Locatie> foundLocations = new ArrayList(locatieDao.retrieveAll());
        hibSession.getTransaction().commit();
        return foundLocations;
    }
    
    public void deleteALocatie(Locatie locatie){
        hibSession = StaticContainer.getSession();
        hibSession.beginTransaction();
        locatieDao.remove(locatie);
        hibSession.getTransaction().commit();
    }
}
