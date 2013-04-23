/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Kassiere;
import supermarktmanager.Persoon;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class KassiereDao implements PersoonDao<Kassiere>{
    
    public KassiereDao(){
    }
    
    @Override
    public void createNewPersoon(Kassiere newBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newBakker);
    }

    @Override
    public void updatePersoon(Kassiere updatedBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedBakker);
    }

    @Override
    public Kassiere getPersoon(Long Bakker_id) {
        return (Kassiere)newHibernateUtil.getSessionFactory().getCurrentSession().get(Persoon.class, Bakker_id);
    }

    
    @Override
    public List<Kassiere> getAllPersonen(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Kassiere").list();
    }

    @Override
    public void deletePersoon(Kassiere deletedBakker){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletedBakker);
    }

    @Override
    public void create(Persoon newObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Persoon updatedObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Persoon retrieve(Long object_id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Persoon> retrieveAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void remove(Persoon removeObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
