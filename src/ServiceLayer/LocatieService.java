/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.Dao;
import DAOClasses.LocatieDao;
import DAOClasses.PersoonDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Locatie;
import supermarktmanager.Persoon;
/**
 *
 * @author Bart
 */
public class LocatieService {
    
    private LocatieDao locatieDao;
    private PersoonDao persoonDao;
    private Session hibSession;
    
    public void setLocatieDao(Dao locatieDao, PersoonDao pda){
        this.locatieDao = (LocatieDao)locatieDao;
        persoonDao = pda;
    }
    
    public void createLocatie(Locatie newLocatie){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            locatieDao.create(newLocatie);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public void updateLocatie(Locatie updatedLocatie){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            locatieDao.update(updatedLocatie);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public Locatie getLocatieById(Long locatie_id)
    {
        Locatie foundLocatie = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundLocatie = locatieDao.retrieve(locatie_id);
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundLocatie;
    }
    
    public List<Locatie> getAllLocaties()
    {
        List<Locatie> foundLocations = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundLocations = new ArrayList(locatieDao.retrieveAll());
            hibSession.getTransaction().commit();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundLocations;
    }
    
    public void deleteALocatie(Locatie locatie){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            locatieDao.remove(locatie);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public void assignEmployee(Persoon p, Locatie l)
    {
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            l.addWerknemer(p);
            p.addLocatie(l);
            locatieDao.update(l);
            persoonDao.updatePersoon(p);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public void removeEmployee(Persoon p, Locatie l)
    {
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            l.removeWerknemer(p);
            p.removeLocatie(l);
            //Update persoon (add location persoonObj)
            //Update Location (add persoon LocationObj)
            //Save persoon changes (persoonservice.save(persoon P))
            //Save location changes (this.service.save(Location l))
            locatieDao.update(l);
            persoonDao.updatePersoon(p);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
}
