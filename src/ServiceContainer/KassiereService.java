/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ServiceContainer;

import DAOClasses.Dao;
import DAOClasses.KassiereDao;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import supermarktmanager.Kassiere;

/**
 *
 * @author Bart
 */
public class KassiereService {
    private KassiereDao kassiereDao;
    private Session hibSession;
    
    public void setKassiereDAO(Dao kassiereDao){
        this.kassiereDao = (KassiereDao)kassiereDao;
    }
    
    public void addNewKassiere(Kassiere newKassiere){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            kassiereDao.create(newKassiere);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
       } finally{
           hibSession.close();
       }
    }
    
    public void updateKassiere(Kassiere updatedKassiere){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            kassiereDao.update(updatedKassiere);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
    
    public Kassiere getKassiereById(Long kassiere_id)
    {
        Kassiere foundKassiere = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundKassiere = kassiereDao.retrieve(kassiere_id);
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundKassiere;
    }
    
    public List<Kassiere> getAllKassieres()
    {
        List<Kassiere> foundKassieres = null;
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            foundKassieres = new ArrayList(kassiereDao.retrieveAll());
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
        return foundKassieres;
    }
    
    public void deleteAKassiere(Kassiere kassiere){
        try{
            hibSession = StaticContainer.getSession();
            hibSession.beginTransaction();
            kassiereDao.remove(kassiere);
            hibSession.flush();
        } catch(RuntimeException e){
           System.out.println("Exception e has occured: "+e);
           hibSession.getTransaction().rollback();
        } finally{
            hibSession.close();
        }
    }
}
