/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.Dao;
import DAOClasses.SlagerDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Slager;

/**
 *
 * @author Bart
 */
public class SlagerService {
    private SlagerDao slagerDao;
    private Session hibSession;
    
    public void setSlagerDAO(Dao slagerDao){
        this.slagerDao = (SlagerDao)slagerDao;
    }
    
    public void addNewSlager(Slager newSlager){
        hibSession = StaticContainer.getSession();
       try{
            hibSession.beginTransaction();
            slagerDao.create(newSlager);
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
            slagerDao.update(updatedSlager);
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
            foundSlager = slagerDao.retrieve(slager_id);
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
             foundSlagers = new ArrayList(slagerDao.retrieveAll());
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
             slagerDao.remove(slager);
             hibSession.flush();
        } catch(RuntimeException e){
            System.out.println("Exception e has occured: "+e);
            hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
}
