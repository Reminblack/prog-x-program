/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceLayer;

import DaoLayer.Dao;
import DaoLayer.PersoonDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import Entity.Persoon;

/**
 *
 * @author Bart
 */
public class PersoonService {
    private PersoonDao persoonDao;
    private Session hibSession;
    
    protected void setDao(Dao persoonDao){
        this.persoonDao = (PersoonDao)persoonDao;
    }
    
    protected void addPersoon(Persoon newPersoon){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            persoonDao.create(newPersoon);
            hibSession.flush();
        } catch(RuntimeException e){
            e.getStackTrace();
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    protected void updatePersoon(Persoon updatedPersoon){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            persoonDao.update(updatedPersoon);
            hibSession.flush();
        } catch(RuntimeException e){
            e.getStackTrace();
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    protected Persoon getPersoonById(Long persoon_id)
    {
        Persoon foundPersoon = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundPersoon = (Persoon)persoonDao.retrieve(persoon_id);
        } catch(RuntimeException e){
            e.getStackTrace();
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
        return foundPersoon;
    }
    
    protected List<Persoon> getAllPersoons()
    {
        List<Persoon> foundPersoons = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundPersoons = new ArrayList(persoonDao.retrieveAll());
            hibSession.close();
       } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       }
        return foundPersoons;
    }
    
    protected void deleteAPersoon(Persoon persoon){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            persoonDao.remove(persoon);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           e.getStackTrace();
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
}
