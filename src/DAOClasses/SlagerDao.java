/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Persoon;
import supermarktmanager.Slager;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class SlagerDao implements PersoonDao<Slager>{
   
    public SlagerDao(){
    }
    
    @Override
    public void createNewPersoon(Slager newBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newBakker);
    }

    @Override
    public void updatePersoon(Slager updatedBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedBakker);
    }

    @Override
    public Slager getPersoon(Long Bakker_id) {
        return (Slager)newHibernateUtil.getSessionFactory().getCurrentSession().get(Persoon.class, Bakker_id);
    }

    
    @Override
    public List<Slager> getAllPersonen(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Slager").list();
    }

    @Override
    public void deletePersoon(Slager deletedBakker){
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
