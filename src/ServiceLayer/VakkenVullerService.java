/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.Dao;
import DAOClasses.VakkenVullerDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Locatie;
import supermarktmanager.VakkenVuller;

/**
 *
 * @author Bart
 */
public class VakkenVullerService {
    private VakkenVullerDao vakkenvullerDao;
    private Session hibSession;
    
    public void setVakkenVullerDao(Dao vakkenvullerDao){
        this.vakkenvullerDao = (VakkenVullerDao)vakkenvullerDao;
    }
    
    public void addNewVakkenVuller(VakkenVuller newVakkenVuller){
        try
        {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            vakkenvullerDao.createNewPersoon(newVakkenVuller);
            hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public void updateVakkenVuller(VakkenVuller updatedVakkenVuller){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            vakkenvullerDao.updatePersoon(updatedVakkenVuller);
            hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public VakkenVuller getVakkenVullerById(Long vakkenVuller_id)
    {
        VakkenVuller foundVakkenVuller = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundVakkenVuller = vakkenvullerDao.getPersoon(vakkenVuller_id);
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundVakkenVuller; 
    }
    
    public List<VakkenVuller> getAllVakkenVullers()
    {
        List<VakkenVuller> foundVakkenVullers = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundVakkenVullers = new ArrayList(vakkenvullerDao.getAllPersonen());
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundVakkenVullers;
    }
    
    public void deleteAVakkenVuller(VakkenVuller vakkenVuller){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            vakkenvullerDao.deletePersoon(vakkenVuller);
            hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public void assignVakkenVullerToLocation(VakkenVuller vakkenvuller, Locatie newLocation){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            vakkenvuller.addLocation(newLocation);
            ((LocatieService)StaticContainer.getService("LocatieService")).;
            vakkenvullerDao.update(vakkenvuller);
            hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
}
