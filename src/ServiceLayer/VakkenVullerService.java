/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DAOClasses.Dao;
import DAOClasses.PersoonDao;
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
    private PersoonDao PersoonDao;
    private Session hibSession;
    
    public void setVakkenVullerDao(Dao PersoonDao){
        this.PersoonDao = (PersoonDao)PersoonDao;
    }
    
    public void addNewVakkenVuller(VakkenVuller newVakkenVuller){
        try
        {
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            PersoonDao.create(newVakkenVuller);
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
            PersoonDao.update(updatedVakkenVuller);
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
            foundVakkenVuller = (VakkenVuller)PersoonDao.retrieve(vakkenVuller_id);
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
            foundVakkenVullers = new ArrayList(PersoonDao.retrieveAll());
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
            PersoonDao.remove(vakkenVuller);
            hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public void assignVakkenVullerToLocation(Long vakkenvuller_id, Locatie newLocation){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            VakkenVuller foundVakkenVuller = getVakkenVullerById(vakkenvuller_id);
            foundVakkenVuller.addLocation(newLocation);
            PersoonDao.update(foundVakkenVuller);
            hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
}
