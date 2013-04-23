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
import supermarktmanager.Bakker;

/**
 *
 * @author Bart
 */
public class BakkerService {
    private PersoonDao PersoonDao;
    private Session hibSession;
    
    public void setBakkerDAO(Dao PersoonDao){
        this.PersoonDao = (PersoonDao)PersoonDao;
    }
    
    public void addNewBakker(Bakker newBakker){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            PersoonDao.create(newBakker);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    public void updateBakker(Bakker updatedBakker){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            PersoonDao.update(updatedBakker);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    public Bakker getBakkerById(Long bakker_id)
    {
        Bakker foundBakker = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundBakker = (Bakker)PersoonDao.retrieve(bakker_id);
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
        return foundBakker;
    }
    
    public List<Bakker> getAllBakkers()
    {
        List<Bakker> foundBakkers = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
        foundBakkers = new ArrayList(PersoonDao.retrieveAll());
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
        return foundBakkers;
    }
    
    public void deleteABakker(Bakker bakker){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            PersoonDao.remove(bakker);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
}
