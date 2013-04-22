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
    
    public KassiereDao(){
    }
    
    @Override
    public void create(Kassiere newKassiere){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newKassiere);
    }
    
    @Override
    public void update(Kassiere updatedKassiere){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedKassiere);
    }
    
    @Override
    public Kassiere retrieve(Long kassiere_id){
        return (Kassiere) newHibernateUtil.getSessionFactory().getCurrentSession().get(Kassiere.class, kassiere_id);
    }
    
    @Override
    public List<Kassiere> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Kassiere").list();
    }
    
    @Override
    public void remove(Kassiere deletedKassiere){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedKassiere);
    }
}
