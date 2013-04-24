/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoLayer;

import ServiceLayer.newHibernateUtil;
import Entity.Persoon;
import java.util.List;

/**
 *
 * @author Bart
 */
public class PersoonDao implements Dao<Persoon>{
    
     public PersoonDao(){
    }
    
    @Override
    public void create(Persoon newPersoon){
        newHibernateUtil.getSessionFactory().getCurrentSession().save(newPersoon);
    }
    
    @Override
    public void update(Persoon updatedPersoon){
        newHibernateUtil.getSessionFactory().getCurrentSession().update(updatedPersoon);
    }
    
    @Override
    public Persoon retrieve(Long persoon_id){
        return (Persoon)newHibernateUtil.getSessionFactory().getCurrentSession().get(Persoon.class, persoon_id);
    }
    
    @Override
    public List<Persoon> retrieveAll(){
        return newHibernateUtil.getSessionFactory().getCurrentSession().createQuery("from Persoon").list();
    }
    
    @Override
    public void remove(Persoon deletePersoon){
        newHibernateUtil.getSessionFactory().getCurrentSession().delete(deletePersoon);
    }
}
