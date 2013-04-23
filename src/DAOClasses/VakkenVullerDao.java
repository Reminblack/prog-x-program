/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOClasses;

import java.util.List;
import supermarktmanager.Persoon;
import supermarktmanager.VakkenVuller;
import supermarktmanager.newHibernateUtil;

/**
 *
 * @author Bart
 */
public class VakkenVullerDao implements PersoonDao<VakkenVuller>{
    
    public VakkenVullerDao(){
    }
    
    @Override
    public void createNewPersoon(VakkenVuller newBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newBakker);
    }

    @Override
    public void updatePersoon(VakkenVuller updatedBakker) {
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedBakker);
    }

    @Override
    public VakkenVuller getPersoon(Long Bakker_id) {
        return (VakkenVuller)newHibernateUtil.getSessionFactory().getCurrentSession().get(Persoon.class, Bakker_id);
    }

    
    @Override
    public List<VakkenVuller> getAllPersonen(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from VakkenVuller").list();
    }

    @Override
    public void deletePersoon(VakkenVuller deletedBakker){
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
