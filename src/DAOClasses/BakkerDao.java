/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Bakker;
import supermarktmanager.Persoon;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class BakkerDao implements PersoonDao<Bakker> {

    public BakkerDao() {
    }

    @Override
    public void createNewPersoon(Bakker newBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newBakker);
    }

    @Override
    public void updatePersoon(Bakker updatedBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedBakker);
    }

    @Override
    public Bakker getPersoon(Long Bakker_id) {
        return (Bakker)newHibernateUtil.getSessionFactory().getCurrentSession().get(Persoon.class, Bakker_id);
    }

    
    @Override
    public List<Bakker> getAllPersonen(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Bakker").list();
    }

    @Override
    public void deletePersoon(Bakker deletedBakker){
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
