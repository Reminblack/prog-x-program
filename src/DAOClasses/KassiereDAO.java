/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import org.hibernate.classic.Session;
import supermarktmanager.Kassiere;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class KassiereDao implements Dao<Kassiere>{
    
    private Session HibSession;
    
    public KassiereDao(){
        HibSession = newHibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void create(Kassiere newKassiere){
        HibSession.save(newKassiere);
    }
    
    @Override
    public void update(Kassiere updatedKassiere){
        HibSession.update(updatedKassiere);
    }
    
    @Override
    public Kassiere retrieve(Long kassiere_id){
        return (Kassiere) HibSession.get(Kassiere.class, kassiere_id);
    }
    
    @Override
    public List<Kassiere> retrieveAll(){
        return HibSession.createQuery("from Kassiere").list();
    }
    
    @Override
    public void remove(Kassiere deletedKassiere){
        HibSession.delete(deletedKassiere);
    }
}
