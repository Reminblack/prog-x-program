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
import supermarktmanager.Slager;

/**
 *
 * @author Bart
 */
public class SlagerService {
    private PersoonDao PersoonDao;
    private Session hibSession;
    
    public void setSlagerDAO(Dao PersoonDao){
        this.PersoonDao = (PersoonDao)PersoonDao;
    }
    
    public void addNewSlager(Slager newSlager){
        hibSession = StaticContainer.getSession();
       try{
            hibSession.beginTransaction();
            PersoonDao.create(newSlager);
            hibSession.flush();
       } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    public void updateSlager(Slager updatedSlager){
       hibSession = StaticContainer.getSession();
       try{
            hibSession.beginTransaction();
            PersoonDao.update(updatedSlager);
            hibSession.flush();
       } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    public Slager getSlagerById(Long slager_id)
    {
       Slager foundSlager = null;
       hibSession = StaticContainer.getSession();
       try{
            hibSession.beginTransaction();
            foundSlager = (Slager)PersoonDao.retrieve(slager_id);
       } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
       return foundSlager;
    }
    
    public List<Slager> getAllSlagers()
    {
        List<Slager> foundSlagers = null;
        hibSession = StaticContainer.getSession();
        try{
             hibSession.beginTransaction();
             foundSlagers = new ArrayList(PersoonDao.retrieveAll());
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundSlagers;
    }
    
    public void deleteASlager(Slager slager){
        hibSession = StaticContainer.getSession();
        try{
             hibSession.beginTransaction();
             PersoonDao.remove(slager);
             hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
}
